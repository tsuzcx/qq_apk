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
import com.tencent.mobileqq.apollo.data.ApolloDress;
import com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ChatApolloViewListener.1;
import com.tencent.mobileqq.apollo.view.ChatApolloViewListener.2;
import com.tencent.mobileqq.apollo.view.ChatApolloViewListener.3;
import com.tencent.mobileqq.apollo.view.pannel.ApolloPanel;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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

public class annn
  extends bhow
  implements afvn, ampy, View.OnClickListener
{
  public PopupWindow a;
  private Runnable a;
  public WeakReference<BaseChatPie> a;
  public boolean a;
  public boolean b;
  public boolean c;
  
  public annn(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_JavaLangRunnable = new ChatApolloViewListener.3(this);
    if (((paramBaseChatPie instanceof agab)) || ((paramBaseChatPie instanceof TroopChatPie)) || ((paramBaseChatPie instanceof afzr)) || ((paramBaseChatPie instanceof aibs)) || ((paramBaseChatPie instanceof aift)) || ((paramBaseChatPie instanceof aici))) {
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
    ((ook)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER)).a(paramInt, "", "", "", "", 0L, false);
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
  
  private boolean b(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 1, new Object[] { "onPetClick petId=", Integer.valueOf(paramInt) });
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      return false;
    }
    BaseChatPie localBaseChatPie = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localBaseChatPie == null) || (localBaseChatPie.mActivity == null)) {
      return false;
    }
    return QZoneVipInfoManager.onPetClick(localBaseChatPie.mActivity, localBaseChatPie.app, paramInt, paramString);
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
    ook localook = (ook)((BaseChatPie)localObject).app.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER);
    String str = Integer.toString(onq.a(((BaseChatPie)localObject).sessionInfo.curType));
    if ((((BaseChatPie)localObject).sessionInfo.curType == 1) || (((BaseChatPie)localObject).sessionInfo.curType == 3000)) {}
    for (Object localObject = ((BaseChatPie)localObject).sessionInfo.curFriendUin;; localObject = "")
    {
      localook.a(134247330, "", str, (String)localObject, "", 0L, false);
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
    onq localonq = (onq)localBaseChatPie.app.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
    ((VasExtensionHandler)localBaseChatPie.app.getBusinessHandler(BusinessHandlerFactory.VAS_EXTENSION_HANDLER)).a(localonq.b);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "[addJDEndView],imgUrl:" + paramString);
    }
    LinearLayout localLinearLayout = (LinearLayout)View.inflate(BaseApplicationImpl.getContext(), 2131558696, null);
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
        Object localObject = (ImageView)localLinearLayout.findViewById(2131369608);
        TextView localTextView = (TextView)localLinearLayout.findViewById(2131369441);
        ((ImageView)localObject).setOnClickListener(this);
        localTextView.setOnClickListener(this);
        localObject = (URLImageView)localLinearLayout.findViewById(2131369298);
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
    onq localonq = (onq)((BaseChatPie)localObject).app.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "currentDelay:" + localonq.c);
    }
    Object localObject = ((BaseChatPie)localObject).app.getHandler(ChatActivity.class);
    if (localonq.c > 0)
    {
      ((MqqHandler)localObject).postDelayed(this.jdField_a_of_type_JavaLangRunnable, localonq.c * 1000);
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
        ancb.a(localBaseChatPie.getApp(), "cmshow_status", true);
        return;
      }
    } while (1 != ((Integer)paramObject.second).intValue());
    ancb.a(localBaseChatPie.getApp(), "cmshow_status", false);
    ApolloGameUtil.a(localBaseChatPie.app, 0L);
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "request user game list");
    }
    ((amma)localBaseChatPie.app.getManager(QQManagerFactory.APOLLO_GAME_MANAGER)).e();
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
        case 2131368282: 
          if (((BaseChatPie)localObject1).mProgressDialog == null)
          {
            int i = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299080);
            ((BaseChatPie)localObject1).mProgressDialog = new bisl(((BaseChatPie)localObject1).mContext, i);
          }
          ((BaseChatPie)localObject1).mProgressDialog.a(anvx.a(2131701079));
          ((BaseChatPie)localObject1).mProgressDialog.show();
          c();
          Object localObject2 = (onq)((BaseChatPie)localObject1).app.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
          Object localObject3 = (VasExtensionHandler)((BaseChatPie)localObject1).app.getBusinessHandler(BusinessHandlerFactory.VAS_EXTENSION_HANDLER);
          if ((localObject2 != null) && (localObject3 != null))
          {
            ((VasExtensionHandler)localObject3).a(((onq)localObject2).b, ((BaseChatPie)localObject1).sessionInfo.curType, ((BaseChatPie)localObject1).sessionInfo.troopUin);
            localObject2 = (ook)((BaseChatPie)localObject1).app.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER);
            localObject3 = Integer.toString(onq.a(((BaseChatPie)localObject1).sessionInfo.curType));
            if ((((BaseChatPie)localObject1).sessionInfo.curType == 1) || (((BaseChatPie)localObject1).sessionInfo.curType == 3000)) {}
            for (localObject1 = ((BaseChatPie)localObject1).sessionInfo.curFriendUin;; localObject1 = "")
            {
              ((ook)localObject2).a(134247331, "", (String)localObject3, (String)localObject1, Integer.toString(onq.b()), 0L, false);
              break;
            }
          }
          break;
        case 2131369608: 
          if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null)
          {
            this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
            a(134247343, ((BaseChatPie)localObject1).app);
          }
          break;
        case 2131369441: 
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
                    QQToast.a(BaseApplicationImpl.getContext(), anvx.a(2131701081), 1).a();
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
          QQToast.a(BaseApplicationImpl.getContext(), anvx.a(2131701080), 1).a();
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
    if ((TextUtils.isEmpty(paramString)) || (!bghb.b(paramString))) {
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
          ApolloItemBuilder.a(localBaseChatPie.mContext.getString(2131690057), 1, localBaseChatPie.mContext);
          return;
        }
        localObject = anck.a(localBaseChatPie.app);
        if (localObject == null) {
          break;
        }
        localObject = ((anch)localObject).a();
      } while ((localObject != null) && (((anci)localObject).a()));
      localObject = (amme)localBaseChatPie.app.getManager(QQManagerFactory.APOLLO_MANAGER);
      VipUtils.a(localBaseChatPie.app, "cmshow", "Apollo", "long_press_avatar", localBaseChatPie.sessionInfo.curFriendUin, ApolloUtil.b(localBaseChatPie.sessionInfo.curType), 0, new String[] { "0", "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
      if (((amme)localObject).b(paramString) != 1)
      {
        ApolloItemBuilder.a(localBaseChatPie.mContext.getString(2131690103), 1, localBaseChatPie.mContext);
        return;
      }
    } while (amme.a(localBaseChatPie.app, paramString) == 2);
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
    paramString = ApolloUtil.f(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    label140:
    Object localObject;
    ApolloDress localApolloDress;
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
        if (((amme)localBaseChatPie.app.getManager(QQManagerFactory.APOLLO_MANAGER)).b(paramString))
        {
          bool1 = a(paramString);
          continue;
          localObject = ((amme)localBaseChatPie.app.getManager(QQManagerFactory.APOLLO_MANAGER)).b(paramString);
          bool1 = bool2;
          if (localObject != null)
          {
            localApolloDress = ((ApolloBaseInfo)localObject).getApolloPetDress();
            if ((localApolloDress == null) || (!((ApolloBaseInfo)localObject).hasPet) || (localApolloDress.jdField_a_of_type_JavaUtilHashMap == null) || (localApolloDress.jdField_a_of_type_JavaUtilHashMap.isEmpty())) {
              break label809;
            }
          }
        }
      }
    }
    label809:
    for (bool1 = a(localApolloDress.jdField_a_of_type_Int, paramString);; bool1 = false)
    {
      break label140;
      localObject = ((amme)localBaseChatPie.app.getManager(QQManagerFactory.APOLLO_MANAGER)).b(paramString);
      bool1 = bool2;
      if (localObject == null) {
        break label140;
      }
      localApolloDress = ((ApolloBaseInfo)localObject).getApolloPetDress();
      bool1 = bool2;
      if (localApolloDress == null) {
        break label140;
      }
      bool1 = bool2;
      if (!((ApolloBaseInfo)localObject).hasPet) {
        break label140;
      }
      bool1 = bool2;
      if (localApolloDress.jdField_a_of_type_JavaUtilHashMap == null) {
        break label140;
      }
      bool1 = bool2;
      if (localApolloDress.jdField_a_of_type_JavaUtilHashMap.isEmpty()) {
        break label140;
      }
      bool1 = b(localApolloDress.jdField_a_of_type_Int, paramString);
      break label140;
      localObject = (amma)localBaseChatPie.app.getManager(QQManagerFactory.APOLLO_GAME_MANAGER);
      if (((amma)localObject).jdField_a_of_type_Int != -1)
      {
        ApolloGameUtil.a(localBaseChatPie.app, ((amma)localObject).jdField_a_of_type_Int, 0L, 0, "", 321, null);
        return;
      }
      bool1 = bool2;
      if (((amma)localObject).jdField_a_of_type_Anho == null) {
        break label140;
      }
      localObject = ((amma)localObject).jdField_a_of_type_Anho.a();
      bool1 = bool2;
      if (localObject == null) {
        break label140;
      }
      if (((DrawerPushItem)localObject).msg_type != 10)
      {
        bool1 = bool2;
        if (((DrawerPushItem)localObject).msg_type != 7) {
          break label140;
        }
      }
      anme.a(102, String.valueOf(((DrawerPushItem)localObject).tianshuAdId), ((DrawerPushItem)localObject).tianshuTraceInfo);
      bool1 = bool2;
      break label140;
      localObject = anck.a(localBaseChatPie.app);
      if (localObject != null) {
        ((anbt)localObject).a(anck.a(paramInt), null, paramString);
      }
      paramString = (anch)localBaseChatPie.app.getManager(QQManagerFactory.SPRITE_SCRIPT_MANAGER);
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
      amme.jdField_a_of_type_Boolean = true;
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
    anch localanch = (anch)localBaseChatPie.app.getManager(QQManagerFactory.SPRITE_SCRIPT_MANAGER);
    if (localanch.a() != null) {
      anis.a(anck.b(localanch.a().e), 100, 0, new Object[] { "onSurfaceReady" });
    }
    if (!localBaseChatPie.mApolloViewController.jdField_a_of_type_Boolean)
    {
      anmj.a("TraceReport_initApolloSurfaceView_PreLoadJS");
      ThreadManager.excute(new ChatApolloViewListener.1(this), 192, null, true);
      return;
    }
    QLog.i("ChatApolloViewListener", 1, "TraceReport CmShowStatUtil onSurfaceReady mPreloadEngine:true");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     annn
 * JD-Core Version:    0.7.0.1
 */