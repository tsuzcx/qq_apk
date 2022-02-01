import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.JDHongbaoActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.apollo.view.ChatApolloViewListener.1;
import com.tencent.mobileqq.apollo.view.ChatApolloViewListener.2;
import com.tencent.mobileqq.apollo.view.ChatApolloViewListener.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;
import cooperation.qzone.QZoneVipInfoManager;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import mqq.os.MqqHandler;
import tencent.im.oidb.qqshop.qqshop_act.SQQSHPActInfo;
import tencent.im.oidb.qqshop.qqshop_act.SQQSHPActRsp;
import tencent.im.oidb.qqshop.qqshop_act.SQQSHPActShowInfo;

public class amnm
  extends bggc
  implements afei, alqx, View.OnClickListener
{
  public PopupWindow a;
  private Runnable a;
  public WeakReference<BaseChatPie> a;
  public boolean a;
  public boolean b;
  public boolean c;
  
  public amnm(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_JavaLangRunnable = new ChatApolloViewListener.3(this);
    if (((paramBaseChatPie instanceof afiw)) || ((paramBaseChatPie instanceof TroopChatPie)) || ((paramBaseChatPie instanceof afim)) || ((paramBaseChatPie instanceof ahgz))) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseChatPie);
    }
  }
  
  public static void a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "[doJDRedPackReport], key:" + paramInt + ",app:" + paramQQAppInterface);
    }
    if (paramQQAppInterface == null) {
      return;
    }
    ((ogr)paramQQAppInterface.getBusinessHandler(88)).a(paramInt, "", "", "", "", 0L, false);
  }
  
  private void a(Activity paramActivity, qqshop_act.SQQSHPActShowInfo paramSQQSHPActShowInfo, boolean paramBoolean)
  {
    if ((paramActivity == null) || (paramSQQSHPActShowInfo == null)) {
      return;
    }
    Intent localIntent = new Intent(paramActivity, JDHongbaoActivity.class);
    localIntent.putExtra("jd_hb_is_check_delay", paramBoolean);
    localIntent.putExtra("jd_hb_title", paramSQQSHPActShowInfo.title.get());
    localIntent.putExtra("jd_hb_subtitle", paramSQQSHPActShowInfo.subtext.get());
    localIntent.putExtra("jd_hb_detail_text", paramSQQSHPActShowInfo.gift_text.get());
    localIntent.putExtra("jd_hongbao_tips", paramSQQSHPActShowInfo.act_text.get());
    localIntent.putExtra("jd_hb_btn_text", paramSQQSHPActShowInfo.btn_text.get());
    localIntent.putExtra("jd_hb_detail_url", paramSQQSHPActShowInfo.detail_url.get());
    localIntent.putExtra("jd_hb_btn_url", paramSQQSHPActShowInfo.btn_url.get());
    localIntent.putExtra("jd_hb_logo_url", paramSQQSHPActShowInfo.logo.get());
    localIntent.addFlags(67108864);
    paramActivity.startActivity(localIntent);
  }
  
  private boolean a(int paramInt, String paramString)
  {
    QLog.d("ChatApolloViewListener", 1, new Object[] { "onPetBrandClick petId=", Integer.valueOf(paramInt) });
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      return false;
    }
    BaseChatPie localBaseChatPie = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localBaseChatPie == null) || (localBaseChatPie.mActivity == null)) {
      return false;
    }
    return QZoneVipInfoManager.onPetBrandClick(localBaseChatPie.mActivity, paramInt, paramString);
  }
  
  private boolean a(String paramString)
  {
    QLog.d("ChatApolloViewListener", 1, "onSuperYellowBrandClick");
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      return false;
    }
    BaseChatPie localBaseChatPie = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localBaseChatPie == null) || (localBaseChatPie.mActivity == null)) {
      return false;
    }
    return QZoneVipInfoManager.onSuperYellowBrandClick(localBaseChatPie.mActivity, paramString);
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "[initJDRedPackEntry],mIsJumpEggStart:" + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    do
    {
      return;
      localObject = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while ((localObject == null) || (((BaseChatPie)localObject).app == null) || (!this.jdField_a_of_type_Boolean) || (((BaseChatPie)localObject).getTipManager() == null));
    ((BaseChatPie)localObject).getTipManager().a(this);
    ogr localogr = (ogr)((BaseChatPie)localObject).app.getBusinessHandler(88);
    String str = Integer.toString(ofx.a(((BaseChatPie)localObject).sessionInfo.curType));
    if ((((BaseChatPie)localObject).sessionInfo.curType == 1) || (((BaseChatPie)localObject).sessionInfo.curType == 3000)) {}
    for (Object localObject = ((BaseChatPie)localObject).sessionInfo.curFriendUin;; localObject = "")
    {
      localogr.a(134247330, "", str, (String)localObject, "", 0L, false);
      return;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "[onEggAnimStart], mIsJumpEggStart:" + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    BaseChatPie localBaseChatPie;
    do
    {
      return;
      localBaseChatPie = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while ((this.jdField_a_of_type_Boolean) || (localBaseChatPie == null) || (localBaseChatPie.app == null));
    localBaseChatPie.app.getHandler(ChatActivity.class).removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_Boolean = true;
    ofx localofx = (ofx)localBaseChatPie.app.getManager(88);
    ((VasExtensionHandler)localBaseChatPie.app.getBusinessHandler(71)).a(localofx.b);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "[addJDEndView],imgUrl:" + paramString);
    }
    LinearLayout localLinearLayout = (LinearLayout)View.inflate(BaseApplicationImpl.getContext(), 2131558684, null);
    if (localLinearLayout == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ChatApolloViewListener", 2, "errInfo->inflate err.");
      }
    }
    do
    {
      do
      {
        return;
        Object localObject = (ImageView)localLinearLayout.findViewById(2131369439);
        TextView localTextView = (TextView)localLinearLayout.findViewById(2131369274);
        ((ImageView)localObject).setOnClickListener(this);
        localTextView.setOnClickListener(this);
        localObject = (URLImageView)localLinearLayout.findViewById(2131369135);
        if (!TextUtils.isEmpty(paramString))
        {
          paramString = URLDrawable.getDrawable(paramString, URLDrawable.URLDrawableOptions.obtain());
          if ((localObject != null) && (paramString != null)) {
            ((URLImageView)localObject).setImageDrawable(paramString);
          }
        }
        if (this.jdField_a_of_type_AndroidWidgetPopupWindow == null) {
          this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(localLinearLayout, -1, -1, false);
        }
      } while (this.jdField_a_of_type_JavaLangRefWeakReference == null);
      paramString = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (paramString == null);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.showAsDropDown(paramString.mCustomTitleView);
    a(134247341, paramString.app);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    boolean bool = true;
    if (paramBoolean)
    {
      this.b = true;
      if (paramInt == 1) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.c = paramBoolean;
        return;
      }
    }
    this.b = false;
    this.c = false;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "[onEggAnimEnd], mIsJumpEggStart:" + this.jdField_a_of_type_Boolean);
    }
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (!this.jdField_a_of_type_Boolean)) {}
    do
    {
      return;
      localObject = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localObject == null);
    ofx localofx = (ofx)((BaseChatPie)localObject).app.getManager(88);
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "currentDelay:" + localofx.c);
    }
    Object localObject = ((BaseChatPie)localObject).app.getHandler(ChatActivity.class);
    if (localofx.c > 0)
    {
      ((MqqHandler)localObject).postDelayed(this.jdField_a_of_type_JavaLangRunnable, localofx.c * 1000);
      return;
    }
    c();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "[removeJDRedPackEntry]");
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    BaseChatPie localBaseChatPie;
    do
    {
      return;
      localBaseChatPie = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while ((localBaseChatPie == null) || (localBaseChatPie.getTipManager() == null));
    localBaseChatPie.getTipManager().d();
  }
  
  protected void onApolloDressChange(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "[onApolloDressChange], result:" + paramBoolean + ",data:" + paramObject);
    }
    ThreadManager.post(new ChatApolloViewListener.2(this, paramBoolean, paramObject), 5, null, true);
  }
  
  protected void onChangeUserApolloStatus(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "TROOP, [onChangeUserApolloStatus], result:" + paramBoolean + ",data:" + paramObject);
    }
    if ((!paramBoolean) || (paramObject == null)) {}
    label50:
    BaseChatPie localBaseChatPie;
    do
    {
      do
      {
        do
        {
          break label50;
          do
          {
            return;
          } while (this.jdField_a_of_type_JavaLangRefWeakReference == null);
          localBaseChatPie = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        } while ((localBaseChatPie == null) || (localBaseChatPie.sessionInfo == null) || (localBaseChatPie.app == null));
        if (localBaseChatPie.mApolloPanel != null) {
          localBaseChatPie.mApolloPanel.a(paramBoolean, paramObject);
        }
        MqqHandler localMqqHandler = localBaseChatPie.app.getHandler(ChatActivity.class);
        if (localMqqHandler != null) {
          localMqqHandler.obtainMessage(51).sendToTarget();
        }
        paramObject = (Pair)paramObject;
      } while (!((String)paramObject.first).equals(localBaseChatPie.app.getCurrentUin()));
      QLog.i("ChatApolloViewListener", 1, "my cmshow status has changed, status:" + paramObject.second);
      if ((2 == ((Integer)paramObject.second).intValue()) || (((Integer)paramObject.second).intValue() == 0))
      {
        amat.a(localBaseChatPie.getApp(), "cmshow_status", true);
        return;
      }
    } while (1 != ((Integer)paramObject.second).intValue());
    amat.a(localBaseChatPie.getApp(), "cmshow_status", false);
    ApolloGameUtil.a(localBaseChatPie.app, 0L);
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "request user game list");
    }
    ((alnn)localBaseChatPie.app.getManager(211)).e();
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject1 = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject1 == null) || (((BaseChatPie)localObject1).app != null)) {
        switch (paramView.getId())
        {
        default: 
          break;
        case 2131368139: 
          if (((BaseChatPie)localObject1).mProgressDialog == null)
          {
            int i = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299076);
            ((BaseChatPie)localObject1).mProgressDialog = new bhht(((BaseChatPie)localObject1).mContext, i);
          }
          ((BaseChatPie)localObject1).mProgressDialog.a(amtj.a(2131700728));
          ((BaseChatPie)localObject1).mProgressDialog.show();
          c();
          Object localObject2 = (ofx)((BaseChatPie)localObject1).app.getManager(88);
          Object localObject3 = (VasExtensionHandler)((BaseChatPie)localObject1).app.getBusinessHandler(71);
          if ((localObject2 != null) && (localObject3 != null))
          {
            ((VasExtensionHandler)localObject3).a(((ofx)localObject2).b, ((BaseChatPie)localObject1).sessionInfo.curType, ((BaseChatPie)localObject1).sessionInfo.troopUin);
            localObject2 = (ogr)((BaseChatPie)localObject1).app.getBusinessHandler(88);
            localObject3 = Integer.toString(ofx.a(((BaseChatPie)localObject1).sessionInfo.curType));
            if ((((BaseChatPie)localObject1).sessionInfo.curType == 1) || (((BaseChatPie)localObject1).sessionInfo.curType == 3000)) {}
            for (localObject1 = ((BaseChatPie)localObject1).sessionInfo.curFriendUin;; localObject1 = "")
            {
              ((ogr)localObject2).a(134247331, "", (String)localObject3, (String)localObject1, Integer.toString(ofx.b()), 0L, false);
              break;
            }
          }
          break;
        case 2131369439: 
          if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null)
          {
            this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
            a(134247343, ((BaseChatPie)localObject1).app);
          }
          break;
        case 2131369274: 
          if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null)
          {
            this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
            a(134247343, ((BaseChatPie)localObject1).app);
          }
          break;
        }
      }
    }
  }
  
  protected void onJDCheckRsp(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "[onJDCheckRsp],result:" + paramBoolean + ",mIsAIOFinish:" + this.b + ",mChatPieRef:" + this.jdField_a_of_type_JavaLangRefWeakReference);
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    do
    {
      do
      {
        return;
        paramObject = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (!paramBoolean) {
          break;
        }
      } while (this.b);
      d();
      return;
    } while ((paramObject == null) || (this.b));
    a(134247332, paramObject.app);
  }
  
  protected void onJDHongbaoRsp(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "[onJDHongbaoRsp],result:" + paramBoolean + ",data:" + paramObject + ",mIsAIOFinish:" + this.b);
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    do
    {
      Object localObject;
      BaseChatPie localBaseChatPie;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  localObject = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
                  if ((localObject != null) && (((BaseChatPie)localObject).mProgressDialog != null)) {
                    ((BaseChatPie)localObject).mProgressDialog.dismiss();
                  }
                  if ((!paramBoolean) && (!this.b))
                  {
                    QQToast.a(BaseApplicationImpl.getContext(), amtj.a(2131700730), 1).a();
                    return;
                  }
                } while (paramObject == null);
                if ((paramObject instanceof qqshop_act.SQQSHPActRsp)) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.d("ChatApolloViewListener", 2, "errInfo->Wrong data object.");
              return;
              paramObject = (qqshop_act.SQQSHPActRsp)paramObject;
              localObject = paramObject.act_show_info;
            } while ((localObject == null) || (this.jdField_a_of_type_JavaLangRefWeakReference == null));
            localBaseChatPie = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
            int i = paramObject.code.get();
            if (QLog.isColorLevel()) {
              QLog.d("ChatApolloViewListener", 2, "errCode:" + i);
            }
            switch (i)
            {
            }
          } while (this.b);
          QQToast.a(BaseApplicationImpl.getContext(), amtj.a(2131700729), 1).a();
          return;
        } while ((localBaseChatPie == null) || (localBaseChatPie.mActivity == null) || (this.b));
        a(localBaseChatPie.mActivity, (qqshop_act.SQQSHPActShowInfo)localObject, false);
        return;
      } while ((localBaseChatPie == null) || (localBaseChatPie.mActivity == null) || (this.b));
      a(localBaseChatPie.mActivity, (qqshop_act.SQQSHPActShowInfo)localObject, true);
      return;
    } while ((this.b) || (paramObject.act_info == null));
    a(paramObject.act_info.fail_pic.get());
  }
  
  public void onNotifyLongTouch(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!beyx.b(paramString))) {
      QLog.w("ChatApolloViewListener", 1, "longTouch uin = null");
    }
    label23:
    BaseChatPie localBaseChatPie;
    Object localObject;
    do
    {
      do
      {
        do
        {
          break label23;
          do
          {
            return;
          } while (this.jdField_a_of_type_JavaLangRefWeakReference == null);
          localBaseChatPie = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        } while ((localBaseChatPie == null) || (localBaseChatPie.app == null) || (localBaseChatPie.mApolloViewController == null) || (!localBaseChatPie.mApolloViewController.a()) || (localBaseChatPie.sessionInfo == null));
        if (!NetworkUtil.isNetworkAvailable(localBaseChatPie.mContext))
        {
          ApolloItemBuilder.a(localBaseChatPie.mContext.getString(2131690028), 1, localBaseChatPie.mContext);
          return;
        }
        localObject = ambc.a(localBaseChatPie.app);
        if (localObject == null) {
          break;
        }
        localObject = ((amaz)localObject).a();
      } while ((localObject != null) && (((amba)localObject).a()));
      localObject = (alnr)localBaseChatPie.app.getManager(153);
      VipUtils.a(localBaseChatPie.app, "cmshow", "Apollo", "long_press_avatar", localBaseChatPie.sessionInfo.curFriendUin, ApolloUtil.b(localBaseChatPie.sessionInfo.curType), 0, new String[] { "0", "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
      if (((alnr)localObject).b(paramString) != 1)
      {
        ApolloItemBuilder.a(localBaseChatPie.mContext.getString(2131690067), 1, localBaseChatPie.mContext);
        return;
      }
    } while (alnr.a(localBaseChatPie.app, paramString) == 2);
    if (localBaseChatPie.sessionInfo.curType == 0) {
      localObject = ContactUtils.getFriendShowName(localBaseChatPie.app, paramString);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatApolloViewListener", 2, "onLoncClick uin = " + paramString + " ,nickName =" + (String)localObject);
      }
      localBaseChatPie.mApolloViewController.b();
      Intent localIntent = new Intent(localBaseChatPie.mActivity, ApolloGuestsStateActivity.class);
      localIntent.putExtra("extra_guest_uin", paramString);
      localIntent.putExtra("extra_guest_nick", (String)localObject);
      localIntent.putExtra("extra_guest_from", ApolloUtil.b(localBaseChatPie.sessionInfo.curType));
      localBaseChatPie.mActivity.startActivity(localIntent);
      return;
      if (localBaseChatPie.sessionInfo.curType == 1) {
        localObject = ContactUtils.getTroopMemberNameWithoutRemark(localBaseChatPie.app, localBaseChatPie.sessionInfo.curFriendUin, paramString);
      } else if (localBaseChatPie.sessionInfo.curType == 3000) {
        localObject = ContactUtils.getBuddyName(localBaseChatPie.app, paramString, true);
      } else {
        localObject = "";
      }
    }
  }
  
  public void onNotifyStatusChanged(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    BaseChatPie localBaseChatPie;
    do
    {
      return;
      QLog.d("ChatApolloViewListener", 1, new Object[] { "onNotifyStatusChanged clickPart=", Integer.valueOf(paramInt) });
      localBaseChatPie = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while ((localBaseChatPie == null) || (localBaseChatPie.app == null) || (localBaseChatPie.mApolloViewController == null) || (!localBaseChatPie.mApolloViewController.a()) || (localBaseChatPie.sessionInfo == null));
    String str = ApolloUtil.f(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    label136:
    alsg localalsg;
    switch (paramInt)
    {
    default: 
      bool1 = bool2;
    case 8: 
    case 9: 
    case 10: 
    case 11: 
      while (bool1)
      {
        QLog.d("ChatApolloViewListener", 1, "onNotifyStatusChanged click intercept");
        return;
        bool1 = bool2;
        if (((alnr)localBaseChatPie.app.getManager(153)).b(str))
        {
          bool1 = a(str);
          continue;
          ApolloBaseInfo localApolloBaseInfo = ((alnr)localBaseChatPie.app.getManager(153)).b(str);
          bool1 = bool2;
          if (localApolloBaseInfo != null)
          {
            localalsg = localApolloBaseInfo.getApolloPetDress();
            if ((localalsg == null) || (!localApolloBaseInfo.hasPet) || (localalsg.jdField_a_of_type_JavaUtilHashMap == null) || (localalsg.jdField_a_of_type_JavaUtilHashMap.isEmpty())) {
              break label696;
            }
          }
        }
      }
    }
    label696:
    for (bool1 = a(localalsg.jdField_a_of_type_Int, paramString);; bool1 = false)
    {
      break label136;
      paramString = (alnn)localBaseChatPie.app.getManager(211);
      if (paramString.jdField_a_of_type_Int != -1)
      {
        ApolloGameUtil.a(localBaseChatPie.app, paramString.jdField_a_of_type_Int, 0L, 0, "", 321, null);
        return;
      }
      bool1 = bool2;
      if (paramString.jdField_a_of_type_Amgg == null) {
        break label136;
      }
      paramString = paramString.jdField_a_of_type_Amgg.a();
      bool1 = bool2;
      if (paramString == null) {
        break label136;
      }
      if (paramString.msg_type != 10)
      {
        bool1 = bool2;
        if (paramString.msg_type != 7) {
          break label136;
        }
      }
      alnr.a(102, String.valueOf(paramString.tianshuAdId), paramString.tianshuTraceInfo);
      bool1 = bool2;
      break label136;
      paramString = ambc.a(localBaseChatPie.app);
      if (paramString != null) {
        paramString.a(ambc.a(paramInt), null, str);
      }
      paramString = (amaz)localBaseChatPie.app.getManager(249);
      if (paramString == null) {
        break;
      }
      paramString = paramString.a();
      if (paramString == null) {
        break;
      }
      int i = paramString.a();
      paramString = localBaseChatPie.app.getApp().getSharedPreferences("apollo_sp", 0);
      bool1 = paramString.getBoolean("is_add_new_game" + localBaseChatPie.app.getCurrentAccountUin(), false);
      int j = paramString.getInt("new_added_game_id" + localBaseChatPie.app.getCurrentAccountUin(), -1);
      if (9 == paramInt) {
        VipUtils.a(localBaseChatPie.app, "cmshow", "Apollo", "click_action_hotspot", ApolloUtil.b(localBaseChatPie.sessionInfo.curType), 0, new String[0]);
      }
      if (i == 1)
      {
        if ((!bool1) || (-1 == j)) {
          break;
        }
        VipUtils.a(localBaseChatPie.app, "cmshow", "Apollo", "avatar_clk_togame", ApolloUtil.b(localBaseChatPie.sessionInfo.curType), 1, new String[] { String.valueOf(j) });
        paramString.edit().remove("is_add_new_game" + localBaseChatPie.app.getCurrentAccountUin()).commit();
        return;
      }
      if ((i != 2) || (localBaseChatPie.mApolloPanel == null)) {
        break;
      }
      localBaseChatPie.mApolloPanel.i();
      return;
    }
  }
  
  protected void onQueryUserApolloAction(boolean paramBoolean, Object paramObject)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null)
    {
      alnr.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("ChatApolloViewListener", 2, "onQueryUserApolloAction mChatPieRef == null return");
      }
    }
    BaseChatPie localBaseChatPie;
    do
    {
      return;
      localBaseChatPie = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while ((localBaseChatPie == null) || (localBaseChatPie.mApolloPanel == null));
    localBaseChatPie.mApolloPanel.b(paramBoolean, paramObject);
  }
  
  public void onSurfaceReady(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "[TraceReport onSurfaceReady], w:" + paramInt1 + ",h:" + paramInt2);
    }
    BaseChatPie localBaseChatPie = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localBaseChatPie == null) {
      return;
    }
    amaz localamaz = (amaz)localBaseChatPie.app.getManager(249);
    if (localamaz.a() != null) {
      amhk.a(ambc.b(localamaz.a().e), 100, 0, new Object[] { "onSurfaceReady" });
    }
    if (!localBaseChatPie.mApolloViewController.jdField_a_of_type_Boolean)
    {
      amkr.a("TraceReport_initApolloSurfaceView_PreLoadJS");
      ThreadManager.excute(new ChatApolloViewListener.1(this), 192, null, true);
      return;
    }
    QLog.i("ChatApolloViewListener", 1, "TraceReport CmShowStatUtil onSurfaceReady mPreloadEngine:true");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amnm
 * JD-Core Version:    0.7.0.1
 */