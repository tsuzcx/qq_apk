package com.tencent.mobileqq.apollo.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher;
import com.tencent.mobileqq.apollo.process.data.CmGameMainManager;
import com.tencent.mobileqq.apollo.view.ApolloPanel.GameMsgInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.ActionSheetAdapter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import zcw;

public class ApolloGameInvitation
  implements DialogInterface.OnDismissListener, AdapterView.OnItemClickListener, ActionSheet.OnButtonClickListener
{
  private long jdField_a_of_type_Long;
  private ApolloPanel.GameMsgInfo jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$GameMsgInfo;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private String jdField_b_of_type_JavaLangString;
  private WeakReference jdField_b_of_type_JavaLangRefWeakReference;
  private WeakReference c;
  
  public ApolloGameInvitation(AppInterface paramAppInterface, Activity paramActivity)
  {
    try
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
      this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
      this.jdField_a_of_type_JavaLangString = "";
      return;
    }
    catch (Throwable paramAppInterface)
    {
      QLog.i("ApolloGameInvitation", 1, "[ApolloGameInvitation], errInfo->" + paramAppInterface.getMessage());
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$GameMsgInfo != null)
    {
      CmGameLauncher localCmGameLauncher = CmGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$GameMsgInfo.jdField_e_of_type_Int);
      if (localCmGameLauncher != null) {
        localCmGameLauncher.a(paramInt1, paramInt2, 0, "");
      }
    }
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    d();
  }
  
  public ApolloPanel.GameMsgInfo a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame.sendmsg", 2, new Object[] { "[getGameMsgInfo], params:", paramString, ",app:", this.jdField_b_of_type_JavaLangRefWeakReference });
    }
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_b_of_type_JavaLangRefWeakReference == null)) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      if ((AppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get() == null) {
        return null;
      }
      try
      {
        ApolloPanel.GameMsgInfo localGameMsgInfo = new ApolloPanel.GameMsgInfo();
        paramString = new JSONObject(paramString);
        int i = paramString.optInt("gameId");
        long l = paramString.optLong("roomId");
        int j = paramString.optInt("gameMode");
        int k = paramString.optInt("activityId");
        Object localObject = CmGameUtil.a(i);
        if (localObject != null)
        {
          ((CmGameLauncher)localObject).b = k;
          localObject = ((CmGameLauncher)localObject).a();
          if (localObject != null)
          {
            localGameMsgInfo.jdField_e_of_type_JavaLangString = ((CmGameInitParams)localObject).mChineseName;
            localGameMsgInfo.jdField_f_of_type_Int = ((CmGameInitParams)localObject).mActionId;
          }
        }
        if (0L == l) {
          QLog.w("cmgame.sendmsg", 1, "[getGameMsgInfo] roomId is invalid. gameId:" + i + ",gameMode:" + j);
        }
        localGameMsgInfo.g = j;
        localGameMsgInfo.b = l;
        localGameMsgInfo.jdField_e_of_type_Int = i;
        localGameMsgInfo.h = 3;
        localObject = CmGameMainManager.a();
        if ((localObject != null) && (((CmGameMainManager)localObject).a != null) && (0L != l)) {
          ((CmGameMainManager)localObject).a.roomId = l;
        }
        localObject = paramString.optString("extendInfo");
        JSONObject localJSONObject = new JSONObject();
        paramString = localGameMsgInfo;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localJSONObject.put("extendInfo", localObject);
          if (((String)localObject).length() >= 500)
          {
            QLog.w("cmgame.sendmsg", 1, "[getGameMsgInfo],extendInfo is too long, extendInfo:" + (String)localObject);
            return null;
          }
          localGameMsgInfo.jdField_f_of_type_JavaLangString = localJSONObject.toString();
          return localGameMsgInfo;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("ApolloGameInvitation", 1, paramString, new Object[0]);
      }
    }
    return null;
  }
  
  public void a()
  {
    ActionSheetAdapter localActionSheetAdapter = null;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ActionSheetAdapter.a(0));
    localArrayList.add(ActionSheetAdapter.a(2));
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {}
    for (Object localObject = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();; localObject = null)
    {
      if (localObject != null)
      {
        localActionSheetAdapter = new ActionSheetAdapter((Context)localObject);
        localActionSheetAdapter.a(localArrayList);
      }
      if (((this.c == null) || (this.c.get() == null)) && (localObject != null)) {
        this.c = new WeakReference(ActionSheetAdapter.a((Context)localObject, localActionSheetAdapter, this, this, this, false));
      }
      if ((this.c != null) && (this.c.get() != null))
      {
        localObject = (ActionSheet)this.c.get();
        if ((localObject != null) && (!((ActionSheet)localObject).isShowing()))
        {
          ((ActionSheet)localObject).setOnDismissListener(this);
          ((ActionSheet)localObject).show();
        }
      }
      return;
    }
  }
  
  public void a(ApolloPanel.GameMsgInfo paramGameMsgInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$GameMsgInfo = paramGameMsgInfo;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    Activity localActivity;
    do
    {
      return;
      localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localActivity == null);
    ApolloGameBasicEventUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$GameMsgInfo, localActivity, 1);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameInvitation", 2, "[inviteWechatFriend]");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$GameMsgInfo == null)
    {
      QLog.e("ApolloGameInvitation", 1, "fail to invite wxFriend, mGameMsg is null.");
      return;
    }
    ThreadManager.post(new zcw(this), 5, null, true);
  }
  
  public void d()
  {
    if ((this.c != null) && (this.c.get() != null))
    {
      ActionSheet localActionSheet = (ActionSheet)this.c.get();
      if (localActionSheet != null) {
        localActionSheet.dismiss();
      }
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 1000L) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_Long = l;
      d();
      if (paramLong == 2L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloGameInvitation", 2, "ActionSheetAdapter.CHANNEL_WX_FRIEND is clicked.");
        }
        c();
      }
      for (paramInt = 1; (this.jdField_b_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$GameMsgInfo != null) && ((AppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get() != null); paramInt = 0)
      {
        VipUtils.a(null, "cmshow", "Apollo", "invite_chose", paramInt, 0, new String[] { Integer.toString(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$GameMsgInfo.jdField_e_of_type_Int) });
        return;
        if (paramLong == 0L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloGameInvitation", 2, "ActionSheetAdapter.CHANNEL_QQ is clicked.");
          }
          b();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameInvitation
 * JD-Core Version:    0.7.0.1
 */