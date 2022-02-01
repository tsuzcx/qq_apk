package com.tencent.mobileqq.activity;

import Override;
import SecurityAccountServer.RespondQueryQQBindingStat;
import aatx;
import adzq;
import adzr;
import adzs;
import adzt;
import adzu;
import adzv;
import adzw;
import adzx;
import adzy;
import adzz;
import aeaa;
import aeab;
import aeac;
import aead;
import aeae;
import aeaf;
import aeag;
import akkr;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import anri;
import anvi;
import anvk;
import anxi;
import aoks;
import aqjm;
import assw;
import assy;
import awyz;
import azip;
import azpb;
import azrb;
import azri;
import azwp;
import azww;
import azxd;
import azxe;
import azxf;
import azxg;
import azxh;
import azxr;
import azxt;
import azyh;
import azym;
import baan;
import baax;
import bacf;
import baox;
import bapk;
import baps;
import bbbq;
import bdla;
import bdlf;
import bdvn;
import bgvj;
import bgvk;
import bgvl;
import bhaa;
import bhbr;
import bhbx;
import bheg;
import bhha;
import bhhr;
import bhie;
import bhln;
import birs;
import birt;
import bjxa;
import bkys;
import bkzi;
import bkzz;
import blha;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.profile.view.QzonePhotoView;
import com.tencent.mobileqq.profilecard.base.framework.impl.ComponentCenter;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.profilecard.vas.VasProfileTemplateController;
import com.tencent.mobileqq.profilecard.vas.view.VasProfilePhotoView;
import com.tencent.mobileqq.profilecard.vas.view.VasProfileSimpleView;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqprotect.qsec.QSecFramework;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.PullToZoomHeaderListView;
import com.tencent.widget.XListView.MotionEventInterceptor;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import nut;
import nwu;
import org.json.JSONException;
import org.json.JSONObject;

public class FriendProfileCardActivity
  extends ProfileActivity
  implements TopGestureLayout.OnGestureListener, XListView.MotionEventInterceptor
{
  public static long a;
  public static AtomicInteger a;
  private byte jdField_a_of_type_Byte;
  public int a;
  public aatx a;
  protected akkr a;
  Dialog jdField_a_of_type_AndroidAppDialog;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new aeaf(this);
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Uri jdField_a_of_type_AndroidNetUri;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new adzv(this);
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aeag(this);
  public View a;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  anvi jdField_a_of_type_Anvi = new aead(this);
  azip jdField_a_of_type_Azip = new aeac(this);
  public azrb a;
  private azww jdField_a_of_type_Azww = new aeaa(this);
  private azxd jdField_a_of_type_Azxd;
  private azxe jdField_a_of_type_Azxe;
  private azxf jdField_a_of_type_Azxf;
  private azxg jdField_a_of_type_Azxg;
  private azxh jdField_a_of_type_Azxh;
  private azxt jdField_a_of_type_Azxt;
  public bhie a;
  public birs a;
  private birt jdField_a_of_type_Birt = new adzz(this);
  public bkys a;
  public ProfileActivity.CardContactInfo a;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new aeab(this);
  @Deprecated
  public AbsProfileHeaderView a;
  private VasProfileTemplateController jdField_a_of_type_ComTencentMobileqqProfilecardVasVasProfileTemplateController;
  public RedTouch a;
  VasQuickUpdateManager.CallBacker jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker = new adzq(this);
  protected ProfileCardMoreInfoView a;
  public BusinessInfoCheckUpdate.AppInfo a;
  AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new adzx(this);
  PullToZoomHeaderListView jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView;
  private List<AbsListView.OnScrollListener> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  public int[] a;
  public String[] a;
  public int b;
  Handler.Callback jdField_b_of_type_AndroidOsHandler$Callback = new adzw(this);
  View jdField_b_of_type_AndroidViewView;
  public bkys b;
  boolean jdField_b_of_type_Boolean = false;
  int c;
  public View c;
  public boolean c;
  public View d;
  public boolean d;
  View e;
  public boolean e;
  public boolean f;
  public boolean g = false;
  private boolean h;
  private boolean i;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  }
  
  public FriendProfileCardActivity()
  {
    this.jdField_a_of_type_Azrb = new azrb();
    this.jdField_c_of_type_Boolean = true;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Aatx = null;
  }
  
  private ProfileActivity.AllInOne a(Intent paramIntent)
  {
    Object localObject = (ProfileActivity.AllInOne)paramIntent.getParcelableExtra("AllInOne");
    this.jdField_a_of_type_Azrb.jdField_b_of_type_Boolean = paramIntent.hasExtra("troopUin");
    if (this.jdField_a_of_type_Azrb.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Azrb.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("troopUin");
      this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard = new TroopMemberCard();
      if (localObject == null)
      {
        paramIntent = paramIntent.getStringExtra("memberUin");
        if (TextUtils.isEmpty(paramIntent))
        {
          paramIntent = this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
          localObject = ((anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).c(paramIntent);
          if ((localObject != null) && (((Friends)localObject).isFriend()))
          {
            paramIntent = new ProfileActivity.AllInOne(paramIntent, 1);
            paramIntent.jdField_h_of_type_JavaLangString = ((Friends)localObject).name;
            paramIntent.jdField_i_of_type_JavaLangString = ((Friends)localObject).remark;
          }
        }
      }
      for (;;)
      {
        if ((!TextUtils.isEmpty(this.jdField_a_of_type_Azrb.jdField_a_of_type_JavaLangString)) && (TextUtils.isEmpty(paramIntent.jdField_c_of_type_JavaLangString))) {
          paramIntent.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Azrb.jdField_a_of_type_JavaLangString;
        }
        if ((!TextUtils.isEmpty(paramIntent.jdField_c_of_type_JavaLangString)) && (TextUtils.isEmpty(paramIntent.d))) {
          paramIntent.d = ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).d(paramIntent.jdField_c_of_type_JavaLangString);
        }
        new bdlf(this.app).a("dc00899").b("Grp_mem_card").c("page").d("page_exp").a(new String[] { this.jdField_a_of_type_Azrb.jdField_a_of_type_JavaLangString }).a();
        return paramIntent;
        paramIntent = new ProfileActivity.AllInOne(paramIntent, 21);
        paramIntent.jdField_l_of_type_Int = 11;
        continue;
        break;
        paramIntent = (Intent)localObject;
      }
    }
    return localObject;
  }
  
  public static ProfileActivity.CardContactInfo a(ProfileActivity.AllInOne paramAllInOne)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramAllInOne != null)
    {
      localObject1 = localObject2;
      if (paramAllInOne.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject1 = localObject2;
        if (paramAllInOne.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
          localObject1 = (ProfileActivity.CardContactInfo)paramAllInOne.jdField_a_of_type_JavaUtilArrayList.get(0);
        }
      }
    }
    return localObject1;
  }
  
  public static String a(azrb paramazrb, QQAppInterface paramQQAppInterface)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int j = bhaa.a(paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    if (j == 0)
    {
      paramQQAppInterface = (QQAppInterface)localObject1;
      if (TextUtils.isEmpty(null)) {
        paramQQAppInterface = paramazrb.jdField_a_of_type_ArrayOfJavaLangString[4];
      }
      localObject1 = paramQQAppInterface;
      if (TextUtils.isEmpty(paramQQAppInterface)) {
        localObject1 = paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_JavaLangString;
      }
    }
    for (;;)
    {
      paramQQAppInterface = (QQAppInterface)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramQQAppInterface = paramazrb.jdField_a_of_type_ArrayOfJavaLangString[0];
      }
      localObject1 = paramQQAppInterface;
      if (TextUtils.isEmpty(paramQQAppInterface)) {
        localObject1 = paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString;
      }
      return localObject1;
      if ((j == 1000) || (j == 1020))
      {
        paramQQAppInterface = paramazrb.jdField_a_of_type_ArrayOfJavaLangString[1];
        localObject1 = paramQQAppInterface;
        if (TextUtils.isEmpty(paramQQAppInterface)) {
          localObject1 = paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.m;
        }
      }
      else if (j == 1021)
      {
        paramQQAppInterface = paramazrb.jdField_a_of_type_ArrayOfJavaLangString[2];
        localObject1 = paramQQAppInterface;
        if (TextUtils.isEmpty(paramQQAppInterface)) {
          localObject1 = paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.n;
        }
      }
      else if (j == 1004)
      {
        localObject1 = localObject2;
        if (paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d != null) {
          localObject1 = ContactUtils.getDiscussionMemberShowName(paramQQAppInterface, paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d, paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        }
      }
      else
      {
        localObject1 = localObject2;
        if (ProfileActivity.AllInOne.i(paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
          localObject1 = paramazrb.jdField_a_of_type_ArrayOfJavaLangString[3];
        }
      }
    }
  }
  
  public static String a(ProfileActivity.AllInOne paramAllInOne)
  {
    Object localObject1 = a(paramAllInOne);
    if (localObject1 != null) {}
    for (localObject1 = ((ProfileActivity.CardContactInfo)localObject1).b + ((ProfileActivity.CardContactInfo)localObject1).jdField_c_of_type_JavaLangString;; localObject1 = "")
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = paramAllInOne.jdField_a_of_type_JavaLangString;
      }
      return localObject2;
    }
  }
  
  public static void a(Activity paramActivity, azrb paramazrb, String paramString1, int paramInt, String paramString2)
  {
    Intent localIntent = AIOUtils.setOpenAIOIntent(new Intent(paramActivity, SplashActivity.class), null);
    localIntent.putExtra("PREVIOUS_WINDOW", FriendProfileCardActivity.class.getName());
    localIntent.putExtra("PREVIOUS_UIN", paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    if ((paramActivity.getIntent() != null) && (paramActivity.getIntent().getExtras() != null)) {
      localIntent.putExtra("cSpecialFlag", paramActivity.getIntent().getExtras().getInt("cSpecialFlag"));
    }
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", paramInt);
    localIntent.putExtra("aio_msg_source", 3);
    if (paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_j_of_type_Int != 0) {
      localIntent.putExtra("entrance", paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_j_of_type_Int);
    }
    localIntent.putExtra("uinname", paramString2);
    paramActivity.startActivity(localIntent);
  }
  
  public static void a(azrb paramazrb)
  {
    int m = 6;
    int j = 3;
    if (paramazrb.jdField_a_of_type_Bgvk == null) {
      paramazrb.jdField_a_of_type_Bgvk = new bgvk();
    }
    int k;
    switch (paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
    {
    default: 
      j = 1;
      k = 0;
    }
    for (;;)
    {
      bgvl.a(k, j, paramazrb.jdField_a_of_type_ArrayOfJavaLangString, paramazrb.jdField_a_of_type_Bgvk);
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, String.format(Locale.getDefault(), "updateProfileName profileName: %s", new Object[] { paramazrb.jdField_a_of_type_Bgvk.toString() }));
      }
      return;
      if (paramazrb.jdField_b_of_type_Boolean)
      {
        k = 3;
        j = 2;
      }
      else
      {
        j = 2;
        k = 1;
        continue;
        j = 2;
        k = 2;
        continue;
        if (paramazrb.jdField_b_of_type_Boolean)
        {
          k = 3;
          j = 2;
        }
        else
        {
          j = 2;
          k = 2;
          continue;
          k = 3;
          j = 2;
          continue;
          k = 3;
          j = 1;
          continue;
          k = 4;
          j = 1;
          continue;
          j = 2;
          k = m;
          continue;
          j = 1;
          k = m;
          continue;
          if (paramazrb.jdField_a_of_type_ComTencentMobileqqDataContactCard != null)
          {
            k = m;
            if (!TextUtils.isEmpty(paramazrb.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin)) {}
          }
          else
          {
            j = 1;
            k = m;
            continue;
            k = 7;
            j = 2;
            continue;
            k = 7;
            j = 1;
            continue;
            k = 8;
            j = 1;
            continue;
            k = 9;
            j = 1;
            continue;
            k = 11;
            j = 1;
            continue;
            j = 1;
            k = 1;
            continue;
            k = 5;
            j = 1;
          }
        }
      }
    }
  }
  
  /* Error */
  public static void a(QQAppInterface arg0, azrb paramazrb)
  {
    // Byte code:
    //   0: invokestatic 422	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +13 -> 16
    //   6: ldc_w 424
    //   9: iconst_2
    //   10: ldc_w 459
    //   13: invokestatic 442	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: aload_1
    //   17: getfield 196	azrb:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   20: getfield 231	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   23: astore 6
    //   25: aload_1
    //   26: getfield 196	azrb:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   29: getfield 236	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   32: astore_3
    //   33: aload_1
    //   34: getfield 196	azrb:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   37: getfield 306	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:m	Ljava/lang/String;
    //   40: astore 5
    //   42: aload_1
    //   43: getfield 196	azrb:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   46: getfield 461	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   49: astore 12
    //   51: aload_1
    //   52: getfield 196	azrb:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   55: getfield 464	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   58: astore 10
    //   60: aload_1
    //   61: getfield 196	azrb:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   64: getfield 466	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   67: astore 14
    //   69: aload_1
    //   70: getfield 196	azrb:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   73: getfield 309	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:n	Ljava/lang/String;
    //   76: astore 13
    //   78: aload 6
    //   80: astore 7
    //   82: aload 6
    //   84: astore 8
    //   86: aload_1
    //   87: getfield 196	azrb:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   90: invokestatic 468	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:b	(Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)Z
    //   93: ifeq +566 -> 659
    //   96: aload 6
    //   98: astore 7
    //   100: aload 6
    //   102: astore 8
    //   104: aload_0
    //   105: getstatic 206	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   108: invokevirtual 212	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   111: checkcast 214	anvk
    //   114: astore 4
    //   116: aload 4
    //   118: ifnonnull +516 -> 634
    //   121: aconst_null
    //   122: astore 11
    //   124: aload 6
    //   126: astore 9
    //   128: aload 11
    //   130: ifnull +867 -> 997
    //   133: aload 6
    //   135: astore 4
    //   137: aload 6
    //   139: astore 7
    //   141: aload 6
    //   143: astore 8
    //   145: aload 11
    //   147: getfield 229	com/tencent/mobileqq/data/Friends:name	Ljava/lang/String;
    //   150: invokestatic 193	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   153: ifne +18 -> 171
    //   156: aload 6
    //   158: astore 7
    //   160: aload 6
    //   162: astore 8
    //   164: aload 11
    //   166: getfield 229	com/tencent/mobileqq/data/Friends:name	Ljava/lang/String;
    //   169: astore 4
    //   171: aload 4
    //   173: astore 7
    //   175: aload 4
    //   177: astore 8
    //   179: aload 4
    //   181: astore 9
    //   183: aload 11
    //   185: getfield 234	com/tencent/mobileqq/data/Friends:remark	Ljava/lang/String;
    //   188: invokestatic 193	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   191: ifne +806 -> 997
    //   194: aload 4
    //   196: astore 7
    //   198: aload 4
    //   200: astore 8
    //   202: aload 11
    //   204: getfield 234	com/tencent/mobileqq/data/Friends:remark	Ljava/lang/String;
    //   207: astore 6
    //   209: aload 4
    //   211: astore_3
    //   212: aload 6
    //   214: astore 4
    //   216: aload_0
    //   217: getstatic 243	com/tencent/mobileqq/app/QQManagerFactory:TROOP_MANAGER	I
    //   220: invokevirtual 212	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   223: checkcast 245	com/tencent/mobileqq/app/TroopManager
    //   226: astore 8
    //   228: aload_1
    //   229: getfield 179	azrb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   232: astore 7
    //   234: aload 7
    //   236: astore 6
    //   238: aload 7
    //   240: invokestatic 193	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   243: ifeq +34 -> 277
    //   246: aload 7
    //   248: astore 6
    //   250: aload_1
    //   251: getfield 196	azrb:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   254: getfield 240	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:d	Ljava/lang/String;
    //   257: invokestatic 193	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   260: ifne +17 -> 277
    //   263: aload 8
    //   265: aload_1
    //   266: getfield 196	azrb:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   269: getfield 240	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:d	Ljava/lang/String;
    //   272: invokevirtual 470	com/tencent/mobileqq/app/TroopManager:c	(Ljava/lang/String;)Ljava/lang/String;
    //   275: astore 6
    //   277: aload 6
    //   279: invokestatic 193	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   282: ifne +696 -> 978
    //   285: aload 8
    //   287: ifnull +691 -> 978
    //   290: aload_0
    //   291: aload 6
    //   293: aload_1
    //   294: getfield 196	azrb:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   297: getfield 197	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   300: invokestatic 473	com/tencent/mobileqq/utils/ContactUtils:getTroopMemberColorNick	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   303: astore_0
    //   304: aload 10
    //   306: invokestatic 193	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   309: ifeq +662 -> 971
    //   312: aload_1
    //   313: getfield 196	azrb:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   316: invokestatic 321	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	(Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)Lcom/tencent/mobileqq/activity/ProfileActivity$CardContactInfo;
    //   319: astore 5
    //   321: aload 5
    //   323: ifnull +648 -> 971
    //   326: aload 5
    //   328: getfield 474	com/tencent/mobileqq/activity/ProfileActivity$CardContactInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   331: astore 5
    //   333: aload 4
    //   335: astore 6
    //   337: aload 5
    //   339: astore 9
    //   341: aload_3
    //   342: astore 4
    //   344: aload 6
    //   346: astore 5
    //   348: aload_0
    //   349: astore 6
    //   351: aload_1
    //   352: getfield 303	azrb:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   355: astore_0
    //   356: aload_0
    //   357: monitorenter
    //   358: aload_1
    //   359: getfield 303	azrb:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   362: iconst_0
    //   363: aaload
    //   364: invokestatic 193	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   367: ifeq +11 -> 378
    //   370: aload_1
    //   371: getfield 303	azrb:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   374: iconst_0
    //   375: aload 4
    //   377: aastore
    //   378: aload_1
    //   379: getfield 303	azrb:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   382: iconst_4
    //   383: aaload
    //   384: invokestatic 193	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   387: ifeq +11 -> 398
    //   390: aload_1
    //   391: getfield 303	azrb:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   394: iconst_4
    //   395: aload 5
    //   397: aastore
    //   398: aload_1
    //   399: getfield 303	azrb:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   402: iconst_3
    //   403: aaload
    //   404: invokestatic 193	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   407: ifeq +11 -> 418
    //   410: aload_1
    //   411: getfield 303	azrb:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   414: iconst_3
    //   415: aload 9
    //   417: aastore
    //   418: aload_1
    //   419: getfield 303	azrb:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   422: iconst_5
    //   423: aaload
    //   424: invokestatic 193	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   427: ifeq +11 -> 438
    //   430: aload_1
    //   431: getfield 303	azrb:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   434: iconst_5
    //   435: aload 12
    //   437: aastore
    //   438: aload_1
    //   439: getfield 303	azrb:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   442: iconst_1
    //   443: aaload
    //   444: invokestatic 193	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   447: ifeq +11 -> 458
    //   450: aload_1
    //   451: getfield 303	azrb:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   454: iconst_1
    //   455: aload 6
    //   457: aastore
    //   458: aload_1
    //   459: getfield 303	azrb:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   462: bipush 6
    //   464: aaload
    //   465: invokestatic 193	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   468: ifeq +12 -> 480
    //   471: aload_1
    //   472: getfield 303	azrb:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   475: bipush 6
    //   477: aload 14
    //   479: aastore
    //   480: aload_1
    //   481: getfield 303	azrb:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   484: iconst_2
    //   485: aaload
    //   486: invokestatic 193	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   489: ifeq +11 -> 500
    //   492: aload_1
    //   493: getfield 303	azrb:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   496: iconst_2
    //   497: aload 13
    //   499: aastore
    //   500: aload_0
    //   501: monitorexit
    //   502: invokestatic 422	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   505: ifeq +128 -> 633
    //   508: new 323	java/lang/StringBuilder
    //   511: dup
    //   512: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   515: astore_0
    //   516: aload_0
    //   517: ldc_w 476
    //   520: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: ldc_w 478
    //   526: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: aload 4
    //   531: invokestatic 482	bhbx:b	(Ljava/lang/String;)Ljava/lang/String;
    //   534: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: ldc_w 484
    //   540: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: aload 5
    //   545: invokestatic 482	bhbx:b	(Ljava/lang/String;)Ljava/lang/String;
    //   548: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: ldc_w 486
    //   554: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: aload 9
    //   559: invokestatic 482	bhbx:b	(Ljava/lang/String;)Ljava/lang/String;
    //   562: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: ldc_w 488
    //   568: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: aload 12
    //   573: invokestatic 482	bhbx:b	(Ljava/lang/String;)Ljava/lang/String;
    //   576: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: ldc_w 490
    //   582: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: aload 6
    //   587: invokestatic 482	bhbx:b	(Ljava/lang/String;)Ljava/lang/String;
    //   590: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: ldc_w 492
    //   596: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: aload 13
    //   601: invokestatic 482	bhbx:b	(Ljava/lang/String;)Ljava/lang/String;
    //   604: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: ldc_w 494
    //   610: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: aload 12
    //   615: invokestatic 482	bhbx:b	(Ljava/lang/String;)Ljava/lang/String;
    //   618: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: pop
    //   622: ldc_w 424
    //   625: iconst_2
    //   626: aload_0
    //   627: invokevirtual 335	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   630: invokestatic 496	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   633: return
    //   634: aload 6
    //   636: astore 7
    //   638: aload 6
    //   640: astore 8
    //   642: aload 4
    //   644: aload_1
    //   645: getfield 196	azrb:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   648: getfield 197	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   651: invokevirtual 498	anvk:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   654: astore 11
    //   656: goto -532 -> 124
    //   659: aload 6
    //   661: astore 7
    //   663: aload 6
    //   665: astore 8
    //   667: aload_1
    //   668: getfield 196	azrb:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   671: getfield 412	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   674: ifne +33 -> 707
    //   677: aload 6
    //   679: astore 7
    //   681: aload 6
    //   683: astore 8
    //   685: aload_0
    //   686: aload_1
    //   687: getfield 196	azrb:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   690: getfield 197	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   693: invokestatic 502	com/tencent/mobileqq/utils/ContactUtils:getAccountNickName	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   696: astore 6
    //   698: aload_3
    //   699: astore 4
    //   701: aload 6
    //   703: astore_3
    //   704: goto -488 -> 216
    //   707: aload 6
    //   709: astore 7
    //   711: aload 6
    //   713: astore 8
    //   715: aload 6
    //   717: astore 4
    //   719: aload 6
    //   721: invokestatic 193	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   724: ifeq +260 -> 984
    //   727: aload 6
    //   729: astore 7
    //   731: aload 6
    //   733: astore 8
    //   735: aload 6
    //   737: astore 4
    //   739: aload_1
    //   740: getfield 196	azrb:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   743: invokestatic 504	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:g	(Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)Z
    //   746: ifeq +238 -> 984
    //   749: aload 6
    //   751: astore 7
    //   753: aload 6
    //   755: astore 8
    //   757: aload_0
    //   758: aload_1
    //   759: getfield 196	azrb:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   762: getfield 197	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   765: iconst_0
    //   766: invokestatic 508	com/tencent/mobileqq/utils/ContactUtils:getNick	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)Ljava/lang/String;
    //   769: astore 4
    //   771: aload 4
    //   773: astore 7
    //   775: aload 4
    //   777: astore 8
    //   779: aload 4
    //   781: aload_1
    //   782: getfield 196	azrb:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   785: getfield 197	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   788: invokestatic 511	bhbx:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   791: istore_2
    //   792: iload_2
    //   793: ifeq +191 -> 984
    //   796: aconst_null
    //   797: astore 6
    //   799: aload_3
    //   800: astore 4
    //   802: aload 6
    //   804: astore_3
    //   805: goto -589 -> 216
    //   808: astore 8
    //   810: aload 5
    //   812: astore_0
    //   813: aload_0
    //   814: astore 6
    //   816: aload_3
    //   817: astore 5
    //   819: aload 7
    //   821: astore 4
    //   823: aload 10
    //   825: astore 9
    //   827: invokestatic 422	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   830: ifeq -479 -> 351
    //   833: ldc_w 424
    //   836: iconst_2
    //   837: aload 8
    //   839: invokevirtual 512	java/lang/Exception:toString	()Ljava/lang/String;
    //   842: invokestatic 496	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   845: aload_0
    //   846: astore 6
    //   848: aload_3
    //   849: astore 5
    //   851: aload 7
    //   853: astore 4
    //   855: aload 10
    //   857: astore 9
    //   859: goto -508 -> 351
    //   862: astore 7
    //   864: aload 5
    //   866: astore_0
    //   867: aload_0
    //   868: astore 6
    //   870: aload_3
    //   871: astore 5
    //   873: aload 8
    //   875: astore 4
    //   877: aload 10
    //   879: astore 9
    //   881: invokestatic 422	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   884: ifeq -533 -> 351
    //   887: ldc_w 424
    //   890: iconst_2
    //   891: aload 7
    //   893: invokevirtual 513	java/lang/Error:toString	()Ljava/lang/String;
    //   896: invokestatic 496	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   899: aload_0
    //   900: astore 6
    //   902: aload_3
    //   903: astore 5
    //   905: aload 8
    //   907: astore 4
    //   909: aload 10
    //   911: astore 9
    //   913: goto -562 -> 351
    //   916: astore_1
    //   917: aload_0
    //   918: monitorexit
    //   919: aload_1
    //   920: athrow
    //   921: astore 7
    //   923: aload_3
    //   924: astore 8
    //   926: aload 5
    //   928: astore_0
    //   929: aload 4
    //   931: astore_3
    //   932: goto -65 -> 867
    //   935: astore 7
    //   937: aload_3
    //   938: astore 8
    //   940: aload 4
    //   942: astore_3
    //   943: goto -76 -> 867
    //   946: astore 8
    //   948: aload_3
    //   949: astore 7
    //   951: aload 5
    //   953: astore_0
    //   954: aload 4
    //   956: astore_3
    //   957: goto -144 -> 813
    //   960: astore 8
    //   962: aload_3
    //   963: astore 7
    //   965: aload 4
    //   967: astore_3
    //   968: goto -155 -> 813
    //   971: aload 10
    //   973: astore 5
    //   975: goto -642 -> 333
    //   978: aload 5
    //   980: astore_0
    //   981: goto -677 -> 304
    //   984: aload 4
    //   986: astore 6
    //   988: aload_3
    //   989: astore 4
    //   991: aload 6
    //   993: astore_3
    //   994: goto -778 -> 216
    //   997: aload_3
    //   998: astore 4
    //   1000: aload 9
    //   1002: astore_3
    //   1003: goto -787 -> 216
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1006	1	paramazrb	azrb
    //   791	2	2	bool	boolean
    //   32	971	3	localObject1	Object
    //   114	885	4	localObject2	Object
    //   40	939	5	localObject3	Object
    //   23	969	6	localObject4	Object
    //   80	772	7	localObject5	Object
    //   862	30	7	localError1	java.lang.Error
    //   921	1	7	localError2	java.lang.Error
    //   935	1	7	localError3	java.lang.Error
    //   949	15	7	localObject6	Object
    //   84	694	8	localObject7	Object
    //   808	98	8	localException1	Exception
    //   924	15	8	localObject8	Object
    //   946	1	8	localException2	Exception
    //   960	1	8	localException3	Exception
    //   126	875	9	localObject9	Object
    //   58	914	10	str1	String
    //   122	533	11	localFriends	Friends
    //   49	565	12	str2	String
    //   76	524	13	str3	String
    //   67	411	14	str4	String
    // Exception table:
    //   from	to	target	type
    //   86	96	808	java/lang/Exception
    //   104	116	808	java/lang/Exception
    //   145	156	808	java/lang/Exception
    //   164	171	808	java/lang/Exception
    //   183	194	808	java/lang/Exception
    //   202	209	808	java/lang/Exception
    //   642	656	808	java/lang/Exception
    //   667	677	808	java/lang/Exception
    //   685	698	808	java/lang/Exception
    //   719	727	808	java/lang/Exception
    //   739	749	808	java/lang/Exception
    //   757	771	808	java/lang/Exception
    //   779	792	808	java/lang/Exception
    //   86	96	862	java/lang/Error
    //   104	116	862	java/lang/Error
    //   145	156	862	java/lang/Error
    //   164	171	862	java/lang/Error
    //   183	194	862	java/lang/Error
    //   202	209	862	java/lang/Error
    //   642	656	862	java/lang/Error
    //   667	677	862	java/lang/Error
    //   685	698	862	java/lang/Error
    //   719	727	862	java/lang/Error
    //   739	749	862	java/lang/Error
    //   757	771	862	java/lang/Error
    //   779	792	862	java/lang/Error
    //   358	378	916	finally
    //   378	398	916	finally
    //   398	418	916	finally
    //   418	438	916	finally
    //   438	458	916	finally
    //   458	480	916	finally
    //   480	500	916	finally
    //   500	502	916	finally
    //   917	919	916	finally
    //   216	234	921	java/lang/Error
    //   238	246	921	java/lang/Error
    //   250	277	921	java/lang/Error
    //   277	285	921	java/lang/Error
    //   290	304	921	java/lang/Error
    //   304	321	935	java/lang/Error
    //   326	333	935	java/lang/Error
    //   216	234	946	java/lang/Exception
    //   238	246	946	java/lang/Exception
    //   250	277	946	java/lang/Exception
    //   277	285	946	java/lang/Exception
    //   290	304	946	java/lang/Exception
    //   304	321	960	java/lang/Exception
    //   326	333	960	java/lang/Exception
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, azrb paramazrb)
  {
    int k = bhaa.a(paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    String str3 = a(paramazrb, paramQQAppInterface);
    String str2 = null;
    Object localObject;
    String str1;
    if (ProfileActivity.AllInOne.g(paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
    {
      localObject = paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      str2 = null;
      if (k != 1000) {
        break label379;
      }
      str1 = paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d;
    }
    for (;;)
    {
      label58:
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.FrdProfileCard", 2, "free call click");
      }
      bdla.b(paramQQAppInterface, "CliOper", "", "", "Two_call", "Clk_freecall", a(paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(a(paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      ChatActivityUtils.a(paramQQAppInterface, paramBaseActivity, k, (String)localObject, str3, str2, true, str1, true, true, null, "from_internal");
      switch (paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
      {
      default: 
        paramBaseActivity = "4";
      }
      for (;;)
      {
        bdla.b(paramQQAppInterface, "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, paramBaseActivity, "", "", "");
        return;
        str1 = str2;
        int j = k;
        if (paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53)
        {
          str1 = str2;
          j = k;
          if (paramazrb.jdField_a_of_type_ComTencentMobileqqDataContactCard != null)
          {
            str1 = str2;
            j = k;
            if (!TextUtils.isEmpty(paramazrb.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin))
            {
              str1 = paramazrb.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin;
              j = 0;
            }
          }
        }
        str2 = a(paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        localObject = str1;
        k = j;
        break;
        label379:
        if (k != 1004) {
          break label427;
        }
        str1 = paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString;
        break label58;
        paramBaseActivity = "4";
        continue;
        paramBaseActivity = "5";
        continue;
        paramBaseActivity = "6";
        continue;
        paramBaseActivity = "7";
      }
      label427:
      str1 = null;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, azrb paramazrb, Dialog paramDialog)
  {
    Object localObject1 = paramBaseActivity.getIntent().getBundleExtra("profile_extres");
    boolean bool;
    int m;
    int n;
    int j;
    int k;
    if (localObject1 != null)
    {
      bool = ((Bundle)localObject1).getBoolean("from_babyq", false);
      m = 3999;
      n = 0;
      j = n;
      k = m;
      switch (paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
      {
      default: 
        k = m;
        j = n;
      }
    }
    for (;;)
    {
      if (k == 3045) {
        bdla.b(paramQQAppInterface, "CliOper", "", "", "0X80085C5", "0X80085C5", 0, 0, String.valueOf(j), "", "", "");
      }
      if (k == 3094) {
        bdla.a(paramQQAppInterface, "dc00898", "", paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, "0X80092E2", "0X80092E2", 0, 0, String.valueOf(j), assw.a(), assw.a(paramQQAppInterface), assw.c());
      }
      if ((k != 3007) || (anxi.a(paramQQAppInterface, paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
        break label1571;
      }
      localObject1 = paramDialog;
      if (paramDialog == null) {
        localObject1 = anxi.a(paramBaseActivity, paramBaseActivity.getString(2131694232), new adzr(paramQQAppInterface, paramBaseActivity, paramazrb), new adzs());
      }
      if ((localObject1 != null) && (!((Dialog)localObject1).isShowing()) && (!paramBaseActivity.isFinishing())) {
        ((Dialog)localObject1).show();
      }
      return;
      bool = false;
      break;
      j = paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_l_of_type_Int;
      k = 3004;
      continue;
      j = 3;
      k = 3004;
      continue;
      j = 1;
      k = 3007;
      continue;
      j = 1;
      k = 3001;
      continue;
      j = paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_l_of_type_Int;
      k = 3020;
      continue;
      j = 1;
      k = 3017;
      continue;
      j = paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_l_of_type_Int;
      k = 3002;
      continue;
      j = 1;
      k = 3005;
      continue;
      j = 2;
      k = 3007;
      continue;
      j = 0;
      k = 3003;
      continue;
      j = 12;
      k = 3008;
      continue;
      j = 11;
      k = 3008;
      continue;
      j = 12;
      k = 3041;
      continue;
      j = 11;
      k = 3041;
      continue;
      j = 0;
      k = 3999;
      continue;
      j = 1;
      k = 3037;
      continue;
      j = 1;
      k = 3095;
      continue;
      j = 1;
      k = 3096;
      continue;
      j = 1;
      k = 3042;
      continue;
      j = 2;
      k = 3037;
      continue;
      j = 0;
      k = 3009;
      continue;
      k = 3006;
      j = 13;
      if (bool)
      {
        j = 1;
        k = 3084;
        continue;
        k = 3068;
        j = 1;
        if (bool)
        {
          j = 1;
          k = 3084;
          continue;
          if ((paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_l_of_type_Int == 16) || (paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_l_of_type_Int == 17))
          {
            j = paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_l_of_type_Int;
            k = 3006;
          }
          else
          {
            j = 1;
            k = 3075;
            continue;
            j = 1;
            k = 3009;
            continue;
            j = 1;
            k = 3006;
            continue;
            j = 0;
            k = 3013;
            continue;
            j = 1;
            k = 3003;
            continue;
            j = 1;
            k = 3014;
            continue;
            j = 2;
            k = 3003;
            continue;
            k = 3022;
            j = 1;
            if (bool)
            {
              j = 1;
              k = 3083;
              continue;
              j = 0;
              k = 3011;
              continue;
              if (paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 127)
              {
                j = 1;
                k = 3048;
              }
              else
              {
                j = 1;
                k = 3071;
                continue;
                j = 21;
                k = 3045;
                continue;
                j = 23;
                k = 3045;
                continue;
                k = 3045;
                j = 3;
                if (bool)
                {
                  j = 1;
                  k = 3083;
                  continue;
                  if (localObject1 != null) {}
                  for (j = ((Bundle)localObject1).getInt("tabID", 0);; j = 0)
                  {
                    k = 3045;
                    break;
                  }
                  j = 28;
                  k = 3045;
                  continue;
                  j = 4;
                  k = 3045;
                  continue;
                  j = 24;
                  k = 3045;
                  continue;
                  j = 20;
                  k = 3045;
                  continue;
                  j = 25;
                  k = 3045;
                  continue;
                  j = 1;
                  k = 3092;
                  continue;
                  j = paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_l_of_type_Int;
                  k = 3094;
                  continue;
                  j = 11;
                  k = 3072;
                  continue;
                  j = 12;
                  k = 3072;
                  continue;
                  j = 1;
                  k = 3018;
                  continue;
                  j = 15;
                  k = 3041;
                  continue;
                  j = 14;
                  k = 3041;
                  continue;
                  if (paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 118)
                  {
                    j = 3;
                    k = 3022;
                  }
                  else
                  {
                    j = n;
                    k = m;
                    if (paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 121)
                    {
                      j = 2;
                      k = 3022;
                      continue;
                      j = 23;
                      k = 3004;
                      continue;
                      j = paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_l_of_type_Int;
                      k = 3004;
                      continue;
                      j = 2;
                      k = 3080;
                      continue;
                      j = 4;
                      k = 3076;
                      continue;
                      j = 6;
                      k = 3076;
                      continue;
                      j = 2;
                      k = 3047;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label1571:
    if (paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard != null) {}
    for (localObject1 = bhaa.a(paramQQAppInterface.getApp().getApplicationContext(), paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard.shGender, paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard.age, paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard.strCountry, paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard.strProvince, paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard.strCity);; localObject1 = "")
    {
      Object localObject2;
      if ((paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 32) || (paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 31) || (paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 51) || (paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 50) || (paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 34) || (paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 36) || (paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53) || (paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 29))
      {
        ProfileActivity.CardContactInfo localCardContactInfo = a(paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        if ((localCardContactInfo == null) || (localCardContactInfo.jdField_c_of_type_JavaLangString == null) || (localCardContactInfo.jdField_c_of_type_JavaLangString.length() <= 0)) {
          break;
        }
        localObject2 = localCardContactInfo.b + localCardContactInfo.jdField_c_of_type_JavaLangString;
        paramDialog = localCardContactInfo.jdField_a_of_type_JavaLangString;
        paramQQAppInterface = paramDialog;
        if (TextUtils.isEmpty(localCardContactInfo.jdField_a_of_type_JavaLangString))
        {
          if (TextUtils.isEmpty(paramazrb.jdField_a_of_type_ArrayOfJavaLangString[3])) {
            break label1885;
          }
          paramQQAppInterface = paramazrb.jdField_a_of_type_ArrayOfJavaLangString[3];
        }
        for (;;)
        {
          paramQQAppInterface = AddFriendLogicActivity.a(paramBaseActivity, 2, (String)localObject2, null, k, j, paramQQAppInterface, null, FriendProfileCardActivity.class.getName(), paramBaseActivity.getString(2131690676), null);
          paramQQAppInterface.putExtra("param_return_profilecard_pa", paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int);
          paramQQAppInterface.putExtra("key_param_age_area", (String)localObject1);
          ProfileActivity.a(paramBaseActivity, paramQQAppInterface, paramazrb);
          paramBaseActivity.startActivity(paramQQAppInterface);
          return;
          label1885:
          if (!TextUtils.isEmpty(paramazrb.jdField_a_of_type_ArrayOfJavaLangString[0]))
          {
            paramQQAppInterface = paramazrb.jdField_a_of_type_ArrayOfJavaLangString[0];
          }
          else
          {
            paramQQAppInterface = paramDialog;
            if (!TextUtils.isEmpty(paramazrb.jdField_a_of_type_Bgvk.a.jdField_a_of_type_JavaLangString)) {
              paramQQAppInterface = paramazrb.jdField_a_of_type_Bgvk.a.jdField_a_of_type_JavaLangString;
            }
          }
        }
      }
      paramQQAppInterface = null;
      if ((3004 == k) && (!TextUtils.isEmpty(paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d)))
      {
        paramDialog = paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d;
        paramQQAppInterface = null;
        if ((paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 71) && (paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 72)) {
          break label2171;
        }
        paramQQAppInterface = paramazrb.jdField_a_of_type_ArrayOfJavaLangString[2];
        label2003:
        if (!TextUtils.isEmpty(paramQQAppInterface)) {
          break label2412;
        }
        paramQQAppInterface = paramazrb.jdField_a_of_type_ArrayOfJavaLangString[0];
      }
      label2409:
      label2412:
      for (;;)
      {
        localObject2 = paramBaseActivity.getIntent().getStringExtra("param_return_addr");
        if (localObject2 != null)
        {
          localObject1 = AddContactsActivity.class.getName();
          if (!((String)localObject2).equals(QidianProfileCardActivity.class.getName())) {
            break label2409;
          }
          localObject1 = localObject2;
        }
        for (;;)
        {
          localObject2 = paramQQAppInterface;
          if (TextUtils.isEmpty(paramQQAppInterface)) {
            localObject2 = paramazrb.jdField_a_of_type_Bgvk.a.jdField_a_of_type_JavaLangString;
          }
          paramQQAppInterface = AddFriendLogicActivity.a(paramBaseActivity, 1, paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramDialog, k, j, (String)localObject2, null, (String)localObject1, paramBaseActivity.getString(2131690676), null);
          paramQQAppInterface.putExtra("from_babyq", bool);
          ProfileActivity.a(paramBaseActivity, paramQQAppInterface, paramazrb);
          paramBaseActivity.startActivity(paramQQAppInterface);
          return;
          paramDialog = paramQQAppInterface;
          if (3005 != k) {
            break;
          }
          paramDialog = paramQQAppInterface;
          if (TextUtils.isEmpty(paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString)) {
            break;
          }
          paramDialog = paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString;
          break;
          label2171:
          if ((paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 77) && (paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 82) && (paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 81) && (paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 83) && (paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 84) && (paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 101) && (paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 103) && (paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 102) && (paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 107) && (paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 110)) {
            break label2003;
          }
          paramQQAppInterface = paramazrb.jdField_a_of_type_ArrayOfJavaLangString[5];
          break label2003;
          paramQQAppInterface = AddFriendLogicActivity.a(paramBaseActivity, 1, paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramDialog, k, j, paramQQAppInterface, null, FriendProfileCardActivity.class.getName(), paramBaseActivity.getString(2131690676), null);
          paramQQAppInterface.putExtra("from_babyq", bool);
          ProfileActivity.a(paramBaseActivity, paramQQAppInterface, paramazrb);
          if (k == 3094)
          {
            paramQQAppInterface.putExtra("entrance", paramBaseActivity.getIntent().getIntExtra("entrance", 2));
            paramQQAppInterface.removeExtra("param_return_addr");
            paramBaseActivity.startActivity(paramQQAppInterface);
            return;
          }
          paramQQAppInterface.putExtra("key_param_age_area", (String)localObject1);
          paramBaseActivity.startActivityForResult(paramQQAppInterface, 1000);
          return;
        }
      }
    }
  }
  
  static void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, azrb paramazrb, String paramString, int paramInt)
  {
    if (paramBaseActivity.getIntent() != null) {}
    for (boolean bool = paramBaseActivity.getIntent().getBooleanExtra("key_need_track_back", false);; bool = false)
    {
      Object localObject;
      Intent localIntent;
      if (bool)
      {
        localObject = new Intent(paramBaseActivity, ChatActivity.class);
        localIntent = AIOUtils.setOpenAIOIntent((Intent)localObject, null);
        localIntent.putExtra("PREVIOUS_WINDOW", FriendProfileCardActivity.class.getName());
        localIntent.putExtra("PREVIOUS_UIN", paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        if (paramBaseActivity.getIntent().getExtras() != null) {
          localIntent.putExtra("cSpecialFlag", paramBaseActivity.getIntent().getExtras().getInt("cSpecialFlag"));
        }
        localIntent.putExtra("uin", paramString);
        localIntent.putExtra("uintype", paramInt);
        localIntent.putExtra("aio_msg_source", 3);
        if (paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_j_of_type_Int != 0) {
          localIntent.putExtra("entrance", paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_j_of_type_Int);
        }
        localObject = a(paramazrb, paramQQAppInterface);
        if (localObject != null) {
          break label488;
        }
        paramString = "";
        label181:
        localIntent.putExtra("uinname", paramString);
        if (TextUtils.isEmpty(paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d)) {
          break label494;
        }
        localIntent.putExtra("troop_uin", paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d);
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_JavaLangString)) {
          localIntent.putExtra("troop_code", paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_JavaLangString);
        }
        if (paramInt == 1009) {
          localIntent.putExtra("rich_status_sig", paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b);
        }
        if (paramInt == 1001) {
          localIntent.putExtra("rich_accost_sig", paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b);
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("FriendProfileCardActivity", 4, String.format(Locale.getDefault(), "enterChar uin: %s name: %s sig: %s", new Object[] { bhbx.b(paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString), bhbx.b((String)localObject), bhbx.a(paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b) }));
        }
        paramQQAppInterface = (anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = paramQQAppInterface.a(paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          if ((paramQQAppInterface != null) && ((nwu.a(paramQQAppInterface.cSpecialFlag)) || (bjxa.b(paramQQAppInterface.cSpecialFlag)))) {
            localIntent.putExtra("chat_subType", 1);
          }
        }
        localIntent.putExtra("hidden_aio_msg_source", 2);
        if ((paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 70) || (paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g != 101)) {
          break label526;
        }
        localIntent.putExtra("is_from_manage_stranger", true);
        paramBaseActivity.startActivityForResult(localIntent, 1010);
        return;
        localObject = new Intent(paramBaseActivity, SplashActivity.class);
        break;
        label488:
        paramString = (String)localObject;
        break label181;
        label494:
        if (!TextUtils.isEmpty(paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString)) {
          localIntent.putExtra("troop_uin", paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString);
        }
      }
      label526:
      paramBaseActivity.startActivity(localIntent);
      return;
    }
  }
  
  private void a(Card paramCard, int paramInt)
  {
    boolean bool2;
    if ((paramInt == 8) && (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) && (!this.i))
    {
      this.i = true;
      bool2 = ((anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramCard.uin);
      if ((paramCard.lUserFlag & 0x800) == 0L) {
        break label133;
      }
    }
    label133:
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfileCardActivity", 2, String.format("onCardUpdate isFriend=%s profileFriend=%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) }));
      }
      if (bool1 != bool2) {
        ((FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendDetailInfo(paramCard.uin);
      }
      return;
    }
  }
  
  private boolean a(Intent paramIntent, ProfileActivity.AllInOne paramAllInOne)
  {
    if (paramIntent.hasExtra("param_wzry_data"))
    {
      paramIntent = paramIntent.getSerializableExtra("param_wzry_data");
      if (paramIntent != null)
      {
        paramAllInOne = KPLProfileCardActivity.a(this);
        paramAllInOne.putExtra("param_wzry_data", paramIntent);
        startActivity(paramAllInOne);
        finish();
        return true;
      }
    }
    if ((bhbx.b(paramAllInOne.jdField_a_of_type_JavaLangString)) && (bhbx.a(getApplicationContext())))
    {
      overridePendingTransition(0, 0);
      finish();
      return true;
    }
    if ((nut.b(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_Azrb.jdField_b_of_type_Boolean))
    {
      paramIntent = new Intent(this, QidianProfileCardActivity.class);
      paramIntent.putExtra("AllInOne", this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      super.startActivity(paramIntent);
      super.finish();
      return true;
    }
    return false;
  }
  
  public static boolean a(azrb paramazrb, int paramInt, String paramString)
  {
    if ((paramazrb == null) || (paramazrb.jdField_a_of_type_ArrayOfJavaLangString == null) || (paramInt < 0) || (paramInt >= paramazrb.jdField_a_of_type_ArrayOfJavaLangString.length)) {
      return false;
    }
    paramazrb.jdField_a_of_type_ArrayOfJavaLangString[paramInt] = paramString;
    return true;
  }
  
  private void b(Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("param_switches_changed", false)) && (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqDataCard != null))
    {
      paramIntent = null;
      if ((this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 56) && (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 57)) {
        break label95;
      }
    }
    for (paramIntent = this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b;; paramIntent = this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b) {
      label95:
      do
      {
        a(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqDataCard.feedPreviewTime, this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqDataCard.vSeed, paramIntent, true);
        return;
      } while ((this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 35) && (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 37) && (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 36));
    }
  }
  
  private void b(azrb paramazrb)
  {
    try
    {
      if ((this.jdField_a_of_type_Azxg != null) && (this.jdField_a_of_type_Azxg.a(paramazrb)))
      {
        Object localObject = this.jdField_a_of_type_Azxg.a();
        if (localObject != null)
        {
          localObject = ((azwp)localObject).a();
          this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView = ((AbsProfileHeaderView)localObject);
          this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView = ((AbsProfileHeaderView)localObject);
        }
      }
      if (this.jdField_a_of_type_Azxd != null) {
        this.jdField_a_of_type_Azxd.a(paramazrb);
      }
      if (this.jdField_a_of_type_Azxf != null) {
        this.jdField_a_of_type_Azxf.a(paramazrb);
      }
      if (this.jdField_a_of_type_Azxh != null) {
        this.jdField_a_of_type_Azxh.a(paramazrb);
      }
      return;
    }
    catch (Exception paramazrb)
    {
      QLog.e("FriendProfileCardActivity", 1, "notifyComponentDataUpdate fail.", paramazrb);
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, azrb paramazrb)
  {
    bhbr.a(true);
    ProfileActivity.AllInOne localAllInOne = paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
    int j = bhaa.a(localAllInOne);
    if ((localAllInOne.f != null) && (localAllInOne.f.length() > 0) && (localAllInOne.jdField_e_of_type_Int != 3000) && (localAllInOne.jdField_e_of_type_Int != 1) && (localAllInOne.jdField_e_of_type_Int != 2) && (localAllInOne.jdField_e_of_type_Int != 1033) && (localAllInOne.jdField_e_of_type_Int != 1034) && (localAllInOne.jdField_e_of_type_Int != 1044) && (localAllInOne.jdField_e_of_type_Int != 1045) && (localAllInOne.f.equals(localAllInOne.jdField_a_of_type_JavaLangString)))
    {
      paramQQAppInterface = new Intent();
      paramQQAppInterface.putExtra("finchat", true);
      paramBaseActivity.setResult(0, paramQQAppInterface);
      paramBaseActivity.finish();
      return;
    }
    String str = localAllInOne.jdField_a_of_type_JavaLangString;
    if (ProfileActivity.AllInOne.i(localAllInOne)) {
      if (localAllInOne.jdField_a_of_type_Int == 53) {
        if ((paramazrb.jdField_a_of_type_ComTencentMobileqqDataContactCard != null) && (!TextUtils.isEmpty(paramazrb.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin)))
        {
          j = 0;
          str = paramazrb.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin;
        }
      }
    }
    for (;;)
    {
      a(paramQQAppInterface, paramBaseActivity, paramazrb, str, j);
      return;
      j = 1006;
      continue;
      str = a(localAllInOne);
      continue;
      if (localAllInOne.jdField_a_of_type_Int == 3) {
        bdla.b(paramQQAppInterface, "CliOper", "", "", "WPA", "OpenAIO_scan", 0, 0, "", "", "", "");
      } else if (localAllInOne.g == 102) {
        bdla.b(paramQQAppInterface, "P_CliOper", "Svip", "", "Vip_maproam", "vip_maproam_RandomConversation", 0, 0, "", "", "", "");
      } else if (localAllInOne.g == 103) {
        bdla.b(paramQQAppInterface, "P_CliOper", "Svip", "", "Vip_maproam", "vip_maproam_superConversation", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void c(Intent paramIntent)
  {
    if (paramIntent == null) {
      if (QLog.isColorLevel()) {
        QLog.i("FriendProfileCardActivity", 2, "initAvatarManager failed intent null");
      }
    }
    Bundle localBundle;
    do
    {
      return;
      localBundle = paramIntent.getBundleExtra("profile_extres");
    } while ((localBundle == null) || (!localBundle.getBoolean("key_from_sdk_set_avatar", false)));
    this.jdField_a_of_type_Akkr = new akkr(this);
    this.jdField_a_of_type_Akkr.a(paramIntent);
    this.jdField_a_of_type_Akkr.a();
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 90)
    {
      anvk localanvk = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if ((localanvk == null) || (!localanvk.b(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
        break label229;
      }
    }
    label229:
    for (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int = 1;; this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int = 19)
    {
      if ((this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 100) && (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 34) && (!((awyz)this.app.getManager(QQManagerFactory.CONTACT_MANAGER)).i())) {
        this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int = 29;
      }
      if ((this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 53) && (TextUtils.equals(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int = 0;
      }
      if ((this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41) && (!TextUtils.isEmpty(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals("0"))) {
        this.jdField_c_of_type_Boolean = false;
      }
      return;
    }
  }
  
  private void o()
  {
    int j;
    if (bhbx.b(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int != 59) {
        break label239;
      }
      j = 1;
    }
    for (;;)
    {
      bdla.b(this.app, "dc00898", "", "", "0X800723B", "0X800723B", j, 0, "", "", "", "");
      label117:
      Object localObject2;
      Object localObject1;
      if (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 118)
      {
        bdla.b(null, "dc00898", "", "", "0X800A11E ", "0X800A11E ", 0, 0, "", "", "", "");
        bdla.b(this.app, "dc00898", "", "", "", "0X800A4BF", 0, 0, "", "", "", "");
        if (bhaa.a())
        {
          localObject2 = Locale.getDefault().getCountry();
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localObject2 = this.app;
          if (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
            break label332;
          }
        }
      }
      label332:
      for (j = 1;; j = 2)
      {
        bdla.b((QQAppInterface)localObject2, "dc00898", "", "", "0X8008CA2", "0X8008CA2", j, 0, "", "", (String)localObject1, "");
        azyh.a(this.app, this.jdField_a_of_type_Azrb);
        return;
        label239:
        if (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 1)
        {
          j = 2;
          break;
        }
        if (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int != 8) {
          break label337;
        }
        j = 3;
        break;
        if (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int != 121) {
          break label117;
        }
        bdla.b(this.app, "dc00898", "", "", "0X800A51D", "0X800A51D", 0, 0, "", "", "", "");
        break label117;
      }
      label337:
      j = 0;
    }
  }
  
  private void p()
  {
    baax localbaax;
    if (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 96)
    {
      localbaax = (baax)this.jdField_a_of_type_Azxt.a(1008);
      if (localbaax == null) {}
    }
    for (boolean bool = localbaax.b(this.jdField_a_of_type_Azrb);; bool = false)
    {
      if (!bool) {
        a(this.app, this, this.jdField_a_of_type_Azrb, this.jdField_a_of_type_AndroidAppDialog);
      }
      return;
    }
  }
  
  private void q()
  {
    Intent localIntent = AIOUtils.setOpenAIOIntent(new Intent(this, SplashActivity.class), null);
    localIntent.putExtra("uin", this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("PREVIOUS_WINDOW", FriendProfileCardActivity.class.getName());
    localIntent.putExtra("PREVIOUS_UIN", this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    Object localObject = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if ((this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isFriend) || ((localObject != null) && (((anvk)localObject).b(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))))
    {
      localIntent.putExtra("uintype", 0);
      String str = ContactUtils.getTroopMemberNameRemarkFirst(this.app, this.jdField_a_of_type_Azrb.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.nick;
      }
      localIntent.putExtra("uinname", (String)localObject);
      localIntent.putExtra("troop_code", this.jdField_a_of_type_Azrb.jdField_a_of_type_JavaLangString);
      localObject = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
      if (localObject == null) {
        break label244;
      }
      ((TroopManager)localObject).a(this.jdField_a_of_type_Azrb.jdField_a_of_type_JavaLangString, new adzu(this, localIntent));
    }
    label244:
    while (!QLog.isColorLevel())
    {
      return;
      localIntent.putExtra("uintype", 1000);
      break;
    }
    QLog.e("FriendProfileCardActivity", 2, "enterChatByTroopMember, troopManager is null");
  }
  
  private void r()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "updateTheme");
    }
    for (;;)
    {
      try
      {
        FrameLayout localFrameLayout = (FrameLayout)findViewById(16908290);
        if (this.jdField_a_of_type_Azrb.jdField_a_of_type_Azri == null) {
          break label224;
        }
        localFrameLayout.setForeground(null);
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(0);
        azri.a(this.jdField_a_of_type_AndroidViewView, "background", this.jdField_a_of_type_Azrb.jdField_a_of_type_Azri, "background");
        if (azri.a(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId))
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setBackgroundDrawable(null);
          if (ThemeUtil.isInNightMode(this.app))
          {
            if (this.jdField_c_of_type_AndroidViewView != null) {
              this.jdField_c_of_type_AndroidViewView.setVisibility(0);
            }
            if (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_Azrb.jdField_a_of_type_Azri)) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.profilecard.FrdProfileCard", 2, "update item style");
            }
            this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_Azrb, false, new String[0]);
          }
        }
        else
        {
          azri.a(this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView, "background", this.jdField_a_of_type_Azrb.jdField_a_of_type_Azri, "commonMaskBackground");
          continue;
        }
        if (this.jdField_c_of_type_AndroidViewView == null) {
          continue;
        }
      }
      catch (Exception localException)
      {
        QLog.e("FriendProfileCardActivity", 1, "updateTheme fail.", localException);
        return;
      }
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      continue;
      label224:
      if (azri.a(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId))
      {
        localException.setForeground(null);
        localException.setBackgroundDrawable(null);
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(0);
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setBackgroundResource(0);
        if (ThemeUtil.isInNightMode(this.app))
        {
          if (this.jdField_c_of_type_AndroidViewView != null) {
            this.jdField_c_of_type_AndroidViewView.setVisibility(0);
          }
        }
        else if (this.jdField_c_of_type_AndroidViewView != null) {
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("FriendProfileCardActivity", 2, "updateTheme: cardInfo.currentTemplate is null");
        }
        localException.setForeground(getResources().getDrawable(2130850115));
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(0);
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setBackgroundResource(0);
        if (this.jdField_c_of_type_AndroidViewView != null) {
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        }
      }
    }
  }
  
  private void s()
  {
    this.jdField_a_of_type_Byte = ((byte)bhhr.X(getApplication(), this.app.getCurrentAccountUin()));
    if ((this.jdField_a_of_type_Azrb.jdField_b_of_type_Boolean) && (TroopInfo.isQidianPrivateTroop(this.app, this.jdField_a_of_type_Azrb.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_Byte = 0;
    }
  }
  
  private void t()
  {
    try
    {
      u();
      v();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("FriendProfileCardActivity", 1, "initComponentCenter fail.", localException);
      finish();
    }
  }
  
  private void u()
  {
    if (this.jdField_a_of_type_Azxt == null)
    {
      this.jdField_a_of_type_Azxt = new ComponentCenter();
      this.jdField_a_of_type_Azxt.a(this);
    }
  }
  
  private void v()
  {
    FrameLayout localFrameLayout;
    if (this.jdField_a_of_type_Azxg == null)
    {
      localFrameLayout = (FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368831);
      if (localFrameLayout != null)
      {
        this.jdField_a_of_type_Azxg = ((azxg)azxr.a(102, this.jdField_a_of_type_Azxt, this.jdField_a_of_type_Azrb));
        this.jdField_a_of_type_Azxg.a(this.jdField_a_of_type_Birs, this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView, (ViewGroup)this.jdField_d_of_type_AndroidViewView);
        this.jdField_a_of_type_Azxg.a(this.jdField_a_of_type_Azww);
        this.jdField_a_of_type_Azxg.a(localFrameLayout);
        this.jdField_a_of_type_Azxg.g();
      }
    }
    if ((this.jdField_a_of_type_Azxe == null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView != null))
    {
      this.jdField_a_of_type_Azxe = ((azxe)azxr.a(103, this.jdField_a_of_type_Azxt, this.jdField_a_of_type_Azrb));
      this.jdField_a_of_type_Azxe.a(this.jdField_a_of_type_Birs, this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView);
      this.jdField_a_of_type_Azxe.a(this.jdField_a_of_type_Azww);
      this.jdField_a_of_type_Azxe.a(this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView);
      this.jdField_a_of_type_Azxe.g();
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setContentContainer(this.jdField_a_of_type_Azxe);
    }
    if (this.jdField_a_of_type_Azxd == null)
    {
      localFrameLayout = (FrameLayout)this.jdField_d_of_type_AndroidViewView.findViewById(2131373190);
      if (localFrameLayout != null)
      {
        this.jdField_a_of_type_Azxd = ((azxd)azxr.a(104, this.jdField_a_of_type_Azxt, this.jdField_a_of_type_Azrb));
        this.jdField_a_of_type_Azxd.a(localFrameLayout);
        this.jdField_a_of_type_Azxd.g();
      }
    }
    if (this.jdField_a_of_type_Azxf == null)
    {
      localFrameLayout = (FrameLayout)this.jdField_d_of_type_AndroidViewView.findViewById(2131373203);
      if (localFrameLayout != null)
      {
        this.jdField_a_of_type_Azxf = ((azxf)azxr.a(105, this.jdField_a_of_type_Azxt, this.jdField_a_of_type_Azrb));
        this.jdField_a_of_type_Azxf.a(localFrameLayout);
        this.jdField_a_of_type_Azxf.g();
      }
    }
    if (this.jdField_a_of_type_Azxh == null)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_d_of_type_AndroidViewView.findViewById(2131373212));
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null)
      {
        this.jdField_a_of_type_Azxh = ((azxh)azxr.a(106, this.jdField_a_of_type_Azxt, this.jdField_a_of_type_Azrb));
        this.jdField_a_of_type_Azxh.a(this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView);
        this.jdField_a_of_type_Azxh.a(this.jdField_a_of_type_Azww);
        this.jdField_a_of_type_Azxh.a(this.jdField_a_of_type_AndroidWidgetFrameLayout);
        this.jdField_a_of_type_Azxh.g();
      }
    }
  }
  
  private void w()
  {
    if (this.jdField_a_of_type_Azxg != null)
    {
      this.jdField_a_of_type_Azxg.h();
      this.jdField_a_of_type_Azxg = null;
    }
    if (this.jdField_a_of_type_Azxe != null)
    {
      this.jdField_a_of_type_Azxe.h();
      this.jdField_a_of_type_Azxe = null;
    }
    if (this.jdField_a_of_type_Azxd != null)
    {
      this.jdField_a_of_type_Azxd.h();
      this.jdField_a_of_type_Azxd = null;
    }
    if (this.jdField_a_of_type_Azxf != null)
    {
      this.jdField_a_of_type_Azxf.h();
      this.jdField_a_of_type_Azxf = null;
    }
    if (this.jdField_a_of_type_Azxh != null)
    {
      this.jdField_a_of_type_Azxh.h();
      this.jdField_a_of_type_Azxh = null;
    }
  }
  
  Card a(String paramString1, String paramString2)
  {
    anvk localanvk = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    paramString2 = localanvk.a(paramString2);
    if (paramString2 != null)
    {
      paramString1 = localanvk.c(paramString1);
      paramString1.strContactName = paramString2.strContactName;
      paramString1.strMobile = paramString2.mobileNo;
      paramString1.age = paramString2.bAge;
      paramString1.shAge = ((short)paramString2.bAge);
      paramString1.shGender = ((short)paramString2.bSex);
      paramString1.strProvince = paramString2.strProvince;
      paramString1.strCity = paramString2.strCity;
      paramString1.strCountry = paramString2.strCountry;
      localanvk.a(paramString1);
      return paramString1;
    }
    return null;
  }
  
  public String a(String paramString)
  {
    Object localObject = paramString;
    if (paramString != null)
    {
      localObject = paramString;
      if (!paramString.startsWith("+"))
      {
        localObject = paramString;
        if (paramString.length() == 11)
        {
          localObject = paramString;
          if (!paramString.startsWith("0"))
          {
            localObject = ((awyz)this.app.getManager(QQManagerFactory.CONTACT_MANAGER)).a();
            if ((localObject == null) || (TextUtils.isEmpty(((RespondQueryQQBindingStat)localObject).nationCode))) {
              break label101;
            }
            localObject = ((RespondQueryQQBindingStat)localObject).nationCode + paramString.trim();
          }
        }
      }
    }
    return localObject;
    label101:
    return "+86" + paramString.trim();
  }
  
  public void a()
  {
    Message localMessage;
    if (!this.jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "send async message to init card in db");
      }
      this.jdField_b_of_type_Boolean = true;
      if (this.jdField_a_of_type_Bkys != null)
      {
        localMessage = null;
        if (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33) {
          break label66;
        }
      }
    }
    for (;;)
    {
      if (localMessage != null) {
        this.jdField_a_of_type_Bkys.sendMessage(localMessage);
      }
      return;
      label66:
      if (ProfileActivity.AllInOne.g(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        if (QLog.isColorLevel()) {
          QLog.d("FriendProfileCardActivity", 2, "initCardInfo. SUBTHREAD_MSG_INIT_CARD");
        }
        localMessage = this.jdField_a_of_type_Bkys.obtainMessage();
        localMessage.what = 1;
        localMessage.obj = this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      }
      else
      {
        localMessage = this.jdField_a_of_type_Bkys.obtainMessage();
        localMessage.what = 2;
        localMessage.obj = this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      }
    }
  }
  
  void a(int paramInt)
  {
    Object localObject;
    int k;
    int j;
    if ((this.jdField_a_of_type_Azrb.jdField_b_of_type_Boolean) && (TroopInfo.isQidianPrivateTroop(this.app, this.jdField_a_of_type_Azrb.jdField_a_of_type_JavaLangString)))
    {
      localObject = ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).c(this.jdField_a_of_type_Azrb.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_Azxe != null)
      {
        bacf localbacf = (bacf)this.jdField_a_of_type_Azxe.a(1013);
        if (localbacf != null) {
          localbacf.a((TroopInfo)localObject);
        }
      }
      if ((((TroopInfo)localObject).isTroopAdmin(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) || (((TroopInfo)localObject).isTroopOwner(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
      {
        k = 1;
        j = 1;
      }
    }
    for (;;)
    {
      int n = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      int m = 0;
      for (;;)
      {
        if (m < n)
        {
          localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(m);
          if (localObject != null) {
            ((View)localObject).setVisibility(8);
          }
          m += 1;
          continue;
          k = 0;
          j = 0;
          break;
        }
      }
      switch (paramInt)
      {
      default: 
        j = 0;
        localObject = findViewById(2131373191);
        if (j != 0)
        {
          paramInt = 0;
          ((View)localObject).setVisibility(paramInt);
          localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
          if (j == 0) {
            break label1161;
          }
          paramInt = 0;
          ((LinearLayout)localObject).setVisibility(paramInt);
        }
        break;
      case 1: 
        label265:
        label283:
        if (this.jdField_a_of_type_Azrb.jdField_b_of_type_Boolean)
        {
          if (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
            a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 23, 2131694826, 1, 2131691186);
          }
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 81, 2131693196, 1, 2131691133);
          label355:
          localObject = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
          if (localObject == null) {
            break label1167;
          }
        }
        break;
      }
      label1161:
      label1167:
      for (boolean bool = ((anvk)localObject).b(this.app.getCurrentUin());; bool = true)
      {
        if ((this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) && (!bool))
        {
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 7, 2131693173, 2, 2131691120);
          break;
          if (bhha.a(this.app))
          {
            a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 92, 2131694827, 1, 2131694827);
            a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 81, 2131693196, 1, 2131691133);
            break label355;
          }
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 23, 2131694826, 1, 2131691186);
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 81, 2131693196, 1, 2131691133);
          break label355;
        }
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 8, 2131718512, 2, 2131691203);
        break;
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 7, 2131693173, 1, 2131691120);
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 20, this.jdField_a_of_type_Birs.a(), 1, this.jdField_a_of_type_Birs.a(), 0);
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4), 8, 2131718512, 2, 2131691203);
        break;
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 7, 2131693173, 1, 2131691120);
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4), 8, 2131718512, 2, 2131691203);
        break;
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 20, this.jdField_a_of_type_Birs.a(), 1, this.jdField_a_of_type_Birs.a(), 0);
        if ((k == 0) && (!bdvn.a()))
        {
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 95, 2131698397, 1, 2131698397);
          bdla.b(this.app, "", "", "", "0X800A1C4", "0X800A1C4", 0, 0, "", "", "", "");
        }
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4), 8, 2131718512, 2, 2131691203);
        break;
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 7, 2131693173, 1, 2131691120);
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 20, this.jdField_a_of_type_Birs.a(), 1, this.jdField_a_of_type_Birs.a(), 0);
        break;
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4), 7, 2131693173, 2, 2131691120);
        break;
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4), 8, 2131718512, 2, 2131691203);
        break;
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 20, this.jdField_a_of_type_Birs.a(), 1, this.jdField_a_of_type_Birs.a(), 0);
        break;
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 20, this.jdField_a_of_type_Birs.a(), 1, this.jdField_a_of_type_Birs.a(), 0);
        break;
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 59, 2131693245, 1, 2131693245);
        break;
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 59, 2131693245, 1, 2131693245);
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4), 7, 2131693173, 2, 2131691120);
        break;
        if (ProfileActivity.AllInOne.d(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 7, 2131693173, 1, 2131691120);
        }
        for (;;)
        {
          if ((k == 0) && (!bdvn.a())) {
            a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 77, 2131698397, 1, 2131698397);
          }
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4), 8, 2131718512, 2, 2131691203);
          break;
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 20, this.jdField_a_of_type_Birs.a(), 1, this.jdField_a_of_type_Birs.a(), 0);
        }
        paramInt = 8;
        break label265;
        paramInt = 8;
        break label283;
      }
      k = 0;
      j = 1;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).b(getTitleBarHeight());
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "requestUpdateCard() mHasTriedCount = " + this.jdField_c_of_type_Int);
    }
    if ((this.jdField_c_of_type_Int > 5) && (!paramBoolean)) {}
    anri localanri;
    do
    {
      return;
      localanri = (anri)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
    } while (localanri == null);
    this.jdField_c_of_type_Int += 1;
    byte[] arrayOfByte1;
    if (paramArrayOfByte1 == null)
    {
      arrayOfByte1 = new byte[1];
      arrayOfByte1[0] = 0;
    }
    for (;;)
    {
      byte[] arrayOfByte2;
      if (paramArrayOfByte2 == null)
      {
        arrayOfByte2 = new byte[1];
        arrayOfByte2[0] = 0;
      }
      for (;;)
      {
        int j = 12;
        byte b1 = 0;
        paramArrayOfByte1 = (aqjm)this.app.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER);
        if (paramArrayOfByte1 != null) {}
        for (paramBoolean = paramArrayOfByte1.a(1);; paramBoolean = false)
        {
          long l3 = a(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne, paramBoolean);
          switch (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
          {
          case 5: 
          case 6: 
          case 7: 
          case 8: 
          case 9: 
          case 10: 
          case 11: 
          case 12: 
          case 13: 
          case 14: 
          case 15: 
          case 16: 
          case 17: 
          case 18: 
          case 33: 
          case 38: 
          case 39: 
          case 43: 
          case 44: 
          case 48: 
          case 49: 
          case 54: 
          case 59: 
          case 62: 
          case 63: 
          case 64: 
          case 65: 
          case 66: 
          case 67: 
          case 68: 
          case 69: 
          case 76: 
          case 79: 
          case 85: 
          case 87: 
          case 88: 
          case 89: 
          case 90: 
          case 91: 
          case 92: 
          case 93: 
          case 94: 
          case 99: 
          case 100: 
          case 109: 
          case 114: 
          case 116: 
          case 118: 
          case 119: 
          default: 
            localanri.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 65535, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3999, arrayOfByte2, (byte)0);
            return;
          case 0: 
            localanri.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 0, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, this.jdField_a_of_type_Byte);
            return;
          case 60: 
            localanri.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 26, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, this.jdField_a_of_type_Byte);
            return;
          case 1: 
            localanri.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 1, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, this.jdField_a_of_type_Byte);
            return;
          case 78: 
            localanri.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 24, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 3022, arrayOfByte2, (byte)0);
            return;
          case 40: 
            localanri.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 1, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, this.jdField_a_of_type_Byte);
            return;
          case 41: 
            j = 6;
            paramArrayOfByte1 = "";
            if ((TextUtils.isEmpty(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals("0")))
            {
              j = 37;
              paramArrayOfByte1 = this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.o;
            }
            localanri.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, j, paramLong, (byte)0, 0L, 0L, arrayOfByte1, paramArrayOfByte1, l3, 10004, arrayOfByte2, (byte)0);
            return;
          case 42: 
          case 73: 
          case 86: 
            localanri.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 8, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
            return;
          case 36: 
            localanri.a(this.app.getCurrentAccountUin(), "0", 32, paramLong, (byte)0, 0L, 0L, arrayOfByte1, a(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne), l3, 3014, arrayOfByte2, (byte)0);
            return;
          case 30: 
            localanri.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 15, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, this.jdField_a_of_type_Byte);
            return;
          case 29: 
          case 31: 
          case 32: 
          case 34: 
          case 50: 
          case 51: 
          case 53: 
            j = 16;
            if (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 34) {
              j = 17;
            }
            if (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53) {
              j = 50;
            }
            break;
          }
          for (;;)
          {
            paramArrayOfByte1 = a(a(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne));
            localanri.a(this.app.getCurrentAccountUin(), "0", j, paramLong, (byte)0, 0L, 0L, arrayOfByte1, paramArrayOfByte1, l3, 10004, null, (byte)0);
            return;
            ((baox)this.app.getBusinessHandler(BusinessHandlerFactory.QCALLCARD_HANDLER)).a(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            return;
            if (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString == null) {
              break;
            }
            long l2 = 0L;
            try
            {
              l1 = Long.valueOf(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString).longValue();
              int k = 0;
              if (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 45)
              {
                j = 13;
                k = 1;
                paramArrayOfByte1 = this.app.getCurrentAccountUin();
                paramArrayOfByte2 = this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
                if (k != 1) {
                  break label1447;
                }
                b1 = this.jdField_a_of_type_Byte;
                localanri.a(paramArrayOfByte1, paramArrayOfByte2, j, paramLong, (byte)0, l1, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, b1);
              }
            }
            catch (Exception paramArrayOfByte1)
            {
              for (;;)
              {
                l1 = l2;
                if (QLog.isColorLevel())
                {
                  QLog.i("Q.profilecard.FrdProfileCard", 2, paramArrayOfByte1.toString());
                  l1 = l2;
                  continue;
                  if (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 46)
                  {
                    j = 4;
                  }
                  else
                  {
                    j = 14;
                    continue;
                    label1447:
                    b1 = 0;
                  }
                }
              }
            }
            long l1 = bhaa.a(this.app, this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
            if (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 20)
            {
              j = 2;
              b1 = 1;
              paramArrayOfByte1 = this.app.getCurrentAccountUin();
              paramArrayOfByte2 = this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
              if (b1 != 1) {
                break label1617;
              }
            }
            label1617:
            for (byte b2 = this.jdField_a_of_type_Byte;; b2 = 0)
            {
              localanri.a(paramArrayOfByte1, paramArrayOfByte2, j, paramLong, b1, l1, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, b2);
              return;
              if ((this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 21) || (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 58))
              {
                j = 5;
                b1 = 0;
                break;
              }
              if (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 22) {
                break;
              }
              j = 7;
              b1 = 0;
              break;
            }
            localanri.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 21, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
            return;
            localanri.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 10, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
            return;
            localanri.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 10, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
            return;
            localanri.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 31, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3001, arrayOfByte2, (byte)0);
            return;
            localanri.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 38, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3017, arrayOfByte2, (byte)0);
            return;
            localanri.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 27, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
            return;
            localanri.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 36, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
            return;
            if ((this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_Int == 3004) || (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_Int == 2004)) {
              if (TextUtils.isEmpty(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_JavaLangString)) {}
            }
            label2890:
            label2898:
            for (paramArrayOfByte1 = this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_JavaLangString;; paramArrayOfByte1 = "0")
            {
              paramArrayOfByte2 = paramArrayOfByte1;
              if (paramArrayOfByte1 == null) {}
              for (paramArrayOfByte2 = "0";; paramArrayOfByte2 = "0")
              {
                for (;;)
                {
                  l2 = 0L;
                  try
                  {
                    l1 = Long.parseLong(paramArrayOfByte2);
                    j = 11;
                    if (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 27) {
                      j = 35;
                    }
                    localanri.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, j, paramLong, (byte)0, l1, 0L, arrayOfByte1, "", l3, this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_Int, arrayOfByte2, (byte)0);
                    return;
                    if (TextUtils.isEmpty(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d)) {
                      break label2898;
                    }
                    paramArrayOfByte1 = (TroopInfo)this.app.getEntityManagerFactory().createEntityManager().find(TroopInfo.class, "troopcode=?", new String[] { this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d });
                    if (paramArrayOfByte1 == null) {
                      break label2898;
                    }
                    paramArrayOfByte1 = paramArrayOfByte1.troopuin;
                    break;
                    if ((this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_Int != 3005) && (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_Int != 2005)) {
                      break label2890;
                    }
                    paramArrayOfByte2 = this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_JavaLangString;
                  }
                  catch (Exception paramArrayOfByte1)
                  {
                    for (;;)
                    {
                      l1 = l2;
                      if (QLog.isColorLevel())
                      {
                        QLog.e("Q.profilecard.FrdProfileCard", 2, paramArrayOfByte1.toString());
                        l1 = l2;
                      }
                    }
                  }
                }
                localanri.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 25, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
                return;
                localanri.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 24, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
                return;
                localanri.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 12, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
                return;
                localanri.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 12, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3095, arrayOfByte2, (byte)0);
                return;
                localanri.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 12, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3096, arrayOfByte2, (byte)0);
                return;
                localanri.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 28, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, this.jdField_a_of_type_Byte);
                return;
                localanri.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 29, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
                return;
                localanri.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 30, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
                return;
                localanri.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 34, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
                return;
                localanri.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 33, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
                return;
                localanri.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 25, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3045, arrayOfByte2, (byte)0);
                return;
                localanri.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 53, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3094, arrayOfByte2, (byte)0);
                return;
                localanri.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 12, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3004, arrayOfByte2, (byte)0);
                return;
                localanri.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 12, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3004, arrayOfByte2, (byte)0);
                return;
                localanri.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 12, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3080, arrayOfByte2, (byte)0);
                return;
                localanri.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 12, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3076, arrayOfByte2, (byte)0);
                return;
              }
            }
          }
        }
        arrayOfByte2 = paramArrayOfByte2;
      }
      arrayOfByte1 = paramArrayOfByte1;
    }
  }
  
  protected void a(Intent paramIntent)
  {
    try
    {
      Object localObject = paramIntent.getComponent();
      if ((localObject != null) && (TextUtils.equals(((ComponentName)localObject).getClassName(), QQBrowserActivity.class.getName())))
      {
        localObject = paramIntent.getStringExtra("url");
        String str = paramIntent.getStringExtra("big_brother_source_key");
        if (TextUtils.isEmpty(str)) {
          paramIntent.putExtra("big_brother_source_key", "biz_src_jc_gxl");
        }
        if (QLog.isColorLevel()) {
          QLog.i("FriendProfileCardActivity", 2, String.format("dealIntent key: %s, url: %s", new Object[] { str, localObject }));
        }
      }
      return;
    }
    catch (Throwable paramIntent)
    {
      paramIntent.printStackTrace();
    }
  }
  
  void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramView, paramInt1, getString(paramInt2), paramInt3, getString(paramInt4), 0);
  }
  
  void a(View paramView, int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3)
  {
    int j = 2131167059;
    if (paramView == null) {}
    do
    {
      return;
      azpb localazpb = new azpb(paramInt1, null);
      paramView.setVisibility(0);
      if (paramInt2 == 0)
      {
        paramView = (ImageButton)paramView.findViewById(2131368633);
        paramView.setTag(localazpb);
        paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramView.setImageResource(paramInt3);
        paramView.setContentDescription(paramString2);
        return;
      }
      paramView = (Button)paramView.findViewById(2131380283);
      paramView.setTag(localazpb);
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.setContentDescription(paramString2);
      paramView.setText(paramString1);
      paramView.setSingleLine();
      if ((!a(paramInt1)) || (this.jdField_c_of_type_Boolean)) {
        break;
      }
      paramView.setTextColor(getResources().getColor(2131167106));
      paramView.setEnabled(this.jdField_c_of_type_Boolean);
    } while ((7 != paramInt1) || (!QSecFramework.a().a(1001).booleanValue()));
    QSecFramework.a().a(5, 0, 1, new Object[] { Integer.valueOf(1), paramView }, null);
    return;
    if (paramInt2 == 2)
    {
      paramInt2 = 2131167059;
      label205:
      if (!ThemeUtil.isInNightMode(this.app)) {
        break label243;
      }
      paramInt2 = j;
    }
    label243:
    for (;;)
    {
      paramView.setTextColor(getResources().getColor(paramInt2));
      break;
      paramInt2 = 2131167061;
      break label205;
    }
  }
  
  void a(LinearLayout paramLinearLayout)
  {
    paramLinearLayout.removeAllViews();
    this.jdField_e_of_type_AndroidViewView = null;
    int j = getResources().getDimensionPixelSize(2131296730);
    int k = getResources().getDimensionPixelSize(2131296730);
    if ((this.jdField_a_of_type_Azrb != null) && (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33))
    {
      LinearLayout.LayoutParams localLayoutParams;
      if ((this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_e_of_type_AndroidViewView = View.inflate(this, 2131562044, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = k;
        paramLinearLayout.addView(this.jdField_e_of_type_AndroidViewView, localLayoutParams);
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, this.jdField_e_of_type_AndroidViewView).d(30).e(30).a();
        if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
          c();
        }
        this.jdField_e_of_type_AndroidViewView = View.inflate(this, 2131562044, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = j;
        paramLinearLayout.addView(this.jdField_e_of_type_AndroidViewView, localLayoutParams);
        this.jdField_e_of_type_AndroidViewView = View.inflate(this, 2131561359, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = j;
        paramLinearLayout.addView(this.jdField_e_of_type_AndroidViewView, localLayoutParams);
      }
      if (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0)
      {
        this.jdField_e_of_type_AndroidViewView = View.inflate(this, 2131561373, null);
        localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.rightMargin = k;
        paramLinearLayout.addView(this.jdField_e_of_type_AndroidViewView, localLayoutParams);
        this.jdField_e_of_type_AndroidViewView = View.inflate(this, 2131561445, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = k;
        paramLinearLayout.addView(this.jdField_e_of_type_AndroidViewView, localLayoutParams);
        this.jdField_e_of_type_AndroidViewView = View.inflate(this, 2131561445, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = k;
        paramLinearLayout.addView(this.jdField_e_of_type_AndroidViewView, localLayoutParams);
        this.jdField_e_of_type_AndroidViewView = View.inflate(this, 2131561445, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = k;
        paramLinearLayout.addView(this.jdField_e_of_type_AndroidViewView, localLayoutParams);
        this.jdField_e_of_type_AndroidViewView = View.inflate(this, 2131561359, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = k;
        paramLinearLayout.addView(this.jdField_e_of_type_AndroidViewView, localLayoutParams);
      }
    }
  }
  
  public void a(ProfileActivity.CardContactInfo paramCardContactInfo)
  {
    Intent localIntent;
    if (paramCardContactInfo != null)
    {
      paramCardContactInfo = paramCardContactInfo.jdField_c_of_type_JavaLangString;
      if ((paramCardContactInfo == null) || (paramCardContactInfo.length() <= 0)) {
        break label149;
      }
      localIntent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + paramCardContactInfo));
    }
    for (;;)
    {
      try
      {
        startActivity(localIntent);
        this.app.getCallFacade().b(paramCardContactInfo);
        bdla.b(this.app, "CliOper", "", "", "P_prof", "call", a(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(a(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        return;
        paramCardContactInfo = null;
      }
      catch (Exception localException)
      {
        QLog.e("FriendProfileCardActivity", 1, "callContact fail.", localException);
        continue;
      }
      label149:
      a(2131693230, 1);
    }
  }
  
  public void a(Card paramCard, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "onSwitchedToFriend, uin: " + paramString + ", card = " + paramCard);
    }
    if (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33) {
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    }
    this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString = paramString;
    b(true);
    long l = 0L;
    if (paramCard != null)
    {
      l = paramCard.feedPreviewTime;
      paramString = paramCard.vSeed;
      this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqDataCard = paramCard;
      a(paramCard, false);
      paramCard = paramString;
      if ((this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 56) && (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 57)) {
        break label192;
      }
    }
    label192:
    for (paramString = this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b;; paramString = null)
    {
      a(l, paramCard, paramString, true);
      return;
      e();
      w();
      t();
      paramCard = null;
      break;
    }
  }
  
  public void a(Card paramCard, boolean paramBoolean)
  {
    int k = 99999;
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, String.format("updateCardInfo card=%s isNetRet=%s", new Object[] { paramCard, Boolean.valueOf(paramBoolean) }));
    }
    this.jdField_a_of_type_Bhie.a("initUpdateInfoStart", true);
    this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqDataCard = paramCard;
    this.jdField_a_of_type_Azrb.jdField_d_of_type_Boolean = paramBoolean;
    b(this.jdField_a_of_type_Azrb);
    r();
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_Azrb, paramBoolean, new String[0]);
    a(paramBoolean);
    int j;
    if ((this.jdField_a_of_type_Aatx != null) && (this.jdField_a_of_type_Aatx.isShowing()) && (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqDataCard != null))
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqDataCard.strReMark)) {
        this.jdField_a_of_type_Aatx.a(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqDataCard.strReMark + getResources().getString(2131698298));
      }
    }
    else
    {
      if (paramCard != null) {
        this.jdField_a_of_type_Azrb.jdField_b_of_type_Int = paramCard.extendFriendEntryAddFriend;
      }
      j = k;
      if (paramCard != null)
      {
        if (paramCard.mQQLevelType != 0) {
          break label340;
        }
        j = k;
      }
      label217:
      if (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break label348;
      }
      bdla.b(null, "dc00898", "", "", "qq_vip", "0X800A777", j, 0, "", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_Bhie.a("initUpdateInfoEnd", "initUpdateInfoStart", false);
      return;
      if (TextUtils.isEmpty(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqDataCard.strNick)) {
        break;
      }
      this.jdField_a_of_type_Aatx.a(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqDataCard.strNick + getResources().getString(2131698298));
      break;
      label340:
      j = paramCard.mQQLevelType;
      break label217;
      label348:
      bdla.b(null, "dc00898", "", "", "qq_vip", "0X800A776", j, 0, "", "", "", "");
    }
  }
  
  public void a(Card paramCard, boolean paramBoolean, int paramInt)
  {
    if (paramCard != null) {}
    for (;;)
    {
      Message localMessage;
      try
      {
        if (!QLog.isColorLevel()) {
          break label474;
        }
        QLog.d("FriendProfileCardActivity", 2, String.format("onCardUpdate isNetCard=%s msgType=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
      }
      finally {}
      if (paramCard.lCurrentBgId >= 0L)
      {
        bdla.b(this.app, "CliOper", "", "", "card_mall", "Prof_in_client", a(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(a(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), Long.toString(paramCard.lCurrentBgId), "", "");
        VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentUin(), "card_mall", "prof_in_client", "", 1, 0, 0, "", Integer.toString(a(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), paramCard.lCurrentBgId + "", paramCard.lCurrentStyleId + "", "", "", "", 0, 0, 0, 0);
      }
      a(paramCard, paramBoolean);
      a(this.jdField_a_of_type_Azrb);
      if ((paramCard.tempChatSig != null) && (paramCard.tempChatSig.length > 0)) {
        this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b = paramCard.tempChatSig;
      }
      a(paramCard, paramInt);
      if (this.jdField_a_of_type_ComTencentMobileqqProfilecardVasVasProfileTemplateController == null) {
        this.jdField_a_of_type_ComTencentMobileqqProfilecardVasVasProfileTemplateController = new VasProfileTemplateController(this);
      }
      this.jdField_a_of_type_ComTencentMobileqqProfilecardVasVasProfileTemplateController.a(paramCard, paramInt);
      boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqProfilecardVasVasProfileTemplateController.jdField_a_of_type_Boolean;
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqProfilecardVasVasProfileTemplateController.jdField_b_of_type_Boolean;
      boolean bool3 = this.jdField_a_of_type_ComTencentMobileqqProfilecardVasVasProfileTemplateController.jdField_c_of_type_Boolean;
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfileCardActivity", 2, String.format("onCardUpdate updateBG=%s updateStyle=%s updateDiyText=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) }));
      }
      if (this.jdField_b_of_type_Bkys != null)
      {
        this.jdField_b_of_type_Bkys.removeMessages(10);
        if (!paramBoolean) {
          continue;
        }
        j = 1;
        localMessage = this.jdField_b_of_type_Bkys.obtainMessage(5, j, paramInt, paramCard);
        if ((!bool1) || (!bool2)) {
          continue;
        }
        localMessage.arg2 = 12;
        localMessage.sendToTarget();
        if (bool3) {
          this.jdField_b_of_type_Bkys.obtainMessage(5, j, 17, paramCard).sendToTarget();
        }
      }
      return;
      int j = 0;
      continue;
      if (bool1)
      {
        localMessage.arg2 = 11;
        continue;
        label474:
        if (paramInt != 1) {
          if (paramInt != 8) {}
        }
      }
    }
  }
  
  public void a(ContactCard paramContactCard, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, String.format("updateContactCardInfo card=%s isNetRet=%s", new Object[] { paramContactCard, Boolean.valueOf(paramBoolean) }));
    }
    this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqDataContactCard = paramContactCard;
    this.jdField_a_of_type_Azrb.jdField_d_of_type_Boolean = paramBoolean;
    b(this.jdField_a_of_type_Azrb);
    if (a(paramContactCard, paramBoolean)) {
      a(this.jdField_a_of_type_Azrb);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_Azrb, paramBoolean, new String[0]);
    a(paramBoolean);
  }
  
  public void a(AbsListView.OnScrollListener paramOnScrollListener)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramOnScrollListener);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_JavaLangString = paramString;
    a(this.jdField_a_of_type_Azrb, 4, paramString);
    if (this.jdField_a_of_type_Azrb.jdField_a_of_type_Bgvk == null) {
      this.jdField_a_of_type_Azrb.jdField_a_of_type_Bgvk = new bgvk();
    }
    paramString = (bgvk)this.jdField_a_of_type_Azrb.jdField_a_of_type_Bgvk.clone();
    a(this.jdField_a_of_type_Azrb);
    switch (paramString.a(this.jdField_a_of_type_Azrb.jdField_a_of_type_Bgvk))
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_Azrb, true, new String[] { "map_key_qzone", "map_key_account_base_info" });
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.c(this.jdField_a_of_type_Azrb);
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView != null) {
          this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.c(this.jdField_a_of_type_Azrb);
        }
      }
    }
  }
  
  void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "update buttons");
    }
    if (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
      a(1);
    }
    label289:
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 80)
      {
        a(9);
        return;
      }
      if (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 53) {
        break;
      }
      if (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqDataContactCard.bindQQ) {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin)) {
          if (TextUtils.equals(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin, this.app.getCurrentAccountUin()))
          {
            a(0);
            this.jdField_b_of_type_Int = 0;
          }
        }
      }
      for (;;)
      {
        if ((!paramBoolean) || (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int != 105)) {
          break label289;
        }
        bdla.b(this.app, "CliOper", "", "", "0X800716B", "0X800716B", this.jdField_b_of_type_Int, 0, "", "", "", "");
        return;
        a(4);
        break;
        if (((awyz)this.app.getManager(QQManagerFactory.CONTACT_MANAGER)).c(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqDataContactCard.mobileNo) != null)
        {
          this.jdField_b_of_type_Int = 1;
          if (this.jdField_a_of_type_Azrb.jdField_b_of_type_Boolean) {}
          for (int j = 12;; j = 2)
          {
            a(j);
            break;
          }
        }
        this.jdField_b_of_type_Int = 2;
        a(11);
        continue;
        this.jdField_b_of_type_Int = 3;
        a(10);
      }
    }
    boolean bool4 = ProfileActivity.AllInOne.d(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    boolean bool1 = ProfileActivity.AllInOne.e(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    paramBoolean = ProfileActivity.AllInOne.c(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    if (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 113)
    {
      paramBoolean = false;
      bool1 = false;
    }
    boolean bool2 = bool1;
    boolean bool3 = bool4;
    if (bhbx.b(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
    {
      if (!this.h) {
        break label571;
      }
      paramBoolean = false;
      bool2 = false;
    }
    for (bool3 = false;; bool3 = bool4)
    {
      bool1 = bool2;
      if (ProfileActivity.AllInOne.k(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_ArrayOfByte != null)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_ArrayOfByte.length > 0) {
            bool1 = true;
          }
        }
      }
      if (!ProfileActivity.AllInOne.b(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        paramBoolean = false;
      }
      if ((bool1) && (this.jdField_a_of_type_Azrb.jdField_b_of_type_Boolean))
      {
        a(12);
        return;
      }
      if ((bool3) && (bool1) && (paramBoolean))
      {
        a(2);
        return;
      }
      if ((bool3) && (bool1))
      {
        a(3);
        return;
      }
      if ((bool1) && (paramBoolean))
      {
        a(4);
        return;
      }
      if ((bool3) && (paramBoolean))
      {
        a(5);
        return;
      }
      if (bool3)
      {
        a(6);
        return;
      }
      if (bool1)
      {
        a(7);
        return;
      }
      if (paramBoolean)
      {
        a(5);
        return;
      }
      a(0);
      return;
      label571:
      paramBoolean = false;
      bool2 = bool1;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    int k = 1;
    if ((this.app == null) || (this.jdField_b_of_type_Bkys == null) || (this.jdField_a_of_type_Azrb == null) || (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null)) {}
    label317:
    label336:
    label361:
    label362:
    for (;;)
    {
      return;
      if ((!ProfileActivity.AllInOne.b(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) && (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) && (!TextUtils.equals(paramString, this.app.getCurrentAccountUin())) && (!TextUtils.equals(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.app.getCurrentAccountUin())))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, String.format("checkAndSwitch2Friend phone: %s, check:%s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), bhbx.b(paramString) }));
        }
        Message localMessage;
        if (paramBoolean1)
        {
          localObject = a(paramString, a(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne));
          localMessage = Message.obtain();
          localMessage.what = 3;
          if (localObject == null) {}
          for (;;)
          {
            localMessage.obj = paramString;
            this.jdField_b_of_type_Bkys.sendMessage(localMessage);
            return;
            paramString = (String)localObject;
          }
        }
        Object localObject = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        int j;
        if (!paramBoolean2)
        {
          j = 1;
          if (j != 0) {
            break label361;
          }
          if (localObject != null) {
            break label317;
          }
          paramString = null;
          label236:
          if ((paramString == null) || (!paramString.isFriend())) {
            break label336;
          }
          j = k;
        }
        for (;;)
        {
          label251:
          if (j == 0) {
            break label362;
          }
          if (localObject == null) {}
          for (paramString = null;; paramString = ((anvk)localObject).b(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
          {
            localMessage = Message.obtain();
            localMessage.what = 3;
            localObject = paramString;
            if (paramString == null) {
              localObject = this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
            }
            localMessage.obj = localObject;
            this.jdField_b_of_type_Bkys.sendMessage(localMessage);
            return;
            j = 0;
            break;
            paramString = ((anvk)localObject).e(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            break label236;
            j = 0;
            break label251;
          }
        }
      }
    }
  }
  
  public void a(int[] paramArrayOfInt, int paramInt)
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangString == null) {
      this.jdField_a_of_type_ArrayOfJavaLangString = getResources().getStringArray(2130968636);
    }
    bkzi localbkzi = (bkzi)bkzz.a(this, null);
    paramInt = 0;
    if (paramInt < paramArrayOfInt.length)
    {
      if (paramArrayOfInt[paramInt] == 16) {
        localbkzi.d(this.jdField_a_of_type_ArrayOfJavaLangString[paramArrayOfInt[paramInt]]);
      }
      for (;;)
      {
        paramInt += 1;
        break;
        if ((paramArrayOfInt[paramInt] >= 0) && (paramArrayOfInt[paramInt] < this.jdField_a_of_type_ArrayOfJavaLangString.length)) {
          localbkzi.a(this.jdField_a_of_type_ArrayOfJavaLangString[paramArrayOfInt[paramInt]], 1);
        }
      }
    }
    localbkzi.a(new aeae(this, localbkzi));
    try
    {
      if (!isFinishing()) {
        localbkzi.show();
      }
      return;
    }
    catch (Exception paramArrayOfInt)
    {
      paramArrayOfInt.printStackTrace();
    }
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public boolean a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  boolean a(azrb paramazrb)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "checkParamValidate() cardInfo.allinone = " + paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    }
    if (paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) {}
    while (TextUtils.isEmpty(paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    if (ProfileActivity.AllInOne.g(paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {}
    try
    {
      baps.b(paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      if ((paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 56) || (paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 55)) {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, "rich statuc profile, ricthStatus id = " + paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_k_of_type_Int + ", entry = " + paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int);
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder(300);
          localStringBuilder.append("checkParamValidate, [pa: ").append(paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int).append(", uin: ").append(bhbx.b(paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
          if (ProfileActivity.e(paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)) {
            localStringBuilder.append(", allinone_discussUin: ").append(paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString);
          }
          if (ProfileActivity.f(paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)) {
            localStringBuilder.append(", allinone_troopUin: ").append(paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d).append(",  allinone_troopcode: ").append(paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_JavaLangString).append(", sub_source_id: ").append(paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_l_of_type_Int).append(", troopUin: ").append(paramazrb.jdField_a_of_type_JavaLangString);
          }
          Bundle localBundle = getIntent().getBundleExtra("flc_extra_param");
          if (localBundle != null)
          {
            localStringBuilder.append(", extra_param_troop_code: ").append(localBundle.getString("troop_code"));
            localStringBuilder.append(", extra_param_troop_uin: ").append(localBundle.getString("troop_uin"));
            localStringBuilder.append(", extra_param_notify_type: ").append(localBundle.getInt("flc_notify_type"));
            localStringBuilder.append(", extra_param_recommend_uin: ").append(localBundle.getString("flc_recommend_uin"));
          }
          localStringBuilder.append(", reportExtraParam: ").append(paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_AndroidOsBundle);
          localStringBuilder.append("]");
          QLog.i("addFriendTag", 2, localStringBuilder.toString());
        }
        return a();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.profilecard.FrdProfileCard", 2, "通讯录陌生人： cardInfo.allinone.uin = " + paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        break;
        paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_k_of_type_Int = 0;
      }
      return false;
    }
    catch (NumberFormatException paramazrb) {}
  }
  
  boolean a(Card paramCard, boolean paramBoolean)
  {
    if (paramCard == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateNameList by Card");
      }
      return false;
    }
    boolean bool2;
    if ((paramBoolean) || (!TextUtils.isEmpty(paramCard.strNick))) {
      if (!bhbx.a(this.jdField_a_of_type_Azrb.jdField_a_of_type_ArrayOfJavaLangString[0], paramCard.strNick))
      {
        bool2 = true;
        this.jdField_a_of_type_Azrb.jdField_a_of_type_ArrayOfJavaLangString[0] = paramCard.strNick;
      }
    }
    for (;;)
    {
      if (!paramBoolean)
      {
        bool1 = bool2;
        if (TextUtils.isEmpty(paramCard.strReMark)) {}
      }
      else
      {
        if ((!bool2) && (bhbx.a(this.jdField_a_of_type_Azrb.jdField_a_of_type_ArrayOfJavaLangString[4], paramCard.strReMark))) {
          break label496;
        }
        bool1 = true;
        label114:
        this.jdField_a_of_type_Azrb.jdField_a_of_type_ArrayOfJavaLangString[4] = paramCard.strReMark;
      }
      if (!paramBoolean)
      {
        paramBoolean = bool1;
        if (TextUtils.isEmpty(paramCard.strAutoRemark)) {}
      }
      else
      {
        if ((!bool1) && (bhbx.a(this.jdField_a_of_type_Azrb.jdField_a_of_type_ArrayOfJavaLangString[6], paramCard.strAutoRemark))) {
          break label501;
        }
        paramBoolean = true;
        label169:
        this.jdField_a_of_type_Azrb.jdField_a_of_type_ArrayOfJavaLangString[6] = paramCard.strAutoRemark;
      }
      boolean bool1 = paramBoolean;
      if (!TextUtils.isEmpty(paramCard.strContactName))
      {
        if ((paramBoolean) || (!bhbx.a(this.jdField_a_of_type_Azrb.jdField_a_of_type_ArrayOfJavaLangString[3], paramCard.strContactName)))
        {
          bool1 = true;
          label220:
          this.jdField_a_of_type_Azrb.jdField_a_of_type_ArrayOfJavaLangString[3] = paramCard.strContactName;
        }
      }
      else
      {
        paramBoolean = bool1;
        if (!TextUtils.isEmpty(paramCard.strAutoRemark)) {
          if ((!bool1) && (bhbx.a(this.jdField_a_of_type_Azrb.jdField_a_of_type_ArrayOfJavaLangString[2], paramCard.strAutoRemark))) {
            break label511;
          }
        }
      }
      label496:
      label501:
      label511:
      for (paramBoolean = true;; paramBoolean = false)
      {
        this.jdField_a_of_type_Azrb.jdField_a_of_type_ArrayOfJavaLangString[2] = paramCard.strAutoRemark;
        if (QLog.isColorLevel())
        {
          paramCard = new StringBuilder();
          paramCard.append("updateNameList()").append(", bRet = ").append(paramBoolean).append(", strNick = ");
          paramCard.append(bhbx.b(this.jdField_a_of_type_Azrb.jdField_a_of_type_ArrayOfJavaLangString[0])).append(", strRemark = ");
          paramCard.append(bhbx.b(this.jdField_a_of_type_Azrb.jdField_a_of_type_ArrayOfJavaLangString[4])).append(", strContactName = ");
          paramCard.append(bhbx.b(this.jdField_a_of_type_Azrb.jdField_a_of_type_ArrayOfJavaLangString[3])).append(", strCircleName = ");
          paramCard.append(bhbx.b(this.jdField_a_of_type_Azrb.jdField_a_of_type_ArrayOfJavaLangString[2])).append(", strRecommenName = ");
          paramCard.append(bhbx.b(this.jdField_a_of_type_Azrb.jdField_a_of_type_ArrayOfJavaLangString[5])).append(", strTroopNickName = ");
          paramCard.append(bhbx.b(this.jdField_a_of_type_Azrb.jdField_a_of_type_ArrayOfJavaLangString[1])).append(", strAutoRemark = ");
          paramCard.append(bhbx.b(this.jdField_a_of_type_Azrb.jdField_a_of_type_ArrayOfJavaLangString[6]));
          QLog.d("Q.profilecard.FrdProfileCard", 2, paramCard.toString());
        }
        return paramBoolean;
        bool2 = false;
        break;
        bool1 = false;
        break label114;
        paramBoolean = false;
        break label169;
        bool1 = false;
        break label220;
      }
      bool2 = false;
    }
  }
  
  public boolean a(ContactCard paramContactCard, boolean paramBoolean)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (paramContactCard == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateNameList by ContactCard");
      }
      return false;
    }
    if ((paramBoolean) || (!TextUtils.isEmpty(paramContactCard.nickName))) {
      if (!bhbx.a(this.jdField_a_of_type_Azrb.jdField_a_of_type_ArrayOfJavaLangString[0], paramContactCard.nickName))
      {
        paramBoolean = true;
        this.jdField_a_of_type_Azrb.jdField_a_of_type_ArrayOfJavaLangString[0] = paramContactCard.nickName;
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramContactCard.strContactName))
      {
        if (!paramBoolean)
        {
          paramBoolean = bool2;
          if (bhbx.a(this.jdField_a_of_type_Azrb.jdField_a_of_type_ArrayOfJavaLangString[3], paramContactCard.strContactName)) {}
        }
        else
        {
          paramBoolean = true;
        }
        this.jdField_a_of_type_Azrb.jdField_a_of_type_ArrayOfJavaLangString[3] = paramContactCard.strContactName;
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53) {
          paramBoolean = bool1;
        }
        for (;;)
        {
          return paramBoolean;
          paramBoolean = false;
          break;
        }
      }
      paramBoolean = false;
    }
  }
  
  protected void b()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mobileqq.card.modify");
    localIntentFilter.setPriority(2147483647);
    try
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
        this.jdField_a_of_type_Boolean = true;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.profilecard.FrdProfileCard", 2, localThrowable.toString());
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, String.format("scrollToExtendsFriendInfo offset=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView instanceof VasProfileSimpleView)) {
      ((VasProfileSimpleView)this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView).e();
    }
    for (paramInt = getResources().getDisplayMetrics().heightPixels / 2 + paramInt;; paramInt = this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.getHeight() + paramInt)
    {
      paramInt -= getTitleBarHeight();
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfileCardActivity", 2, String.format("scrollToMoreInfoView offset=%s", new Object[] { Integer.valueOf(paramInt) }));
      }
      if (this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView != null) {
        this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.smoothScrollToPositionFromTop(0, -paramInt);
      }
      return;
    }
  }
  
  public void b(ProfileActivity.CardContactInfo paramCardContactInfo)
  {
    if (paramCardContactInfo != null)
    {
      paramCardContactInfo = paramCardContactInfo.jdField_c_of_type_JavaLangString;
      if ((paramCardContactInfo == null) || (paramCardContactInfo.length() <= 0)) {
        break label133;
      }
      Intent localIntent = new Intent();
      localIntent.setAction("android.intent.action.SENDTO");
      localIntent.setData(Uri.parse("smsto:" + paramCardContactInfo));
      startActivity(localIntent);
    }
    for (;;)
    {
      bdla.b(this.app, "CliOper", "", "", "P_prof", "send_sms", a(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(a(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      return;
      paramCardContactInfo = null;
      break;
      label133:
      a(2131693230, 1);
    }
  }
  
  public void b(AbsListView.OnScrollListener paramOnScrollListener)
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.remove(paramOnScrollListener);
    }
  }
  
  void b(String paramString)
  {
    if (isFinishing()) {
      return;
    }
    if ((this.jdField_a_of_type_Aatx != null) && (!this.jdField_a_of_type_Aatx.isShowing()))
    {
      this.jdField_a_of_type_Aatx.show();
      return;
    }
    this.jdField_a_of_type_Aatx = new aatx(this);
    this.jdField_a_of_type_Aatx.a(getResources().getString(2131698298));
    String str2 = getString(2131718624);
    String str1 = str2;
    if (paramString != null) {
      str1 = str2 + paramString;
    }
    paramString = new adzy(this, this);
    this.jdField_a_of_type_Aatx.a(str1, paramString);
    this.jdField_a_of_type_Aatx.a(paramString);
    this.jdField_a_of_type_Aatx.show();
  }
  
  void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "initCardContactInfoList");
    }
    Object localObject3;
    if ((ProfileActivity.AllInOne.b(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33) || (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 32) || (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 31) || (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 34) || (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 51) || (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 50) || (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 36) || (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 29) || (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53))
    {
      if (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.size() == 0)
      {
        localObject3 = (awyz)this.app.getManager(QQManagerFactory.CONTACT_MANAGER);
        if (localObject3 != null) {
          break label231;
        }
      }
    }
    label231:
    label496:
    do
    {
      return;
      Object localObject1;
      Object localObject2;
      if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        localObject1 = ((awyz)localObject3).a(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        localObject2 = localObject1;
        if (paramBoolean) {
          break label496;
        }
        localObject2 = (FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        if ((!((FriendListHandler)localObject2).isGetOnlineListRecently()) && (!((FriendListHandler)localObject2).shouldGetOnlineInfo())) {
          ((FriendListHandler)localObject2).getOnlineInfo(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, false);
        }
      }
      while (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53)
      {
        this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.add(new ProfileActivity.CardContactInfo(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_k_of_type_JavaLangString, this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, ""));
        return;
        localObject2 = ((awyz)localObject3).c(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = ((awyz)localObject3).b(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(((PhoneContact)localObject2).mobileCode))
            {
              this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject2).mobileCode;
              localObject1 = localObject2;
            }
          }
        }
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          localObject3 = (FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
          localObject2 = localObject1;
          if (!((FriendListHandler)localObject3).shouldGetOnlineInfo())
          {
            ((FriendListHandler)localObject3).getOnlineInfo(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, true);
            localObject2 = localObject1;
          }
        }
        localObject1 = localObject2;
      }
      if (localObject1 != null)
      {
        this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.add(new ProfileActivity.CardContactInfo(((PhoneContact)localObject1).name, ((PhoneContact)localObject1).mobileCode, ((PhoneContact)localObject1).nationCode));
        return;
      }
    } while ((this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33) && (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 32) && (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 31) && (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 34) && (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 51) && (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 50) && (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 36) && (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 29));
    this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.add(new ProfileActivity.CardContactInfo("", this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, ""));
  }
  
  void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null) {
      return;
    }
    bbbq localbbbq = (bbbq)this.app.getManager(QQManagerFactory.MGR_RED_TOUCH);
    this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = localbbbq.a(String.format("%d%s%d", new Object[] { Integer.valueOf(100100), ".", Integer.valueOf(100120) }));
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
    localbbbq.a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
  }
  
  public void c(ProfileActivity.CardContactInfo paramCardContactInfo)
  {
    if (paramCardContactInfo == null)
    {
      paramCardContactInfo = null;
      if ((paramCardContactInfo != null) && (paramCardContactInfo.length() > 0))
      {
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
          break label191;
        }
        if (("".equals(paramCardContactInfo)) || (paramCardContactInfo.equals(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_JavaLangString))) {
          break label180;
        }
        FriendListHandler localFriendListHandler = (FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        if (localFriendListHandler == null) {
          break label169;
        }
        localFriendListHandler.setFriendComment(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramCardContactInfo, false);
        this.jdField_a_of_type_Int |= 0x1;
        a(paramCardContactInfo);
      }
    }
    for (;;)
    {
      bdla.b(this.app, "CliOper", "", "", "P_prof", "Edit_name", a(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(a(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      return;
      paramCardContactInfo = paramCardContactInfo.jdField_a_of_type_JavaLangString;
      break;
      label169:
      a(2131693257, 1);
      continue;
      label180:
      a(2131693243, 1);
      continue;
      label191:
      a(2131694302, 1);
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo != null) && (this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.iNewFlag.get() != 0))
    {
      bbbq localbbbq = (bbbq)this.app.getManager(QQManagerFactory.MGR_RED_TOUCH);
      if (localbbbq != null) {
        localbbbq.b(String.format("%d%s%d", new Object[] { Integer.valueOf(100100), ".", Integer.valueOf(100120) }));
      }
      this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = null;
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, String.format("doOnActivityResult requestCode=%s resultCode=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_Azxt != null) {
      this.jdField_a_of_type_Azxt.a(paramInt1, paramInt2, paramIntent);
    }
    if (paramInt1 == 1022) {
      b(paramIntent);
    }
    label279:
    label296:
    do
    {
      Object localObject;
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
                  for (;;)
                  {
                    return;
                    if (paramInt1 != 4) {
                      break label296;
                    }
                    if ((paramInt2 == -1) && (paramIntent != null))
                    {
                      if (!paramIntent.hasExtra("result")) {
                        break label279;
                      }
                      paramIntent = paramIntent.getStringExtra("result");
                      if (QLog.isColorLevel()) {
                        QLog.d("FriendProfileCardActivity", 2, "onActivityResult, resultStr : " + paramIntent);
                      }
                      if (!TextUtils.isEmpty(paramIntent)) {
                        try
                        {
                          paramIntent = new JSONObject(paramIntent);
                          if (paramIntent != null)
                          {
                            paramIntent = paramIntent.get("payState");
                            if ((paramIntent != null) && ("0".equals(String.valueOf(paramIntent))))
                            {
                              a(0L, null, null, false);
                              return;
                            }
                          }
                        }
                        catch (JSONException paramIntent)
                        {
                          paramIntent.printStackTrace();
                          if (QLog.isColorLevel())
                          {
                            QLog.e("FriendProfileCardActivity", 2, "onActivityResult, JSONException : " + paramIntent.getMessage());
                            return;
                          }
                        }
                        catch (Exception paramIntent)
                        {
                          paramIntent.printStackTrace();
                        }
                      }
                    }
                  }
                } while (!QLog.isColorLevel());
                QLog.e("FriendProfileCardActivity", 2, "onActivityResult, Exception : " + paramIntent.getMessage());
                return;
              } while (!QLog.isColorLevel());
              QLog.e("FriendProfileCardActivity", 2, "onActivityResult, data contain no result key.");
              return;
              if (paramInt1 != 1010) {
                break;
              }
            } while ((this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g != 101) || (paramInt2 != -1));
            finish();
            return;
            if (paramInt1 != 1035) {
              break;
            }
          } while (this.jdField_a_of_type_Akkr == null);
          this.jdField_a_of_type_Akkr.a(paramInt2, paramIntent);
          return;
        } while (paramInt2 != -1);
        switch (paramInt1)
        {
        default: 
          return;
        case 5: 
          paramIntent = bheg.b(this, this.jdField_a_of_type_AndroidNetUri);
          paramInt1 = bhaa.b(this);
          localObject = new Intent();
          ((Intent)localObject).putExtra("Business_Origin", 100);
          PhotoUtils.startPhotoEdit((Intent)localObject, this, FriendProfileCardActivity.class.getName(), paramInt1, paramInt1, 1080, 1080, paramIntent, aoks.a());
          return;
        }
      } while (paramIntent == null);
      if (paramIntent.getBooleanExtra("finchat", false)) {
        finish();
      }
      for (;;)
      {
        b(paramIntent);
        return;
        localObject = paramIntent.getStringExtra("remark");
        if (!bhbx.a(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_JavaLangString, localObject)) {
          a((String)localObject);
        }
      }
      setResult(-1);
      finish();
      return;
      paramIntent = ((anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.app.getCurrentAccountUin());
    } while ((paramIntent == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView == null));
    this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqDataCard = paramIntent;
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_Azrb, true, new String[] { "map_key_tag" });
    return;
    paramIntent = new Intent(this, FriendProfileCardActivity.class);
    paramIntent.putExtra("AllInOne", new ProfileActivity.AllInOne(this.app.getCurrentAccountUin(), 0));
    paramIntent.putExtra("diyTextEditResult", true);
    startActivity(paramIntent);
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
    getWindow().setFormat(-3);
    getWindow().setBackgroundDrawable(new ColorDrawable(-1));
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Bhie = new bhie("FriendProfileCardActivity");
    Intent localIntent = getIntent();
    if ((this.app == null) || (TextUtils.isEmpty(this.app.getAccount())) || (localIntent == null))
    {
      QLog.e("FriendProfileCardActivity", 1, "doOnCreate invalid params 1.");
      finish();
      return false;
    }
    ProfileActivity.AllInOne localAllInOne = a(localIntent);
    this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = localAllInOne;
    this.jdField_a_of_type_Azrb.jdField_a_of_type_AndroidViewView$OnClickListener = this.jdField_a_of_type_AndroidViewView$OnClickListener;
    this.jdField_a_of_type_Birs = new birs(this.app, this.jdField_a_of_type_Birt);
    this.jdField_a_of_type_Azrb.jdField_a_of_type_Birs = this.jdField_a_of_type_Birs;
    this.h = localIntent.getBooleanExtra("key_from_ark_babyq", false);
    this.jdField_e_of_type_Boolean = localIntent.getBooleanExtra("key_from_extends_friend", false);
    this.f = localIntent.getBooleanExtra("key_from_extends_friend_limit_chat", false);
    if (!a(this.jdField_a_of_type_Azrb))
    {
      QLog.e("FriendProfileCardActivity", 1, "doOnCreate invalid params 2.");
      finish();
      return false;
    }
    if (a(localIntent, localAllInOne))
    {
      QLog.e("FriendProfileCardActivity", 1, "doOnCreate jump to other.");
      return false;
    }
    this.jdField_a_of_type_Bkys = new bkys(ThreadManager.getSubThreadLooper(), this.jdField_b_of_type_AndroidOsHandler$Callback);
    this.jdField_b_of_type_Bkys = new bkys(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    n();
    m();
    s();
    b();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    addObserver(this.jdField_a_of_type_Anvi);
    this.app.registObserver(this.jdField_a_of_type_Azip);
    ((VasQuickUpdateManager)this.app.getManager(QQManagerFactory.VAS_QUICKUPDATE_MANAGER)).addCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
    try
    {
      b(false);
      if (bhln.a == null) {
        ThreadManager.excute(new FriendProfileCardActivity.2(this), 16, null, true);
      }
      this.jdField_a_of_type_Azrb.jdField_a_of_type_ArrayOfJavaLangString = new String[8];
      ThreadManager.excute(new FriendProfileCardActivity.3(this), 16, null, true);
      e();
      if (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33) {
        a();
      }
      for (;;)
      {
        g();
        o();
        c(getIntent());
        t();
        if (this.jdField_a_of_type_Azxt != null) {
          this.jdField_a_of_type_Azxt.a(this, paramBundle);
        }
        return true;
        a(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqDataCard, false);
      }
      return false;
    }
    catch (Exception paramBundle)
    {
      QLog.e("FriendProfileCardActivity", 1, "doOnCreate fail.", paramBundle);
      finish();
    }
  }
  
  @SuppressLint({"NewApi"})
  public void doOnDestroy()
  {
    if (this.jdField_b_of_type_Bkys != null)
    {
      this.jdField_b_of_type_Bkys.removeCallbacksAndMessages(null);
      this.jdField_b_of_type_Bkys.removeMessages(0);
    }
    if (this.jdField_a_of_type_Bkys != null)
    {
      this.jdField_a_of_type_Bkys.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Bkys.removeMessages(0);
      this.jdField_a_of_type_Bkys = null;
    }
    super.doOnDestroy();
    if (this.app != null) {
      this.app.removeHandler(getClass());
    }
    if (this.jdField_a_of_type_Birs != null) {
      this.jdField_a_of_type_Birs.a();
    }
    try
    {
      if (this.jdField_a_of_type_Boolean)
      {
        unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.jdField_a_of_type_Boolean = false;
      }
      removeObserver(this.jdField_a_of_type_Anvi);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      if (this.app != null) {
        this.app.unRegistObserver(this.jdField_a_of_type_Azip);
      }
      if (this.app != null)
      {
        VasQuickUpdateManager localVasQuickUpdateManager = (VasQuickUpdateManager)this.app.getManager(QQManagerFactory.VAS_QUICKUPDATE_MANAGER);
        if (localVasQuickUpdateManager != null) {
          localVasQuickUpdateManager.removeCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
        }
      }
      if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()))
      {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
        this.jdField_a_of_type_AndroidAppDialog = null;
      }
      if (this.jdField_a_of_type_Aatx != null)
      {
        this.jdField_a_of_type_Aatx.dismiss();
        this.jdField_a_of_type_Aatx = null;
      }
      if ((this.jdField_a_of_type_Azrb != null) && (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (azri.a(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqDataCard))) {
        QLog.i("FriendProfileCardActivity", 1, "FriendProfileCardActivity.onDestroy()");
      }
      if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() == 0) {
        bhaa.a();
      }
      if (this.jdField_a_of_type_Akkr != null) {
        this.jdField_a_of_type_Akkr.f();
      }
      if (this.jdField_a_of_type_Azxt != null) {
        this.jdField_a_of_type_Azxt.f();
      }
      w();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (this.jdField_a_of_type_Azxt != null) {
      this.jdField_a_of_type_Azxt.a(paramIntent);
    }
    if (paramIntent != null)
    {
      if (paramIntent.getBooleanExtra("key_back_from_add_friend", false)) {
        doOnActivityResult(1000, -1, paramIntent);
      }
      ProfileActivity.AllInOne localAllInOne = (ProfileActivity.AllInOne)paramIntent.getParcelableExtra("AllInOne");
      if ((localAllInOne != null) && (localAllInOne.jdField_h_of_type_Int == 115))
      {
        this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = localAllInOne;
        a(0L, null, null, false);
      }
      if (this.jdField_a_of_type_Akkr == null) {
        c(paramIntent);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_Akkr.b(paramIntent);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_Azxt != null) {
      this.jdField_a_of_type_Azxt.d();
    }
    AbstractVideoImage.pauseAll();
    ApngImage.pauseAll();
  }
  
  public void doOnPostResume()
  {
    super.doOnPostResume();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_Azxt != null) {
      this.jdField_a_of_type_Azxt.c();
    }
    AbstractVideoImage.resumeAll();
    ApngImage.playByTag(9);
    c();
    k();
    if ((this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 115) && (AddFriendLogicActivity.jdField_b_of_type_Boolean)) {
      b(getIntent().getStringExtra("src_name"));
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if (this.jdField_a_of_type_Azxt != null) {
      this.jdField_a_of_type_Azxt.b();
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    if (this.jdField_a_of_type_Azxt != null) {
      this.jdField_a_of_type_Azxt.e();
    }
    if ((this.jdField_a_of_type_Aatx != null) && (this.jdField_a_of_type_Aatx.isShowing()))
    {
      this.jdField_a_of_type_Aatx.dismiss();
      this.jdField_a_of_type_Aatx = null;
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      this.jdField_a_of_type_Bhie.a("doOnWindowFocusChanged", false);
      if (this.jdField_a_of_type_Azxf != null)
      {
        baan localbaan = (baan)this.jdField_a_of_type_Azxf.a(1020);
        if (localbaan != null) {
          localbaan.a();
        }
      }
    }
  }
  
  @TargetApi(11)
  void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "initInfoCardCommonLayout");
    }
    this.jdField_a_of_type_Bhie.a("initInfoCardCommonLayoutStart", true);
    this.jdField_d_of_type_AndroidViewView = View.inflate(this, 2131561430, null);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView = ((PullToZoomHeaderListView)this.jdField_d_of_type_AndroidViewView.findViewById(2131365022));
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.setMotionEventInterceptor(this);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.setNeedCheckSpringback(true);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.setOnScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
    this.jdField_b_of_type_AndroidViewView = this.jdField_d_of_type_AndroidViewView.findViewById(2131365293);
    this.jdField_c_of_type_AndroidViewView = this.jdField_d_of_type_AndroidViewView.findViewById(2131374420);
    this.jdField_a_of_type_AndroidViewView = View.inflate(this, 2131561382, null);
    Object localObject = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368825);
    if (localObject != null) {}
    try
    {
      localObject = (Animatable)((ImageView)localObject).getDrawable();
      if (!((Animatable)localObject).isRunning()) {
        ((Animatable)localObject).start();
      }
      label172:
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView = ((ProfileCardMoreInfoView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368839));
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_Azrb, this.app, this, this.h, this.jdField_a_of_type_Birs);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_b_of_type_Boolean = this.jdField_e_of_type_Boolean;
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_c_of_type_Boolean = this.f;
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366421));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131379811));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_d_of_type_AndroidViewView.findViewById(2131364089));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.addHeaderView(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.setAdapter(new blha(null));
      localObject = new FriendProfileCardActivity.ProfileTopGestureLayout(this, this);
      ((FriendProfileCardActivity.ProfileTopGestureLayout)localObject).setOnFlingGesture(this);
      ((FriendProfileCardActivity.ProfileTopGestureLayout)localObject).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      ((FriendProfileCardActivity.ProfileTopGestureLayout)localObject).addView(this.jdField_d_of_type_AndroidViewView);
      setContentView((View)localObject);
      localObject = (FrameLayout)findViewById(16908290);
      if (localObject != null) {
        ((FrameLayout)localObject).setBackgroundResource(2130845755);
      }
      if (this.jdField_b_of_type_Bkys != null)
      {
        localObject = this.jdField_b_of_type_Bkys.obtainMessage(10);
        this.jdField_b_of_type_Bkys.sendMessageDelayed((Message)localObject, 10000L);
      }
      this.jdField_a_of_type_Bhie.a("initInfoCardCommonLayoutEnd", "initInfoCardCommonLayoutStart", false);
      return;
    }
    catch (Exception localException)
    {
      break label172;
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Azrb.jdField_b_of_type_Boolean)
    {
      q();
      return;
    }
    if (ProfileActivity.AllInOne.k(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
    {
      assy.a(this.app).a(this.app, this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne, new adzt(this));
      return;
    }
    b(this.app, this, this.jdField_a_of_type_Azrb);
  }
  
  public void flingLToR()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView instanceof VasProfilePhotoView))
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.a("map_key_qzonecover");
      if (((localView instanceof QzonePhotoView)) && (((QzonePhotoView)localView).jdField_a_of_type_Boolean)) {
        return;
      }
    }
    onBackPressed();
  }
  
  public void flingRToL() {}
  
  void g()
  {
    if ((this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g == 100) && (GesturePWDUtils.getJumpLock(getActivity(), this.app.getCurrentAccountUin()))) {
      startUnlockActivity();
    }
  }
  
  public int getTitleBarHeight()
  {
    int j = 0;
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
      j = this.jdField_a_of_type_AndroidWidgetFrameLayout.getHeight();
    }
    return j;
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView != null) && (this.jdField_a_of_type_AndroidWidgetImageView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setDrawingCacheQuality(524288);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setDrawingCacheEnabled(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setVisibility(8);
      this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.getDrawingCache();
      this.jdField_a_of_type_AndroidViewView.findViewById(2131368847).setVisibility(8);
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(getResources(), this.jdField_a_of_type_AndroidGraphicsBitmap));
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
  }
  
  public void i()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView != null) && (this.jdField_a_of_type_AndroidWidgetImageView != null))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.destroyDrawingCache();
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setDrawingCacheEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setVisibility(0);
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      this.jdField_a_of_type_AndroidViewView.findViewById(2131368847).setVisibility(0);
    }
  }
  
  public boolean intercept(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView != null) {
      return this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.intercept(paramView, paramMotionEvent);
    }
    return false;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void j()
  {
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.smoothScrollToPosition(0);
  }
  
  void k()
  {
    ThreadManager.post(new FriendProfileCardActivity.17(this), 5, null, false);
  }
  
  public void l()
  {
    try
    {
      azym.a(this.app, this, this.jdField_a_of_type_Azrb);
      bdla.b(this.app, "CliOper", "", "", "0X8006A76", "0X8006A76", 0, 0, "", "", "", "");
      azyh.j(this.app, this.jdField_a_of_type_Azrb);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("FriendProfileCardActivity", 1, "forward2ProfileEdit fail.", localException);
      }
    }
  }
  
  public void m()
  {
    ThreadManager.post(new FriendProfileCardActivity.19(this), 5, null, false);
  }
  
  public boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_Azxt != null) && (this.jdField_a_of_type_Azxt.a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfileCardActivity", 2, "onBackEvent event cost by component");
      }
      return true;
    }
    if (this.jdField_a_of_type_Akkr != null) {
      this.jdField_a_of_type_Akkr.c();
    }
    return super.onBackEvent();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onPostThemeChanged()
  {
    if (ThemeUtil.isInNightMode(this.app)) {
      if (this.jdField_c_of_type_AndroidViewView != null) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      }
    }
    while (this.jdField_c_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
  }
  
  protected void onRestart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "friend profile card activity onRestart");
    }
    super.onRestart();
    if ((this.jdField_a_of_type_Azrb != null) && (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33))
    {
      this.jdField_a_of_type_Bhie = new bhie();
      this.jdField_d_of_type_Boolean = false;
      if (this.jdField_a_of_type_Bkys != null)
      {
        Message localMessage = this.jdField_a_of_type_Bkys.obtainMessage();
        if (ProfileActivity.AllInOne.g(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
        {
          localMessage.what = 1;
          localMessage.obj = this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
          this.jdField_a_of_type_Bkys.sendMessage(localMessage);
        }
      }
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    a(paramIntent);
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity
 * JD-Core Version:    0.7.0.1
 */