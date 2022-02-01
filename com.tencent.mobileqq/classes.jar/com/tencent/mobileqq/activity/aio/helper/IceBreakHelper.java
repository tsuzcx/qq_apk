package com.tencent.mobileqq.activity.aio.helper;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gamecenter.msginfo.GameDetailInfo;
import com.tencent.mobileqq.qqexpand.chat.ILimitChatMatchInfoHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakShow;
import com.tencent.mobileqq.relationx.icebreaking.IIceBreakHotPicCallback;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingMng;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingUtil;
import com.tencent.mobileqq.relationx.icebreaking.OnIceBreakChangeListener;
import com.tencent.mobileqq.relationx.icebreaking.bean.IceBreakCmShowData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.XPanelContainer.OnGoingToShowPanelListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class IceBreakHelper
  implements View.OnClickListener, ILifeCycleHelper, OnIceBreakChangeListener, XPanelContainer.OnGoingToShowPanelListener
{
  private static final HashMap<String, Integer> e = new HashMap();
  AIOIceBreakShow a;
  BaseChatPie b;
  Context c;
  QQAppInterface d;
  private int f;
  private String g;
  private JSONObject h;
  private IIceBreakHotPicCallback i = new IceBreakHelper.1(this);
  
  IceBreakHelper(BaseChatPie paramBaseChatPie)
  {
    this.b = paramBaseChatPie;
    this.c = paramBaseChatPie.e;
    this.d = paramBaseChatPie.d;
  }
  
  private JSONObject a(JSONArray paramJSONArray, IceBreakHelper.CMActionCategory paramCMActionCategory)
  {
    JSONObject localJSONObject1 = new JSONObject();
    int j = 0;
    while (j < paramJSONArray.length())
    {
      JSONObject localJSONObject2 = paramJSONArray.getJSONObject(j);
      int k = IceBreakHelper.6.a[paramCMActionCategory.ordinal()];
      if (k != 1)
      {
        if (k != 2)
        {
          if (k != 3)
          {
            if ((k == 4) && (localJSONObject2.optString("key").equals("gif_group_action_3d")))
            {
              localJSONObject1.put("actionId", localJSONObject2.optString("value", ""));
              return localJSONObject1;
            }
          }
          else if (localJSONObject2.optString("key").equals("gif_group_action_2d"))
          {
            localJSONObject1.put("actionId", localJSONObject2.optString("value", ""));
            return localJSONObject1;
          }
        }
        else if (localJSONObject2.optString("key").equals("gif_c2c_action_3d"))
        {
          localJSONObject1.put("actionId", localJSONObject2.optString("value", ""));
          return localJSONObject1;
        }
      }
      else if (localJSONObject2.optString("key").equals("gif_c2c_action_2d"))
      {
        localJSONObject1.put("actionId", localJSONObject2.optString("value", ""));
        return localJSONObject1;
      }
      j += 1;
    }
    return null;
  }
  
  private JSONObject a(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = paramJSONObject.optString("actionId");
      if (paramJSONObject == null) {
        return null;
      }
      paramJSONObject = paramJSONObject.split(",");
      localObject = new ArrayList();
      int j = 0;
      while (j < paramJSONObject.length)
      {
        ((ArrayList)localObject).add(j, Integer.valueOf(Integer.parseInt(paramJSONObject[j])));
        j += 1;
      }
      j = ((Integer)((ArrayList)localObject).get(new Random().nextInt(((ArrayList)localObject).size()))).intValue();
      paramJSONObject = new JSONObject();
      paramJSONObject.put("actionId", j);
      localObject = ((IApolloDaoManagerService)this.d.getRuntimeService(IApolloDaoManagerService.class, "all")).findActionById(j);
      if (localObject == null) {
        return null;
      }
      paramJSONObject.put("actionType", ((ApolloActionData)localObject).actionType);
      paramJSONObject.put("name", ((ApolloActionData)localObject).actionName);
      paramJSONObject.put("type", ((ApolloActionData)localObject).personNum);
      return paramJSONObject;
    }
    catch (Exception paramJSONObject)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reconstruct json fail e =");
      ((StringBuilder)localObject).append(paramJSONObject.toString());
      QLog.e("IceBreakHelper", 1, ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  private void a(List<IStickerRecEmoticon> paramList)
  {
    Object localObject = this.h;
    if ((localObject != null) && (paramList != null))
    {
      localObject = new IceBreakCmShowData((JSONObject)localObject);
      paramList.add(localObject);
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("insertCmShowData: ");
        paramList.append(((IceBreakCmShowData)localObject).n().toString());
        QLog.d("IceBreakHelper", 2, paramList.toString());
      }
    }
  }
  
  private boolean a(int paramInt, String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    int j = ((IceBreakingMng)this.d.getManager(QQManagerFactory.ICE_BREAKING_MNG)).a(paramString, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("IceBreakHelper", 2, String.format("checkNeedShowImmediately, sessionType: %s, sessionUin: %s, type: %s", new Object[] { Integer.valueOf(paramInt), paramString, Integer.valueOf(j) }));
    }
    if (j != -1) {
      bool1 = true;
    }
    return bool1;
  }
  
  private JSONObject b()
  {
    try
    {
      Object localObject = FileUtils.readFileToString(new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/action_v730.json"));
      if (localObject != null)
      {
        localObject = new JSONObject((String)localObject).optJSONObject("commonConfig");
        if (localObject == null)
        {
          QLog.e("IceBreakHelper", 1, "commonConfig not in 730json");
          return null;
        }
        localObject = ((JSONObject)localObject).optJSONArray("table_kvmap");
        if (localObject == null)
        {
          QLog.e("IceBreakHelper", 1, "kvMap not in 730json");
          return null;
        }
        int j = ((IApolloManagerService)this.d.getRuntimeService(IApolloManagerService.class, "all")).getCmShowStatus(this.d.getCurrentUin());
        if (j == 2)
        {
          if (this.b.aK()) {
            return a((JSONArray)localObject, IceBreakHelper.CMActionCategory.C2C3D);
          }
          return a((JSONArray)localObject, IceBreakHelper.CMActionCategory.TROOP3D);
        }
        if (j == 1)
        {
          if (this.b.aK()) {
            return a((JSONArray)localObject, IceBreakHelper.CMActionCategory.C2C2D);
          }
          return a((JSONArray)localObject, IceBreakHelper.CMActionCategory.TROOP2D);
        }
      }
      else
      {
        QLog.e("IceBreakHelper", 1, "v730.json not exist");
        return null;
      }
    }
    catch (Exception localException)
    {
      QLog.e("IceBreakHelper", 1, "parse730Json Exception:", localException);
      return null;
    }
    catch (IOException localIOException)
    {
      QLog.e("IceBreakHelper", 1, "read json fail e =", localIOException);
      return null;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("IceBreakHelper", 1, "parse json fail e =", localJSONException);
    }
    return null;
    return localJSONException;
  }
  
  private void c()
  {
    e.put("1104466820", Integer.valueOf(12));
    e.put("1106467070", Integer.valueOf(13));
  }
  
  public int a()
  {
    if (e.size() == 0) {
      c();
    }
    int k = 1;
    Object localObject = this.b;
    int j = k;
    if ((localObject instanceof GameMsgChatPie))
    {
      localObject = ((GameMsgChatPie)localObject).bH();
      j = k;
      if (localObject != null)
      {
        if (e.get(((GameDetailInfo)localObject).c) != null) {
          return ((Integer)e.get(((GameDetailInfo)localObject).c)).intValue();
        }
        j = 14;
      }
    }
    return j;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AIOIceBreakShow localAIOIceBreakShow = this.a;
    if ((localAIOIceBreakShow != null) && (paramInt2 == 0)) {
      localAIOIceBreakShow.a(false);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramAbsListView = this.a;
    if (paramAbsListView != null) {
      paramAbsListView.a();
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IceBreakHelper", 2, String.format("onAddIceBreak uin: %s, isTroop: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) }));
    }
    int j = this.b.ah.a;
    String str = this.b.ah.b;
    if (!IceBreakingUtil.a(this.d, j, str)) {
      return;
    }
    if (!TextUtils.isEmpty(str))
    {
      if (!str.equals(paramString)) {
        return;
      }
      if (((paramBoolean) && (IceBreakingUtil.c(j))) || ((!paramBoolean) && (IceBreakingUtil.b(j))) || (IceBreakingUtil.d(j)) || (IceBreakingUtil.e(j))) {
        this.b.j().post(new IceBreakHelper.4(this));
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, Long paramLong)
  {
    if (!IceBreakingUtil.a(this.d, this.b.ah.a, this.b.ah.b)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("IceBreak.IceBreakingUtil", 2, String.format("onIceBreakResp suc=%b selfUin=%b frdUin=%b", new Object[] { Boolean.valueOf(paramBoolean), paramString1, paramString2 }));
    }
    if ((paramBoolean) && (paramString1.equals(this.b.d.getCurrentAccountUin())) && (paramString2.equals(this.b.ah.b))) {
      IceBreakingUtil.a(this.b.d, this.b.ah.b, true, this.b.ah.a);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = QLog.isColorLevel();
    boolean bool1 = true;
    int j = 1;
    if (bool2) {
      QLog.i("IceBreak.IceBreakingUtil", 2, String.format("updateIceBreakPokeShow bOnCreate=%b uin=%s, toShow=%s", new Object[] { Boolean.valueOf(paramBoolean1), this.b.ah.b, Boolean.valueOf(paramBoolean2) }));
    }
    if (paramBoolean2)
    {
      IceBreakingMng localIceBreakingMng = (IceBreakingMng)this.d.getManager(QQManagerFactory.ICE_BREAKING_MNG);
      int k = this.b.ah.a;
      String str = this.b.ah.b;
      Object localObject;
      if (IceBreakingUtil.b(k))
      {
        localObject = (FriendsManager)this.d.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if ((this.a != null) && (((FriendsManager)localObject).n(str)))
        {
          if (localIceBreakingMng.a(str, this.b.ah.a) == 1) {
            j = 6;
          }
          localIceBreakingMng.a(this.d.getCurrentUin(), 3, j, str);
        }
      }
      else if (IceBreakingUtil.c(k))
      {
        if (!localIceBreakingMng.g(str)) {
          localIceBreakingMng.a(this.d.getCurrentUin(), 3, 2, str);
        }
      }
      else if (IceBreakingUtil.d(k))
      {
        if (!localIceBreakingMng.h(str)) {
          ((ILimitChatMatchInfoHelper)QRoute.api(ILimitChatMatchInfoHelper.class)).getMatchInfoRequest(this.d, str, new IceBreakHelper.3(this, localIceBreakingMng, str));
        }
      }
      else if (IceBreakingUtil.e(k))
      {
        if (!localIceBreakingMng.i(str)) {
          localIceBreakingMng.a(this.d.getCurrentUin(), 3, 5, str);
        }
      }
      else if (IceBreakingUtil.f(k))
      {
        localObject = this.b;
        paramBoolean1 = bool1;
        if ((localObject instanceof GameMsgChatPie)) {
          paramBoolean1 = ((GameMsgChatPie)localObject).bK();
        }
        if ((paramBoolean1) && (!localIceBreakingMng.s(str)))
        {
          j = a();
          localIceBreakingMng.a(this.d.getCurrentUin(), 3, j, str);
        }
      }
    }
    else
    {
      this.i.a(true, null, 0);
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (IceBreakingUtil.a(this.d, this.b.ah.a, this.b.ah.b))
    {
      if (this.a == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("IceBreak.IceBreakingUtil", 2, String.format("onGoingToShowPanel old=%d new=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      }
      if ((this.b.aR() == 0) && (paramInt2 != 0)) {
        this.a.a(true);
      }
    }
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IceBreakHelper", 2, String.format("onRemoveIceBreak uin: %s, isTroop: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) }));
    }
    int j = this.b.ah.a;
    String str = this.b.ah.b;
    if (!IceBreakingUtil.a(this.d, j, str)) {
      return;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      if (!str.equals(paramString)) {
        return;
      }
      if (((paramBoolean) && (IceBreakingUtil.c(j))) || ((!paramBoolean) && (IceBreakingUtil.b(j))) || (IceBreakingUtil.d(j)) || (IceBreakingUtil.e(j)) || (IceBreakingUtil.f(j))) {
        this.b.j().post(new IceBreakHelper.5(this));
      }
    }
  }
  
  public String getTag()
  {
    return "IceBreakHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 15, 9 };
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131435808) && (this.a != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("IceBreak.IceBreakingUtil", 2, "onClick inputCustomClickLisenter");
      }
      if (this.b.aR() == 0) {
        this.a.a(true);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onMoveToState(int paramInt)
  {
    Object localObject;
    if (paramInt != 4)
    {
      if (paramInt != 9)
      {
        if (paramInt != 15) {
          return;
        }
        QLog.i("IceBreak.HotPic", 1, "onMoveToState destroy.");
        if (this.a != null)
        {
          localObject = (IceBreakingMng)this.d.getManager(QQManagerFactory.ICE_BREAKING_MNG);
          ((IceBreakingMng)localObject).b(this);
          ((IceBreakingMng)localObject).h();
          this.a.b();
          this.a = null;
        }
      }
      else
      {
        QLog.i("IceBreak.HotPic", 1, "onMoveToState show first.");
        this.f = this.b.ah.a;
        this.g = this.b.ah.b;
        if (!TextUtils.isEmpty(this.g))
        {
          if (a(this.f, this.g))
          {
            ThreadManager.getSubThreadHandler().post(new IceBreakHelper.2(this));
            return;
          }
          IceBreakingUtil.a(this.d, this.g, false, this.f);
        }
      }
    }
    else
    {
      QLog.i("IceBreak.HotPic", 1, "onMoveToState create.");
      if (IceBreakingUtil.a(this.d, this.b.ah.a, this.b.ah.b))
      {
        localObject = this.b;
        this.a = new AIOIceBreakShow((BaseChatPie)localObject, this.c, ((BaseChatPie)localObject).ah.b);
        this.b.Y.a(this);
        this.b.bm().setOnGoingToShowPanelListener(this);
        localObject = (IceBreakingMng)this.d.getManager(QQManagerFactory.ICE_BREAKING_MNG);
        ((IceBreakingMng)localObject).a(this);
        ((IceBreakingMng)localObject).a(this.i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.IceBreakHelper
 * JD-Core Version:    0.7.0.1
 */