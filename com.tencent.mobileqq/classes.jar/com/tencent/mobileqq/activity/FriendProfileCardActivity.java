package com.tencent.mobileqq.activity;

import Override;
import SecurityAccountServer.RespondQueryQQBindingStat;
import abia;
import aepm;
import aepn;
import aepo;
import aepp;
import aepq;
import aepr;
import aeps;
import aept;
import aepu;
import aepv;
import aepw;
import aepx;
import aepy;
import aepz;
import aeqa;
import aeqb;
import aeqc;
import agej;
import akrf;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
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
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anum;
import anuw;
import anyu;
import anyw;
import anzj;
import aoat;
import aqmx;
import atci;
import atck;
import axfr;
import azov;
import azvr;
import azxr;
import azxy;
import bade;
import badl;
import bads;
import badt;
import badu;
import badv;
import badw;
import baeg;
import baei;
import baew;
import bafb;
import bagb;
import bagl;
import bahr;
import baoh;
import baou;
import bapc;
import bbav;
import bdll;
import bdlq;
import bduy;
import bhdg;
import bhdh;
import bhdi;
import bhhz;
import bhjs;
import bhjx;
import bhlg;
import bhmq;
import bhnv;
import bhrn;
import bhsi;
import bhsx;
import bhwl;
import bjaz;
import bjba;
import bkgt;
import blhq;
import blih;
import blir;
import blji;
import blrg;
import blrq;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCard;
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
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.PerfRelativeLayout;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqprotect.qsec.QSecFramework;
import com.tencent.widget.PullToZoomHeaderListView;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import nmd;
import nok;
import org.json.JSONException;
import org.json.JSONObject;

public class FriendProfileCardActivity
  extends ProfileActivity
  implements blrg, TopGestureLayout.OnGestureListener
{
  public static long a;
  public static AtomicInteger a;
  private byte jdField_a_of_type_Byte;
  public int a;
  public abia a;
  protected akrf a;
  Dialog jdField_a_of_type_AndroidAppDialog;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new aeqb(this);
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Uri jdField_a_of_type_AndroidNetUri;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new aepr(this);
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aeqc(this);
  public View a;
  public ViewGroup a;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  anuw jdField_a_of_type_Anuw = new aepx(this);
  anyu jdField_a_of_type_Anyu = new aepz(this);
  azov jdField_a_of_type_Azov = new aepy(this);
  public azxr a;
  private badl jdField_a_of_type_Badl = new aepw(this);
  private bads jdField_a_of_type_Bads;
  private badt jdField_a_of_type_Badt;
  private badu jdField_a_of_type_Badu;
  private badv jdField_a_of_type_Badv;
  private badw jdField_a_of_type_Badw;
  private baei jdField_a_of_type_Baei;
  public bhsx a;
  public bjaz a;
  private bjba jdField_a_of_type_Bjba = new aepv(this);
  public blhq a;
  blih jdField_a_of_type_Blih = new aept(this);
  public ProfileActivity.CardContactInfo a;
  @Deprecated
  public AbsProfileHeaderView a;
  private VasProfileTemplateController jdField_a_of_type_ComTencentMobileqqProfilecardVasVasProfileTemplateController;
  public RedTouch a;
  VasQuickUpdateManager.CallBacker jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker = new aepm(this);
  protected ProfileCardMoreInfoView a;
  public BusinessInfoCheckUpdate.AppInfo a;
  PullToZoomHeaderListView jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView;
  private List<blih> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  public int[] a;
  public String[] a;
  public int b;
  Handler.Callback jdField_b_of_type_AndroidOsHandler$Callback = new aeps(this);
  View jdField_b_of_type_AndroidViewView;
  public blhq b;
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
    this.jdField_a_of_type_Azxr = new azxr();
    this.jdField_c_of_type_Boolean = true;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Abia = null;
  }
  
  private ProfileActivity.AllInOne a(Intent paramIntent)
  {
    Object localObject = (ProfileActivity.AllInOne)paramIntent.getParcelableExtra("AllInOne");
    this.jdField_a_of_type_Azxr.jdField_b_of_type_Boolean = paramIntent.hasExtra("troopUin");
    if (this.jdField_a_of_type_Azxr.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Azxr.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("troopUin");
      this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard = new TroopMemberCard();
      if (localObject == null)
      {
        paramIntent = paramIntent.getStringExtra("memberUin");
        if (TextUtils.isEmpty(paramIntent))
        {
          paramIntent = this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
          localObject = ((anyw)this.app.getManager(51)).c(paramIntent);
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
        if ((!TextUtils.isEmpty(this.jdField_a_of_type_Azxr.jdField_a_of_type_JavaLangString)) && (TextUtils.isEmpty(paramIntent.jdField_c_of_type_JavaLangString))) {
          paramIntent.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Azxr.jdField_a_of_type_JavaLangString;
        }
        if ((!TextUtils.isEmpty(paramIntent.jdField_c_of_type_JavaLangString)) && (TextUtils.isEmpty(paramIntent.d))) {
          paramIntent.d = ((TroopManager)this.app.getManager(52)).d(paramIntent.jdField_c_of_type_JavaLangString);
        }
        new bdlq(this.app).a("dc00899").b("Grp_mem_card").c("page").d("page_exp").a(new String[] { this.jdField_a_of_type_Azxr.jdField_a_of_type_JavaLangString }).a();
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
  
  public static String a(azxr paramazxr, QQAppInterface paramQQAppInterface)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int j = bhhz.a(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    if (j == 0)
    {
      paramQQAppInterface = (QQAppInterface)localObject1;
      if (TextUtils.isEmpty(null)) {
        paramQQAppInterface = paramazxr.jdField_a_of_type_ArrayOfJavaLangString[4];
      }
      localObject1 = paramQQAppInterface;
      if (TextUtils.isEmpty(paramQQAppInterface)) {
        localObject1 = paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_JavaLangString;
      }
    }
    for (;;)
    {
      paramQQAppInterface = (QQAppInterface)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramQQAppInterface = paramazxr.jdField_a_of_type_ArrayOfJavaLangString[0];
      }
      localObject1 = paramQQAppInterface;
      if (TextUtils.isEmpty(paramQQAppInterface)) {
        localObject1 = paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString;
      }
      return localObject1;
      if ((j == 1000) || (j == 1020))
      {
        paramQQAppInterface = paramazxr.jdField_a_of_type_ArrayOfJavaLangString[1];
        localObject1 = paramQQAppInterface;
        if (TextUtils.isEmpty(paramQQAppInterface)) {
          localObject1 = paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.m;
        }
      }
      else if (j == 1021)
      {
        paramQQAppInterface = paramazxr.jdField_a_of_type_ArrayOfJavaLangString[2];
        localObject1 = paramQQAppInterface;
        if (TextUtils.isEmpty(paramQQAppInterface)) {
          localObject1 = paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.n;
        }
      }
      else if (j == 1004)
      {
        localObject1 = localObject2;
        if (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d != null) {
          localObject1 = bhlg.c(paramQQAppInterface, paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d, paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        }
      }
      else
      {
        localObject1 = localObject2;
        if (ProfileActivity.AllInOne.i(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
          localObject1 = paramazxr.jdField_a_of_type_ArrayOfJavaLangString[3];
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
  
  public static void a(Activity paramActivity, azxr paramazxr, String paramString1, int paramInt, String paramString2)
  {
    Intent localIntent = agej.a(new Intent(paramActivity, SplashActivity.class), null);
    localIntent.putExtra("PREVIOUS_WINDOW", FriendProfileCardActivity.class.getName());
    localIntent.putExtra("PREVIOUS_UIN", paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    if ((paramActivity.getIntent() != null) && (paramActivity.getIntent().getExtras() != null)) {
      localIntent.putExtra("cSpecialFlag", paramActivity.getIntent().getExtras().getInt("cSpecialFlag"));
    }
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", paramInt);
    localIntent.putExtra("aio_msg_source", 3);
    if (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_j_of_type_Int != 0) {
      localIntent.putExtra("entrance", paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_j_of_type_Int);
    }
    localIntent.putExtra("uinname", paramString2);
    paramActivity.startActivity(localIntent);
  }
  
  public static void a(azxr paramazxr)
  {
    int m = 6;
    int j = 3;
    if (paramazxr.jdField_a_of_type_Bhdh == null) {
      paramazxr.jdField_a_of_type_Bhdh = new bhdh();
    }
    int k;
    switch (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
    {
    default: 
      j = 1;
      k = 0;
    }
    for (;;)
    {
      bhdi.a(k, j, paramazxr.jdField_a_of_type_ArrayOfJavaLangString, paramazxr.jdField_a_of_type_Bhdh);
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, String.format(Locale.getDefault(), "updateProfileName profileName: %s", new Object[] { paramazxr.jdField_a_of_type_Bhdh.toString() }));
      }
      return;
      if (paramazxr.jdField_b_of_type_Boolean)
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
        if (paramazxr.jdField_b_of_type_Boolean)
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
          if (paramazxr.jdField_a_of_type_ComTencentMobileqqDataContactCard != null)
          {
            k = m;
            if (!TextUtils.isEmpty(paramazxr.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin)) {}
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
  public static void a(QQAppInterface arg0, azxr paramazxr)
  {
    // Byte code:
    //   0: invokestatic 413	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +13 -> 16
    //   6: ldc_w 415
    //   9: iconst_2
    //   10: ldc_w 450
    //   13: invokestatic 433	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: aload_1
    //   17: getfield 197	azxr:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   20: getfield 227	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   23: astore 6
    //   25: aload_1
    //   26: getfield 197	azxr:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   29: getfield 232	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   32: astore_3
    //   33: aload_1
    //   34: getfield 197	azxr:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   37: getfield 299	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:m	Ljava/lang/String;
    //   40: astore 5
    //   42: aload_1
    //   43: getfield 197	azxr:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   46: getfield 452	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   49: astore 12
    //   51: aload_1
    //   52: getfield 197	azxr:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   55: getfield 455	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   58: astore 10
    //   60: aload_1
    //   61: getfield 197	azxr:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   64: getfield 457	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   67: astore 14
    //   69: aload_1
    //   70: getfield 197	azxr:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   73: getfield 302	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:n	Ljava/lang/String;
    //   76: astore 13
    //   78: aload 6
    //   80: astore 7
    //   82: aload 6
    //   84: astore 8
    //   86: aload_1
    //   87: getfield 197	azxr:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   90: invokestatic 459	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:b	(Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)Z
    //   93: ifeq +564 -> 657
    //   96: aload 6
    //   98: astore 7
    //   100: aload 6
    //   102: astore 8
    //   104: aload_0
    //   105: bipush 51
    //   107: invokevirtual 208	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   110: checkcast 210	anyw
    //   113: astore 4
    //   115: aload 4
    //   117: ifnonnull +515 -> 632
    //   120: aconst_null
    //   121: astore 11
    //   123: aload 6
    //   125: astore 9
    //   127: aload 11
    //   129: ifnull +866 -> 995
    //   132: aload 6
    //   134: astore 4
    //   136: aload 6
    //   138: astore 7
    //   140: aload 6
    //   142: astore 8
    //   144: aload 11
    //   146: getfield 225	com/tencent/mobileqq/data/Friends:name	Ljava/lang/String;
    //   149: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   152: ifne +18 -> 170
    //   155: aload 6
    //   157: astore 7
    //   159: aload 6
    //   161: astore 8
    //   163: aload 11
    //   165: getfield 225	com/tencent/mobileqq/data/Friends:name	Ljava/lang/String;
    //   168: astore 4
    //   170: aload 4
    //   172: astore 7
    //   174: aload 4
    //   176: astore 8
    //   178: aload 4
    //   180: astore 9
    //   182: aload 11
    //   184: getfield 230	com/tencent/mobileqq/data/Friends:remark	Ljava/lang/String;
    //   187: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   190: ifne +805 -> 995
    //   193: aload 4
    //   195: astore 7
    //   197: aload 4
    //   199: astore 8
    //   201: aload 11
    //   203: getfield 230	com/tencent/mobileqq/data/Friends:remark	Ljava/lang/String;
    //   206: astore 6
    //   208: aload 4
    //   210: astore_3
    //   211: aload 6
    //   213: astore 4
    //   215: aload_0
    //   216: bipush 52
    //   218: invokevirtual 208	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   221: checkcast 238	com/tencent/mobileqq/app/TroopManager
    //   224: astore 8
    //   226: aload_1
    //   227: getfield 180	azxr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   230: astore 7
    //   232: aload 7
    //   234: astore 6
    //   236: aload 7
    //   238: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   241: ifeq +34 -> 275
    //   244: aload 7
    //   246: astore 6
    //   248: aload_1
    //   249: getfield 197	azxr:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   252: getfield 236	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:d	Ljava/lang/String;
    //   255: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   258: ifne +17 -> 275
    //   261: aload 8
    //   263: aload_1
    //   264: getfield 197	azxr:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   267: getfield 236	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:d	Ljava/lang/String;
    //   270: invokevirtual 461	com/tencent/mobileqq/app/TroopManager:c	(Ljava/lang/String;)Ljava/lang/String;
    //   273: astore 6
    //   275: aload 6
    //   277: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   280: ifne +696 -> 976
    //   283: aload 8
    //   285: ifnull +691 -> 976
    //   288: aload_0
    //   289: aload 6
    //   291: aload_1
    //   292: getfield 197	azxr:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   295: getfield 198	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   298: invokestatic 463	bhlg:j	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   301: astore_0
    //   302: aload 10
    //   304: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   307: ifeq +662 -> 969
    //   310: aload_1
    //   311: getfield 197	azxr:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   314: invokestatic 313	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	(Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)Lcom/tencent/mobileqq/activity/ProfileActivity$CardContactInfo;
    //   317: astore 5
    //   319: aload 5
    //   321: ifnull +648 -> 969
    //   324: aload 5
    //   326: getfield 464	com/tencent/mobileqq/activity/ProfileActivity$CardContactInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   329: astore 5
    //   331: aload 4
    //   333: astore 6
    //   335: aload 5
    //   337: astore 9
    //   339: aload_3
    //   340: astore 4
    //   342: aload 6
    //   344: astore 5
    //   346: aload_0
    //   347: astore 6
    //   349: aload_1
    //   350: getfield 296	azxr:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   353: astore_0
    //   354: aload_0
    //   355: monitorenter
    //   356: aload_1
    //   357: getfield 296	azxr:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   360: iconst_0
    //   361: aaload
    //   362: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   365: ifeq +11 -> 376
    //   368: aload_1
    //   369: getfield 296	azxr:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   372: iconst_0
    //   373: aload 4
    //   375: aastore
    //   376: aload_1
    //   377: getfield 296	azxr:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   380: iconst_4
    //   381: aaload
    //   382: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   385: ifeq +11 -> 396
    //   388: aload_1
    //   389: getfield 296	azxr:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   392: iconst_4
    //   393: aload 5
    //   395: aastore
    //   396: aload_1
    //   397: getfield 296	azxr:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   400: iconst_3
    //   401: aaload
    //   402: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   405: ifeq +11 -> 416
    //   408: aload_1
    //   409: getfield 296	azxr:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   412: iconst_3
    //   413: aload 9
    //   415: aastore
    //   416: aload_1
    //   417: getfield 296	azxr:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   420: iconst_5
    //   421: aaload
    //   422: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   425: ifeq +11 -> 436
    //   428: aload_1
    //   429: getfield 296	azxr:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   432: iconst_5
    //   433: aload 12
    //   435: aastore
    //   436: aload_1
    //   437: getfield 296	azxr:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   440: iconst_1
    //   441: aaload
    //   442: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   445: ifeq +11 -> 456
    //   448: aload_1
    //   449: getfield 296	azxr:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   452: iconst_1
    //   453: aload 6
    //   455: aastore
    //   456: aload_1
    //   457: getfield 296	azxr:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   460: bipush 6
    //   462: aaload
    //   463: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   466: ifeq +12 -> 478
    //   469: aload_1
    //   470: getfield 296	azxr:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   473: bipush 6
    //   475: aload 14
    //   477: aastore
    //   478: aload_1
    //   479: getfield 296	azxr:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   482: iconst_2
    //   483: aaload
    //   484: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   487: ifeq +11 -> 498
    //   490: aload_1
    //   491: getfield 296	azxr:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   494: iconst_2
    //   495: aload 13
    //   497: aastore
    //   498: aload_0
    //   499: monitorexit
    //   500: invokestatic 413	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   503: ifeq +128 -> 631
    //   506: new 315	java/lang/StringBuilder
    //   509: dup
    //   510: invokespecial 316	java/lang/StringBuilder:<init>	()V
    //   513: astore_0
    //   514: aload_0
    //   515: ldc_w 466
    //   518: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: ldc_w 468
    //   524: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: aload 4
    //   529: invokestatic 472	bhjx:b	(Ljava/lang/String;)Ljava/lang/String;
    //   532: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: ldc_w 474
    //   538: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: aload 5
    //   543: invokestatic 472	bhjx:b	(Ljava/lang/String;)Ljava/lang/String;
    //   546: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: ldc_w 476
    //   552: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: aload 9
    //   557: invokestatic 472	bhjx:b	(Ljava/lang/String;)Ljava/lang/String;
    //   560: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: ldc_w 478
    //   566: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: aload 12
    //   571: invokestatic 472	bhjx:b	(Ljava/lang/String;)Ljava/lang/String;
    //   574: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: ldc_w 480
    //   580: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: aload 6
    //   585: invokestatic 472	bhjx:b	(Ljava/lang/String;)Ljava/lang/String;
    //   588: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: ldc_w 482
    //   594: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: aload 13
    //   599: invokestatic 472	bhjx:b	(Ljava/lang/String;)Ljava/lang/String;
    //   602: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: ldc_w 484
    //   608: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: aload 12
    //   613: invokestatic 472	bhjx:b	(Ljava/lang/String;)Ljava/lang/String;
    //   616: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: pop
    //   620: ldc_w 415
    //   623: iconst_2
    //   624: aload_0
    //   625: invokevirtual 327	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   628: invokestatic 486	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   631: return
    //   632: aload 6
    //   634: astore 7
    //   636: aload 6
    //   638: astore 8
    //   640: aload 4
    //   642: aload_1
    //   643: getfield 197	azxr:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   646: getfield 198	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   649: invokevirtual 488	anyw:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   652: astore 11
    //   654: goto -531 -> 123
    //   657: aload 6
    //   659: astore 7
    //   661: aload 6
    //   663: astore 8
    //   665: aload_1
    //   666: getfield 197	azxr:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   669: getfield 403	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   672: ifne +33 -> 705
    //   675: aload 6
    //   677: astore 7
    //   679: aload 6
    //   681: astore 8
    //   683: aload_0
    //   684: aload_1
    //   685: getfield 197	azxr:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   688: getfield 198	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   691: invokestatic 491	bhlg:h	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   694: astore 6
    //   696: aload_3
    //   697: astore 4
    //   699: aload 6
    //   701: astore_3
    //   702: goto -487 -> 215
    //   705: aload 6
    //   707: astore 7
    //   709: aload 6
    //   711: astore 8
    //   713: aload 6
    //   715: astore 4
    //   717: aload 6
    //   719: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   722: ifeq +260 -> 982
    //   725: aload 6
    //   727: astore 7
    //   729: aload 6
    //   731: astore 8
    //   733: aload 6
    //   735: astore 4
    //   737: aload_1
    //   738: getfield 197	azxr:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   741: invokestatic 493	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:g	(Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)Z
    //   744: ifeq +238 -> 982
    //   747: aload 6
    //   749: astore 7
    //   751: aload 6
    //   753: astore 8
    //   755: aload_0
    //   756: aload_1
    //   757: getfield 197	azxr:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   760: getfield 198	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   763: iconst_0
    //   764: invokestatic 496	bhlg:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)Ljava/lang/String;
    //   767: astore 4
    //   769: aload 4
    //   771: astore 7
    //   773: aload 4
    //   775: astore 8
    //   777: aload 4
    //   779: aload_1
    //   780: getfield 197	azxr:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   783: getfield 198	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   786: invokestatic 499	bhjx:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   789: istore_2
    //   790: iload_2
    //   791: ifeq +191 -> 982
    //   794: aconst_null
    //   795: astore 6
    //   797: aload_3
    //   798: astore 4
    //   800: aload 6
    //   802: astore_3
    //   803: goto -588 -> 215
    //   806: astore 8
    //   808: aload 5
    //   810: astore_0
    //   811: aload_0
    //   812: astore 6
    //   814: aload_3
    //   815: astore 5
    //   817: aload 7
    //   819: astore 4
    //   821: aload 10
    //   823: astore 9
    //   825: invokestatic 413	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   828: ifeq -479 -> 349
    //   831: ldc_w 415
    //   834: iconst_2
    //   835: aload 8
    //   837: invokevirtual 500	java/lang/Exception:toString	()Ljava/lang/String;
    //   840: invokestatic 486	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   843: aload_0
    //   844: astore 6
    //   846: aload_3
    //   847: astore 5
    //   849: aload 7
    //   851: astore 4
    //   853: aload 10
    //   855: astore 9
    //   857: goto -508 -> 349
    //   860: astore 7
    //   862: aload 5
    //   864: astore_0
    //   865: aload_0
    //   866: astore 6
    //   868: aload_3
    //   869: astore 5
    //   871: aload 8
    //   873: astore 4
    //   875: aload 10
    //   877: astore 9
    //   879: invokestatic 413	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   882: ifeq -533 -> 349
    //   885: ldc_w 415
    //   888: iconst_2
    //   889: aload 7
    //   891: invokevirtual 501	java/lang/Error:toString	()Ljava/lang/String;
    //   894: invokestatic 486	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   897: aload_0
    //   898: astore 6
    //   900: aload_3
    //   901: astore 5
    //   903: aload 8
    //   905: astore 4
    //   907: aload 10
    //   909: astore 9
    //   911: goto -562 -> 349
    //   914: astore_1
    //   915: aload_0
    //   916: monitorexit
    //   917: aload_1
    //   918: athrow
    //   919: astore 7
    //   921: aload_3
    //   922: astore 8
    //   924: aload 5
    //   926: astore_0
    //   927: aload 4
    //   929: astore_3
    //   930: goto -65 -> 865
    //   933: astore 7
    //   935: aload_3
    //   936: astore 8
    //   938: aload 4
    //   940: astore_3
    //   941: goto -76 -> 865
    //   944: astore 8
    //   946: aload_3
    //   947: astore 7
    //   949: aload 5
    //   951: astore_0
    //   952: aload 4
    //   954: astore_3
    //   955: goto -144 -> 811
    //   958: astore 8
    //   960: aload_3
    //   961: astore 7
    //   963: aload 4
    //   965: astore_3
    //   966: goto -155 -> 811
    //   969: aload 10
    //   971: astore 5
    //   973: goto -642 -> 331
    //   976: aload 5
    //   978: astore_0
    //   979: goto -677 -> 302
    //   982: aload 4
    //   984: astore 6
    //   986: aload_3
    //   987: astore 4
    //   989: aload 6
    //   991: astore_3
    //   992: goto -777 -> 215
    //   995: aload_3
    //   996: astore 4
    //   998: aload 9
    //   1000: astore_3
    //   1001: goto -786 -> 215
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1004	1	paramazxr	azxr
    //   789	2	2	bool	boolean
    //   32	969	3	localObject1	Object
    //   113	884	4	localObject2	Object
    //   40	937	5	localObject3	Object
    //   23	967	6	localObject4	Object
    //   80	770	7	localObject5	Object
    //   860	30	7	localError1	java.lang.Error
    //   919	1	7	localError2	java.lang.Error
    //   933	1	7	localError3	java.lang.Error
    //   947	15	7	localObject6	Object
    //   84	692	8	localObject7	Object
    //   806	98	8	localException1	Exception
    //   922	15	8	localObject8	Object
    //   944	1	8	localException2	Exception
    //   958	1	8	localException3	Exception
    //   125	874	9	localObject9	Object
    //   58	912	10	str1	String
    //   121	532	11	localFriends	Friends
    //   49	563	12	str2	String
    //   76	522	13	str3	String
    //   67	409	14	str4	String
    // Exception table:
    //   from	to	target	type
    //   86	96	806	java/lang/Exception
    //   104	115	806	java/lang/Exception
    //   144	155	806	java/lang/Exception
    //   163	170	806	java/lang/Exception
    //   182	193	806	java/lang/Exception
    //   201	208	806	java/lang/Exception
    //   640	654	806	java/lang/Exception
    //   665	675	806	java/lang/Exception
    //   683	696	806	java/lang/Exception
    //   717	725	806	java/lang/Exception
    //   737	747	806	java/lang/Exception
    //   755	769	806	java/lang/Exception
    //   777	790	806	java/lang/Exception
    //   86	96	860	java/lang/Error
    //   104	115	860	java/lang/Error
    //   144	155	860	java/lang/Error
    //   163	170	860	java/lang/Error
    //   182	193	860	java/lang/Error
    //   201	208	860	java/lang/Error
    //   640	654	860	java/lang/Error
    //   665	675	860	java/lang/Error
    //   683	696	860	java/lang/Error
    //   717	725	860	java/lang/Error
    //   737	747	860	java/lang/Error
    //   755	769	860	java/lang/Error
    //   777	790	860	java/lang/Error
    //   356	376	914	finally
    //   376	396	914	finally
    //   396	416	914	finally
    //   416	436	914	finally
    //   436	456	914	finally
    //   456	478	914	finally
    //   478	498	914	finally
    //   498	500	914	finally
    //   915	917	914	finally
    //   215	232	919	java/lang/Error
    //   236	244	919	java/lang/Error
    //   248	275	919	java/lang/Error
    //   275	283	919	java/lang/Error
    //   288	302	919	java/lang/Error
    //   302	319	933	java/lang/Error
    //   324	331	933	java/lang/Error
    //   215	232	944	java/lang/Exception
    //   236	244	944	java/lang/Exception
    //   248	275	944	java/lang/Exception
    //   275	283	944	java/lang/Exception
    //   288	302	944	java/lang/Exception
    //   302	319	958	java/lang/Exception
    //   324	331	958	java/lang/Exception
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, azxr paramazxr)
  {
    int k = bhhz.a(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    String str3 = a(paramazxr, paramQQAppInterface);
    String str2 = null;
    Object localObject;
    String str1;
    if (ProfileActivity.AllInOne.g(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
    {
      localObject = paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      str2 = null;
      if (k != 1000) {
        break label379;
      }
      str1 = paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d;
    }
    for (;;)
    {
      label58:
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.FrdProfileCard", 2, "free call click");
      }
      bdll.b(paramQQAppInterface, "CliOper", "", "", "Two_call", "Clk_freecall", a(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(a(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      ChatActivityUtils.a(paramQQAppInterface, paramBaseActivity, k, (String)localObject, str3, str2, true, str1, true, true, null, "from_internal");
      switch (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
      {
      default: 
        paramBaseActivity = "4";
      }
      for (;;)
      {
        bdll.b(paramQQAppInterface, "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, paramBaseActivity, "", "", "");
        return;
        str1 = str2;
        int j = k;
        if (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53)
        {
          str1 = str2;
          j = k;
          if (paramazxr.jdField_a_of_type_ComTencentMobileqqDataContactCard != null)
          {
            str1 = str2;
            j = k;
            if (!TextUtils.isEmpty(paramazxr.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin))
            {
              str1 = paramazxr.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin;
              j = 0;
            }
          }
        }
        str2 = a(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        localObject = str1;
        k = j;
        break;
        label379:
        if (k != 1004) {
          break label427;
        }
        str1 = paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString;
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
  
  public static void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, azxr paramazxr, Dialog paramDialog)
  {
    Object localObject = paramBaseActivity.getIntent().getBundleExtra("profile_extres");
    boolean bool;
    int m;
    int n;
    int j;
    int k;
    if (localObject != null)
    {
      bool = ((Bundle)localObject).getBoolean("from_babyq", false);
      m = 3999;
      n = 0;
      j = n;
      k = m;
      switch (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
      {
      default: 
        k = m;
        j = n;
      }
    }
    for (;;)
    {
      if (k == 3045) {
        bdll.b(paramQQAppInterface, "CliOper", "", "", "0X80085C5", "0X80085C5", 0, 0, String.valueOf(j), "", "", "");
      }
      if (k == 3094) {
        bdll.a(paramQQAppInterface, "dc00898", "", paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, "0X80092E2", "0X80092E2", 0, 0, String.valueOf(j), atci.a(), atci.a(paramQQAppInterface), atci.c());
      }
      if ((k != 3007) || (aoat.a(paramQQAppInterface, paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
        break label1571;
      }
      localObject = paramDialog;
      if (paramDialog == null) {
        localObject = aoat.a(paramBaseActivity, paramBaseActivity.getString(2131693942), new aepn(paramQQAppInterface, paramBaseActivity, paramazxr), new aepo());
      }
      if ((localObject != null) && (!((Dialog)localObject).isShowing()) && (!paramBaseActivity.isFinishing())) {
        ((Dialog)localObject).show();
      }
      return;
      bool = false;
      break;
      j = paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_l_of_type_Int;
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
      j = paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_l_of_type_Int;
      k = 3020;
      continue;
      j = 1;
      k = 3017;
      continue;
      j = paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_l_of_type_Int;
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
          if ((paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_l_of_type_Int == 16) || (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_l_of_type_Int == 17))
          {
            j = paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_l_of_type_Int;
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
              if (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 127)
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
                  if (localObject != null) {}
                  for (j = ((Bundle)localObject).getInt("tabID", 0);; j = 0)
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
                  j = paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_l_of_type_Int;
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
                  if (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 118)
                  {
                    j = 3;
                    k = 3022;
                  }
                  else
                  {
                    j = n;
                    k = m;
                    if (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 121)
                    {
                      j = 2;
                      k = 3022;
                      continue;
                      j = 23;
                      k = 3004;
                      continue;
                      j = paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_l_of_type_Int;
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
    if (paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard != null) {}
    for (localObject = bhhz.a(paramQQAppInterface.getApp().getApplicationContext(), paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard.shGender, paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard.age, paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard.strCountry, paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard.strProvince, paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard.strCity);; localObject = "")
    {
      String str;
      if ((paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 32) || (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 31) || (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 51) || (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 50) || (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 34) || (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 36) || (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53) || (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 29))
      {
        ProfileActivity.CardContactInfo localCardContactInfo = a(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        if ((localCardContactInfo == null) || (localCardContactInfo.jdField_c_of_type_JavaLangString == null) || (localCardContactInfo.jdField_c_of_type_JavaLangString.length() <= 0)) {
          break;
        }
        str = localCardContactInfo.b + localCardContactInfo.jdField_c_of_type_JavaLangString;
        paramDialog = localCardContactInfo.jdField_a_of_type_JavaLangString;
        paramQQAppInterface = paramDialog;
        if (TextUtils.isEmpty(localCardContactInfo.jdField_a_of_type_JavaLangString))
        {
          if (TextUtils.isEmpty(paramazxr.jdField_a_of_type_ArrayOfJavaLangString[3])) {
            break label1885;
          }
          paramQQAppInterface = paramazxr.jdField_a_of_type_ArrayOfJavaLangString[3];
        }
        for (;;)
        {
          paramQQAppInterface = AddFriendLogicActivity.a(paramBaseActivity, 2, str, null, k, j, paramQQAppInterface, null, FriendProfileCardActivity.class.getName(), paramBaseActivity.getString(2131690559), null);
          paramQQAppInterface.putExtra("param_return_profilecard_pa", paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int);
          paramQQAppInterface.putExtra("key_param_age_area", (String)localObject);
          ProfileActivity.a(paramBaseActivity, paramQQAppInterface, paramazxr);
          paramBaseActivity.startActivity(paramQQAppInterface);
          return;
          label1885:
          if (!TextUtils.isEmpty(paramazxr.jdField_a_of_type_ArrayOfJavaLangString[0]))
          {
            paramQQAppInterface = paramazxr.jdField_a_of_type_ArrayOfJavaLangString[0];
          }
          else
          {
            paramQQAppInterface = paramDialog;
            if (!TextUtils.isEmpty(paramazxr.jdField_a_of_type_Bhdh.a.jdField_a_of_type_JavaLangString)) {
              paramQQAppInterface = paramazxr.jdField_a_of_type_Bhdh.a.jdField_a_of_type_JavaLangString;
            }
          }
        }
      }
      paramQQAppInterface = null;
      if ((3004 == k) && (!TextUtils.isEmpty(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d)))
      {
        paramDialog = paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d;
        paramQQAppInterface = null;
        if ((paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 71) && (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 72)) {
          break label2148;
        }
        paramQQAppInterface = paramazxr.jdField_a_of_type_ArrayOfJavaLangString[2];
        label2003:
        if (!TextUtils.isEmpty(paramQQAppInterface)) {
          break label2389;
        }
        paramQQAppInterface = paramazxr.jdField_a_of_type_ArrayOfJavaLangString[0];
      }
      label2386:
      label2389:
      for (;;)
      {
        str = paramBaseActivity.getIntent().getStringExtra("param_return_addr");
        if (str != null)
        {
          localObject = AddContactsActivity.class.getName();
          if (!str.equals(QidianProfileCardActivity.class.getName())) {
            break label2386;
          }
          localObject = str;
        }
        for (;;)
        {
          paramQQAppInterface = AddFriendLogicActivity.a(paramBaseActivity, 1, paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramDialog, k, j, paramQQAppInterface, null, (String)localObject, paramBaseActivity.getString(2131690559), null);
          paramQQAppInterface.putExtra("from_babyq", bool);
          ProfileActivity.a(paramBaseActivity, paramQQAppInterface, paramazxr);
          paramBaseActivity.startActivity(paramQQAppInterface);
          return;
          paramDialog = paramQQAppInterface;
          if (3005 != k) {
            break;
          }
          paramDialog = paramQQAppInterface;
          if (TextUtils.isEmpty(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString)) {
            break;
          }
          paramDialog = paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString;
          break;
          label2148:
          if ((paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 77) && (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 82) && (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 81) && (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 83) && (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 84) && (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 101) && (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 103) && (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 102) && (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 107) && (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 110)) {
            break label2003;
          }
          paramQQAppInterface = paramazxr.jdField_a_of_type_ArrayOfJavaLangString[5];
          break label2003;
          paramQQAppInterface = AddFriendLogicActivity.a(paramBaseActivity, 1, paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramDialog, k, j, paramQQAppInterface, null, FriendProfileCardActivity.class.getName(), paramBaseActivity.getString(2131690559), null);
          paramQQAppInterface.putExtra("from_babyq", bool);
          ProfileActivity.a(paramBaseActivity, paramQQAppInterface, paramazxr);
          if (k == 3094)
          {
            paramQQAppInterface.putExtra("entrance", paramBaseActivity.getIntent().getIntExtra("entrance", 2));
            paramQQAppInterface.removeExtra("param_return_addr");
            paramBaseActivity.startActivity(paramQQAppInterface);
            return;
          }
          paramQQAppInterface.putExtra("key_param_age_area", (String)localObject);
          paramBaseActivity.startActivityForResult(paramQQAppInterface, 1000);
          return;
        }
      }
    }
  }
  
  static void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, azxr paramazxr, String paramString, int paramInt)
  {
    if (paramBaseActivity.getIntent() != null) {}
    for (boolean bool = paramBaseActivity.getIntent().getBooleanExtra("key_need_track_back", false);; bool = false)
    {
      Object localObject;
      Intent localIntent;
      if (bool)
      {
        localObject = new Intent(paramBaseActivity, ChatActivity.class);
        localIntent = agej.a((Intent)localObject, null);
        localIntent.putExtra("PREVIOUS_WINDOW", FriendProfileCardActivity.class.getName());
        localIntent.putExtra("PREVIOUS_UIN", paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        if (paramBaseActivity.getIntent().getExtras() != null) {
          localIntent.putExtra("cSpecialFlag", paramBaseActivity.getIntent().getExtras().getInt("cSpecialFlag"));
        }
        localIntent.putExtra("uin", paramString);
        localIntent.putExtra("uintype", paramInt);
        localIntent.putExtra("aio_msg_source", 3);
        if (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_j_of_type_Int != 0) {
          localIntent.putExtra("entrance", paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_j_of_type_Int);
        }
        localObject = a(paramazxr, paramQQAppInterface);
        if (localObject != null) {
          break label487;
        }
        paramString = "";
        label181:
        localIntent.putExtra("uinname", paramString);
        if (TextUtils.isEmpty(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d)) {
          break label493;
        }
        localIntent.putExtra("troop_uin", paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d);
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_JavaLangString)) {
          localIntent.putExtra("troop_code", paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_JavaLangString);
        }
        if (paramInt == 1009) {
          localIntent.putExtra("rich_status_sig", paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b);
        }
        if (paramInt == 1001) {
          localIntent.putExtra("rich_accost_sig", paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b);
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("FriendProfileCardActivity", 4, String.format(Locale.getDefault(), "enterChar uin: %s name: %s sig: %s", new Object[] { bhjx.b(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString), bhjx.b((String)localObject), bhjx.a(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b) }));
        }
        paramQQAppInterface = (anyw)paramQQAppInterface.getManager(51);
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = paramQQAppInterface.a(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          if ((paramQQAppInterface != null) && ((nok.a(paramQQAppInterface.cSpecialFlag)) || (bkgt.b(paramQQAppInterface.cSpecialFlag)))) {
            localIntent.putExtra("chat_subType", 1);
          }
        }
        localIntent.putExtra("hidden_aio_msg_source", 2);
        if ((paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 70) || (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g != 101)) {
          break label525;
        }
        localIntent.putExtra("is_from_manage_stranger", true);
        paramBaseActivity.startActivityForResult(localIntent, 1010);
        return;
        localObject = new Intent(paramBaseActivity, SplashActivity.class);
        break;
        label487:
        paramString = (String)localObject;
        break label181;
        label493:
        if (!TextUtils.isEmpty(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString)) {
          localIntent.putExtra("troop_uin", paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString);
        }
      }
      label525:
      paramBaseActivity.startActivity(localIntent);
      return;
    }
  }
  
  private void a(Card paramCard, int paramInt)
  {
    boolean bool2;
    if ((paramInt == 8) && (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) && (!this.i))
    {
      this.i = true;
      bool2 = ((anyw)this.app.getManager(51)).b(paramCard.uin);
      if ((paramCard.lUserFlag & 0x800) == 0L) {
        break label130;
      }
    }
    label130:
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfileCardActivity", 2, String.format("onCardUpdate isFriend=%s profileFriend=%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) }));
      }
      if (bool1 != bool2) {
        ((FriendListHandler)this.app.a(1)).a(paramCard.uin);
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
    if ((bhjx.b(paramAllInOne.jdField_a_of_type_JavaLangString)) && (bhjx.a(getApplicationContext())))
    {
      overridePendingTransition(0, 0);
      finish();
      return true;
    }
    if ((nmd.b(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_Azxr.jdField_b_of_type_Boolean))
    {
      paramIntent = new Intent(this, QidianProfileCardActivity.class);
      paramIntent.putExtra("AllInOne", this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      super.startActivity(paramIntent);
      super.finish();
      return true;
    }
    return false;
  }
  
  public static boolean a(azxr paramazxr, int paramInt, String paramString)
  {
    if ((paramazxr == null) || (paramazxr.jdField_a_of_type_ArrayOfJavaLangString == null) || (paramInt < 0) || (paramInt >= paramazxr.jdField_a_of_type_ArrayOfJavaLangString.length)) {
      return false;
    }
    paramazxr.jdField_a_of_type_ArrayOfJavaLangString[paramInt] = paramString;
    return true;
  }
  
  private void b(Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("param_switches_changed", false)) && (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataCard != null))
    {
      paramIntent = null;
      if ((this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 56) && (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 57)) {
        break label95;
      }
    }
    for (paramIntent = this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b;; paramIntent = this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b) {
      label95:
      do
      {
        a(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataCard.feedPreviewTime, this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataCard.vSeed, paramIntent, true);
        return;
      } while ((this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 35) && (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 37) && (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 36));
    }
  }
  
  private void b(azxr paramazxr)
  {
    try
    {
      if ((this.jdField_a_of_type_Badv != null) && (this.jdField_a_of_type_Badv.a(paramazxr)))
      {
        Object localObject = this.jdField_a_of_type_Badv.a();
        if (localObject != null)
        {
          localObject = ((bade)localObject).a();
          this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView = ((AbsProfileHeaderView)localObject);
          this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView = ((AbsProfileHeaderView)localObject);
        }
      }
      if (this.jdField_a_of_type_Bads != null) {
        this.jdField_a_of_type_Bads.a(paramazxr);
      }
      if (this.jdField_a_of_type_Badu != null) {
        this.jdField_a_of_type_Badu.a(paramazxr);
      }
      if (this.jdField_a_of_type_Badw != null) {
        this.jdField_a_of_type_Badw.a(paramazxr);
      }
      return;
    }
    catch (Exception paramazxr)
    {
      QLog.e("FriendProfileCardActivity", 1, "notifyComponentDataUpdate fail.", paramazxr);
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, azxr paramazxr)
  {
    bhjs.a(true);
    ProfileActivity.AllInOne localAllInOne = paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
    int j = bhhz.a(localAllInOne);
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
        if ((paramazxr.jdField_a_of_type_ComTencentMobileqqDataContactCard != null) && (!TextUtils.isEmpty(paramazxr.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin)))
        {
          j = 0;
          str = paramazxr.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin;
        }
      }
    }
    for (;;)
    {
      a(paramQQAppInterface, paramBaseActivity, paramazxr, str, j);
      return;
      j = 1006;
      continue;
      str = a(localAllInOne);
      continue;
      if (localAllInOne.jdField_a_of_type_Int == 3) {
        bdll.b(paramQQAppInterface, "CliOper", "", "", "WPA", "OpenAIO_scan", 0, 0, "", "", "", "");
      } else if (localAllInOne.g == 102) {
        bdll.b(paramQQAppInterface, "P_CliOper", "Svip", "", "Vip_maproam", "vip_maproam_RandomConversation", 0, 0, "", "", "", "");
      } else if (localAllInOne.g == 103) {
        bdll.b(paramQQAppInterface, "P_CliOper", "Svip", "", "Vip_maproam", "vip_maproam_superConversation", 0, 0, "", "", "", "");
      }
    }
  }
  
  private boolean b()
  {
    if (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      Object localObject = (TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131373011);
      if (localObject != null)
      {
        ((PerfRelativeLayout)this.jdField_d_of_type_AndroidViewView).removeView((View)localObject);
        localObject = "loginwelcome_" + this.app.c();
        localObject = getApplication().getSharedPreferences((String)localObject, 0).edit();
        ((SharedPreferences.Editor)localObject).putInt("bubble_tips_time", 3);
        ((SharedPreferences.Editor)localObject).commit();
        return true;
      }
    }
    return false;
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
    this.jdField_a_of_type_Akrf = new akrf(this);
    this.jdField_a_of_type_Akrf.a(paramIntent);
    this.jdField_a_of_type_Akrf.a();
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 90)
    {
      anyw localanyw = (anyw)this.app.getManager(51);
      if ((localanyw == null) || (!localanyw.b(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
        break label227;
      }
    }
    label227:
    for (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int = 1;; this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int = 19)
    {
      if ((this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 100) && (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 34) && (!((axfr)this.app.getManager(11)).i())) {
        this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int = 29;
      }
      if ((this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 53) && (TextUtils.equals(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int = 0;
      }
      if ((this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41) && (!TextUtils.isEmpty(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals("0"))) {
        this.jdField_c_of_type_Boolean = false;
      }
      return;
    }
  }
  
  private void o()
  {
    int j;
    if (bhjx.b(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int != 59) {
        break label239;
      }
      j = 1;
    }
    for (;;)
    {
      bdll.b(this.app, "dc00898", "", "", "0X800723B", "0X800723B", j, 0, "", "", "", "");
      label117:
      Object localObject2;
      Object localObject1;
      if (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 118)
      {
        bdll.b(null, "dc00898", "", "", "0X800A11E ", "0X800A11E ", 0, 0, "", "", "", "");
        bdll.b(this.app, "dc00898", "", "", "", "0X800A4BF", 0, 0, "", "", "", "");
        if (bhhz.b())
        {
          localObject2 = Locale.getDefault().getCountry();
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localObject2 = this.app;
          if (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
            break label332;
          }
        }
      }
      label332:
      for (j = 1;; j = 2)
      {
        bdll.b((QQAppInterface)localObject2, "dc00898", "", "", "0X8008CA2", "0X8008CA2", j, 0, "", "", (String)localObject1, "");
        baew.a(this.app, this.jdField_a_of_type_Azxr);
        return;
        label239:
        if (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 1)
        {
          j = 2;
          break;
        }
        if (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int != 8) {
          break label337;
        }
        j = 3;
        break;
        if (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int != 121) {
          break label117;
        }
        bdll.b(this.app, "dc00898", "", "", "0X800A51D", "0X800A51D", 0, 0, "", "", "", "");
        break label117;
      }
      label337:
      j = 0;
    }
  }
  
  private void p()
  {
    bagl localbagl;
    if (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 96)
    {
      localbagl = (bagl)this.jdField_a_of_type_Baei.a(1008);
      if (localbagl == null) {}
    }
    for (boolean bool = localbagl.b();; bool = false)
    {
      if (!bool) {
        a(this.app, this, this.jdField_a_of_type_Azxr, this.jdField_a_of_type_AndroidAppDialog);
      }
      return;
    }
  }
  
  private void q()
  {
    Intent localIntent = agej.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtra("uin", this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("PREVIOUS_WINDOW", FriendProfileCardActivity.class.getName());
    localIntent.putExtra("PREVIOUS_UIN", this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    Object localObject = (anyw)this.app.getManager(51);
    if ((this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isFriend) || ((localObject != null) && (((anyw)localObject).b(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))))
    {
      localIntent.putExtra("uintype", 0);
      String str = bhlg.f(this.app, this.jdField_a_of_type_Azxr.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.nick;
      }
      localIntent.putExtra("uinname", (String)localObject);
      localIntent.putExtra("troop_code", this.jdField_a_of_type_Azxr.jdField_a_of_type_JavaLangString);
      localObject = (TroopManager)this.app.getManager(52);
      if (localObject == null) {
        break label242;
      }
      ((TroopManager)localObject).a(this.jdField_a_of_type_Azxr.jdField_a_of_type_JavaLangString, new aepq(this, localIntent));
    }
    label242:
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
        if (this.jdField_a_of_type_Azxr.jdField_a_of_type_Azxy == null) {
          break label224;
        }
        localFrameLayout.setForeground(null);
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(0);
        azxy.a(this.jdField_a_of_type_AndroidViewView, "background", this.jdField_a_of_type_Azxr.jdField_a_of_type_Azxy, "background");
        if (azxy.a(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId))
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setBackgroundDrawable(null);
          if (ThemeUtil.isInNightMode(this.app))
          {
            if (this.jdField_c_of_type_AndroidViewView != null) {
              this.jdField_c_of_type_AndroidViewView.setVisibility(0);
            }
            if (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_Azxr.jdField_a_of_type_Azxy)) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.profilecard.FrdProfileCard", 2, "update item style");
            }
            this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_Azxr, false, new String[0]);
          }
        }
        else
        {
          azxy.a(this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView, "background", this.jdField_a_of_type_Azxr.jdField_a_of_type_Azxy, "commonMaskBackground");
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
      if (azxy.a(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId))
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
        localException.setForeground(getResources().getDrawable(2130850105));
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
    if (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      Object localObject = "loginwelcome_" + this.app.c();
      localObject = getApplication().getSharedPreferences((String)localObject, 0);
      boolean bool = ((SharedPreferences)localObject).getBoolean("first_device", false);
      int j = ((SharedPreferences)localObject).getInt("bubble_tips_time", 0);
      if ((bool) && (j < 3))
      {
        TextView localTextView = new TextView(this);
        localTextView.setId(2131373011);
        localTextView.setBackgroundResource(2130845090);
        localTextView.setIncludeFontPadding(false);
        localTextView.setClickable(false);
        localTextView.setText(anzj.a(2131703811));
        localTextView.setTextColor(-1);
        localTextView.setTextSize(1, 16.0F);
        int k = agej.a(7.0F, getResources());
        int m = agej.a(7.0F, getResources());
        localTextView.setPadding(k, agej.a(7.0F, getResources()), m, agej.a(13.0F, getResources()));
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(11);
        localLayoutParams.addRule(2, 2131373010);
        localLayoutParams.rightMargin = agej.a(15.0F, getResources());
        localLayoutParams.bottomMargin = agej.a(-1.0F, getResources());
        ((PerfRelativeLayout)this.jdField_d_of_type_AndroidViewView).addView(localTextView, localLayoutParams);
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putInt("bubble_tips_time", j + 1);
        ((SharedPreferences.Editor)localObject).commit();
        bdll.b(this.app, "dc00898", "", "", "0X80081C0", "0X80081C0", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void t()
  {
    this.jdField_a_of_type_Byte = ((byte)bhsi.W(getApplication(), this.app.getCurrentAccountUin()));
    if ((this.jdField_a_of_type_Azxr.jdField_b_of_type_Boolean) && (TroopInfo.isQidianPrivateTroop(this.app, this.jdField_a_of_type_Azxr.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_Byte = 0;
    }
  }
  
  private void u()
  {
    try
    {
      v();
      w();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("FriendProfileCardActivity", 1, "initComponentCenter fail.", localException);
      finish();
    }
  }
  
  private void v()
  {
    if (this.jdField_a_of_type_Baei == null)
    {
      this.jdField_a_of_type_Baei = new ComponentCenter();
      this.jdField_a_of_type_Baei.a(this);
    }
  }
  
  private void w()
  {
    FrameLayout localFrameLayout;
    if (this.jdField_a_of_type_Badv == null)
    {
      localFrameLayout = (FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368648);
      if (localFrameLayout != null)
      {
        this.jdField_a_of_type_Badv = ((badv)baeg.a(102, this.jdField_a_of_type_Baei, this.jdField_a_of_type_Azxr));
        this.jdField_a_of_type_Badv.a(this.jdField_a_of_type_Bjaz, this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView, (ViewGroup)this.jdField_d_of_type_AndroidViewView);
        this.jdField_a_of_type_Badv.a(this.jdField_a_of_type_Badl);
        this.jdField_a_of_type_Badv.a(localFrameLayout);
        this.jdField_a_of_type_Badv.g();
      }
    }
    if ((this.jdField_a_of_type_Badt == null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView != null))
    {
      this.jdField_a_of_type_Badt = ((badt)baeg.a(103, this.jdField_a_of_type_Baei, this.jdField_a_of_type_Azxr));
      this.jdField_a_of_type_Badt.a(this.jdField_a_of_type_Bjaz, this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView);
      this.jdField_a_of_type_Badt.a(this.jdField_a_of_type_Badl);
      this.jdField_a_of_type_Badt.a(this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView);
      this.jdField_a_of_type_Badt.g();
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setContentContainer(this.jdField_a_of_type_Badt);
    }
    if (this.jdField_a_of_type_Bads == null)
    {
      localFrameLayout = (FrameLayout)this.jdField_d_of_type_AndroidViewView.findViewById(2131373009);
      if (localFrameLayout != null)
      {
        this.jdField_a_of_type_Bads = ((bads)baeg.a(104, this.jdField_a_of_type_Baei, this.jdField_a_of_type_Azxr));
        this.jdField_a_of_type_Bads.a(localFrameLayout);
        this.jdField_a_of_type_Bads.g();
      }
    }
    if (this.jdField_a_of_type_Badu == null)
    {
      localFrameLayout = (FrameLayout)this.jdField_d_of_type_AndroidViewView.findViewById(2131373023);
      if (localFrameLayout != null)
      {
        this.jdField_a_of_type_Badu = ((badu)baeg.a(105, this.jdField_a_of_type_Baei, this.jdField_a_of_type_Azxr));
        this.jdField_a_of_type_Badu.a(localFrameLayout);
        this.jdField_a_of_type_Badu.g();
      }
    }
    if (this.jdField_a_of_type_Badw == null)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_d_of_type_AndroidViewView.findViewById(2131373032));
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null)
      {
        this.jdField_a_of_type_Badw = ((badw)baeg.a(106, this.jdField_a_of_type_Baei, this.jdField_a_of_type_Azxr));
        this.jdField_a_of_type_Badw.a(this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView);
        this.jdField_a_of_type_Badw.a(this.jdField_a_of_type_Badl);
        this.jdField_a_of_type_Badw.a(this.jdField_a_of_type_AndroidWidgetFrameLayout);
        this.jdField_a_of_type_Badw.g();
      }
    }
  }
  
  private void x()
  {
    if (this.jdField_a_of_type_Badv != null)
    {
      this.jdField_a_of_type_Badv.h();
      this.jdField_a_of_type_Badv = null;
    }
    if (this.jdField_a_of_type_Badt != null)
    {
      this.jdField_a_of_type_Badt.h();
      this.jdField_a_of_type_Badt = null;
    }
    if (this.jdField_a_of_type_Bads != null)
    {
      this.jdField_a_of_type_Bads.h();
      this.jdField_a_of_type_Bads = null;
    }
    if (this.jdField_a_of_type_Badu != null)
    {
      this.jdField_a_of_type_Badu.h();
      this.jdField_a_of_type_Badu = null;
    }
    if (this.jdField_a_of_type_Badw != null)
    {
      this.jdField_a_of_type_Badw.h();
      this.jdField_a_of_type_Badw = null;
    }
  }
  
  Card a(String paramString1, String paramString2)
  {
    anyw localanyw = (anyw)this.app.getManager(51);
    paramString2 = localanyw.a(paramString2);
    if (paramString2 != null)
    {
      paramString1 = localanyw.c(paramString1);
      paramString1.strContactName = paramString2.strContactName;
      paramString1.strMobile = paramString2.mobileNo;
      paramString1.age = paramString2.bAge;
      paramString1.shAge = ((short)paramString2.bAge);
      paramString1.shGender = ((short)paramString2.bSex);
      paramString1.strProvince = paramString2.strProvince;
      paramString1.strCity = paramString2.strCity;
      paramString1.strCountry = paramString2.strCountry;
      localanyw.a(paramString1);
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
            localObject = ((axfr)this.app.getManager(11)).a();
            if ((localObject == null) || (TextUtils.isEmpty(((RespondQueryQQBindingStat)localObject).nationCode))) {
              break label100;
            }
            localObject = ((RespondQueryQQBindingStat)localObject).nationCode + paramString.trim();
          }
        }
      }
    }
    return localObject;
    label100:
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
      if (this.jdField_a_of_type_Blhq != null)
      {
        localMessage = null;
        if (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33) {
          break label66;
        }
      }
    }
    for (;;)
    {
      if (localMessage != null) {
        this.jdField_a_of_type_Blhq.sendMessage(localMessage);
      }
      return;
      label66:
      if (ProfileActivity.AllInOne.g(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        if (QLog.isColorLevel()) {
          QLog.d("FriendProfileCardActivity", 2, "initCardInfo. SUBTHREAD_MSG_INIT_CARD");
        }
        localMessage = this.jdField_a_of_type_Blhq.obtainMessage();
        localMessage.what = 1;
        localMessage.obj = this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      }
      else
      {
        localMessage = this.jdField_a_of_type_Blhq.obtainMessage();
        localMessage.what = 2;
        localMessage.obj = this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      }
    }
  }
  
  void a(int paramInt)
  {
    Object localObject;
    int k;
    int j;
    if ((this.jdField_a_of_type_Azxr.jdField_b_of_type_Boolean) && (TroopInfo.isQidianPrivateTroop(this.app, this.jdField_a_of_type_Azxr.jdField_a_of_type_JavaLangString)))
    {
      localObject = ((TroopManager)this.app.getManager(52)).c(this.jdField_a_of_type_Azxr.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_Badt != null)
      {
        bahr localbahr = (bahr)this.jdField_a_of_type_Badt.a(1013);
        if (localbahr != null) {
          localbahr.a((TroopInfo)localObject);
        }
      }
      if ((((TroopInfo)localObject).isTroopAdmin(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) || (((TroopInfo)localObject).isTroopOwner(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
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
        localObject = findViewById(2131373010);
        if (j != 0)
        {
          paramInt = 0;
          ((View)localObject).setVisibility(paramInt);
          localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
          if (j == 0) {
            break label1160;
          }
          paramInt = 0;
          ((LinearLayout)localObject).setVisibility(paramInt);
        }
        break;
      case 1: 
        label265:
        label283:
        if (this.jdField_a_of_type_Azxr.jdField_b_of_type_Boolean)
        {
          if (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
            a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 23, 2131694510, 1, 2131691061);
          }
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 81, 2131693005, 1, 2131691008);
          label355:
          localObject = (anyw)this.app.getManager(51);
          if (localObject == null) {
            break label1166;
          }
        }
        break;
      }
      label1160:
      label1166:
      for (boolean bool = ((anyw)localObject).b(this.app.c());; bool = true)
      {
        if ((this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) && (!bool))
        {
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 7, 2131692982, 2, 2131690995);
          break;
          if (bhrn.a(this.app))
          {
            a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 92, 2131694511, 1, 2131694511);
            a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 81, 2131693005, 1, 2131691008);
            break label355;
          }
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 23, 2131694510, 1, 2131691061);
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 81, 2131693005, 1, 2131691008);
          break label355;
        }
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 8, 2131717887, 2, 2131691078);
        break;
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 7, 2131692982, 1, 2131690995);
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 20, this.jdField_a_of_type_Bjaz.a(), 1, this.jdField_a_of_type_Bjaz.a(), 0);
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4), 8, 2131717887, 2, 2131691078);
        break;
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 7, 2131692982, 1, 2131690995);
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4), 8, 2131717887, 2, 2131691078);
        break;
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 20, this.jdField_a_of_type_Bjaz.a(), 1, this.jdField_a_of_type_Bjaz.a(), 0);
        if ((k == 0) && (!bduy.a()))
        {
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 95, 2131697954, 1, 2131697954);
          bdll.b(this.app, "", "", "", "0X800A1C4", "0X800A1C4", 0, 0, "", "", "", "");
        }
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4), 8, 2131717887, 2, 2131691078);
        break;
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 7, 2131692982, 1, 2131690995);
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 20, this.jdField_a_of_type_Bjaz.a(), 1, this.jdField_a_of_type_Bjaz.a(), 0);
        break;
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4), 7, 2131692982, 2, 2131690995);
        break;
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4), 8, 2131717887, 2, 2131691078);
        break;
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 20, this.jdField_a_of_type_Bjaz.a(), 1, this.jdField_a_of_type_Bjaz.a(), 0);
        break;
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 20, this.jdField_a_of_type_Bjaz.a(), 1, this.jdField_a_of_type_Bjaz.a(), 0);
        break;
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 59, 2131693023, 1, 2131693023);
        break;
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 59, 2131693023, 1, 2131693023);
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4), 7, 2131692982, 2, 2131690995);
        break;
        if (ProfileActivity.AllInOne.d(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 7, 2131692982, 1, 2131690995);
        }
        for (;;)
        {
          if ((k == 0) && (!bduy.a())) {
            a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 77, 2131697954, 1, 2131697954);
          }
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4), 8, 2131717887, 2, 2131691078);
          break;
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 20, this.jdField_a_of_type_Bjaz.a(), 1, this.jdField_a_of_type_Bjaz.a(), 0);
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
    anum localanum;
    do
    {
      return;
      localanum = (anum)this.app.a(2);
    } while (localanum == null);
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
        paramArrayOfByte1 = (aqmx)this.app.getManager(112);
        if (paramArrayOfByte1 != null) {}
        for (paramBoolean = paramArrayOfByte1.a(1);; paramBoolean = false)
        {
          long l3 = a(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne, paramBoolean);
          switch (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
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
            localanum.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 65535, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3999, arrayOfByte2, (byte)0);
            return;
          case 0: 
            localanum.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 0, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, this.jdField_a_of_type_Byte);
            return;
          case 60: 
            localanum.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 26, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, this.jdField_a_of_type_Byte);
            return;
          case 1: 
            localanum.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 1, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, this.jdField_a_of_type_Byte);
            return;
          case 78: 
            localanum.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 24, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 3022, arrayOfByte2, (byte)0);
            return;
          case 40: 
            localanum.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 1, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, this.jdField_a_of_type_Byte);
            return;
          case 41: 
            j = 6;
            paramArrayOfByte1 = "";
            if ((TextUtils.isEmpty(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals("0")))
            {
              j = 37;
              paramArrayOfByte1 = this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.o;
            }
            localanum.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, j, paramLong, (byte)0, 0L, 0L, arrayOfByte1, paramArrayOfByte1, l3, 10004, arrayOfByte2, (byte)0);
            return;
          case 42: 
          case 73: 
          case 86: 
            localanum.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 8, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
            return;
          case 36: 
            localanum.a(this.app.getCurrentAccountUin(), "0", 32, paramLong, (byte)0, 0L, 0L, arrayOfByte1, a(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne), l3, 3014, arrayOfByte2, (byte)0);
            return;
          case 30: 
            localanum.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 15, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, this.jdField_a_of_type_Byte);
            return;
          case 29: 
          case 31: 
          case 32: 
          case 34: 
          case 50: 
          case 51: 
          case 53: 
            j = 16;
            if (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 34) {
              j = 17;
            }
            if (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53) {
              j = 50;
            }
            break;
          }
          for (;;)
          {
            paramArrayOfByte1 = a(a(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne));
            localanum.a(this.app.getCurrentAccountUin(), "0", j, paramLong, (byte)0, 0L, 0L, arrayOfByte1, paramArrayOfByte1, l3, 10004, null, (byte)0);
            return;
            ((baoh)this.app.a(79)).a(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            return;
            if (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString == null) {
              break;
            }
            long l2 = 0L;
            try
            {
              l1 = Long.valueOf(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString).longValue();
              int k = 0;
              if (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 45)
              {
                j = 13;
                k = 1;
                paramArrayOfByte1 = this.app.getCurrentAccountUin();
                paramArrayOfByte2 = this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
                if (k != 1) {
                  break label1442;
                }
                b1 = this.jdField_a_of_type_Byte;
                localanum.a(paramArrayOfByte1, paramArrayOfByte2, j, paramLong, (byte)0, l1, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, b1);
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
                  if (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 46)
                  {
                    j = 4;
                  }
                  else
                  {
                    j = 14;
                    continue;
                    label1442:
                    b1 = 0;
                  }
                }
              }
            }
            long l1 = bhhz.a(this.app, this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
            if (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 20)
            {
              j = 2;
              b1 = 1;
              paramArrayOfByte1 = this.app.getCurrentAccountUin();
              paramArrayOfByte2 = this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
              if (b1 != 1) {
                break label1612;
              }
            }
            label1612:
            for (byte b2 = this.jdField_a_of_type_Byte;; b2 = 0)
            {
              localanum.a(paramArrayOfByte1, paramArrayOfByte2, j, paramLong, b1, l1, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, b2);
              return;
              if ((this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 21) || (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 58))
              {
                j = 5;
                b1 = 0;
                break;
              }
              if (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 22) {
                break;
              }
              j = 7;
              b1 = 0;
              break;
            }
            localanum.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 21, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
            return;
            localanum.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 10, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
            return;
            localanum.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 10, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
            return;
            localanum.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 31, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3001, arrayOfByte2, (byte)0);
            return;
            localanum.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 38, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3017, arrayOfByte2, (byte)0);
            return;
            localanum.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 27, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
            return;
            localanum.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 36, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
            return;
            if ((this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_Int == 3004) || (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_Int == 2004)) {
              if (TextUtils.isEmpty(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_JavaLangString)) {}
            }
            label2885:
            label2893:
            for (paramArrayOfByte1 = this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_JavaLangString;; paramArrayOfByte1 = "0")
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
                    if (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 27) {
                      j = 35;
                    }
                    localanum.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, j, paramLong, (byte)0, l1, 0L, arrayOfByte1, "", l3, this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_Int, arrayOfByte2, (byte)0);
                    return;
                    if (TextUtils.isEmpty(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d)) {
                      break label2893;
                    }
                    paramArrayOfByte1 = (TroopInfo)this.app.a().createEntityManager().find(TroopInfo.class, "troopcode=?", new String[] { this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d });
                    if (paramArrayOfByte1 == null) {
                      break label2893;
                    }
                    paramArrayOfByte1 = paramArrayOfByte1.troopuin;
                    break;
                    if ((this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_Int != 3005) && (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_Int != 2005)) {
                      break label2885;
                    }
                    paramArrayOfByte2 = this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_JavaLangString;
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
                localanum.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 25, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
                return;
                localanum.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 24, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
                return;
                localanum.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 12, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
                return;
                localanum.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 12, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3095, arrayOfByte2, (byte)0);
                return;
                localanum.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 12, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3096, arrayOfByte2, (byte)0);
                return;
                localanum.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 28, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, this.jdField_a_of_type_Byte);
                return;
                localanum.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 29, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
                return;
                localanum.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 30, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
                return;
                localanum.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 34, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
                return;
                localanum.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 33, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
                return;
                localanum.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 25, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3045, arrayOfByte2, (byte)0);
                return;
                localanum.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 53, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3094, arrayOfByte2, (byte)0);
                return;
                localanum.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 12, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3004, arrayOfByte2, (byte)0);
                return;
                localanum.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 12, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3004, arrayOfByte2, (byte)0);
                return;
                localanum.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 12, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3080, arrayOfByte2, (byte)0);
                return;
                localanum.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 12, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3076, arrayOfByte2, (byte)0);
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
    int j = 2131167023;
    if (paramView == null) {}
    do
    {
      return;
      azvr localazvr = new azvr(paramInt1, null);
      paramView.setVisibility(0);
      if (paramInt2 == 0)
      {
        paramView = (ImageButton)paramView.findViewById(2131368451);
        paramView.setTag(localazvr);
        paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramView.setImageResource(paramInt3);
        paramView.setContentDescription(paramString2);
        return;
      }
      paramView = (Button)paramView.findViewById(2131380216);
      paramView.setTag(localazvr);
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.setContentDescription(paramString2);
      paramView.setText(paramString1);
      if ((!a(paramInt1)) || (this.jdField_c_of_type_Boolean)) {
        break;
      }
      paramView.setTextColor(getResources().getColor(2131167070));
      paramView.setEnabled(this.jdField_c_of_type_Boolean);
    } while ((7 != paramInt1) || (!QSecFramework.a().a(1001).booleanValue()));
    QSecFramework.a().a(5, 0, 1, new Object[] { Integer.valueOf(1), paramView }, null);
    return;
    if (paramInt2 == 2)
    {
      paramInt2 = 2131167023;
      label201:
      if (!ThemeUtil.isInNightMode(this.app)) {
        break label239;
      }
      paramInt2 = j;
    }
    label239:
    for (;;)
    {
      paramView.setTextColor(getResources().getColor(paramInt2));
      break;
      paramInt2 = 2131167025;
      break label201;
    }
  }
  
  void a(LinearLayout paramLinearLayout)
  {
    paramLinearLayout.removeAllViews();
    this.jdField_e_of_type_AndroidViewView = null;
    int j = getResources().getDimensionPixelSize(2131296674);
    int k = getResources().getDimensionPixelSize(2131296674);
    if ((this.jdField_a_of_type_Azxr != null) && (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33))
    {
      LinearLayout.LayoutParams localLayoutParams;
      if ((this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_e_of_type_AndroidViewView = View.inflate(this, 2131562104, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = k;
        paramLinearLayout.addView(this.jdField_e_of_type_AndroidViewView, localLayoutParams);
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, this.jdField_e_of_type_AndroidViewView).c(30).d(30).a();
        if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
          c();
        }
        this.jdField_e_of_type_AndroidViewView = View.inflate(this, 2131562104, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = j;
        paramLinearLayout.addView(this.jdField_e_of_type_AndroidViewView, localLayoutParams);
        this.jdField_e_of_type_AndroidViewView = View.inflate(this, 2131561414, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = j;
        paramLinearLayout.addView(this.jdField_e_of_type_AndroidViewView, localLayoutParams);
      }
      if (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0)
      {
        this.jdField_e_of_type_AndroidViewView = View.inflate(this, 2131561428, null);
        localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.rightMargin = k;
        paramLinearLayout.addView(this.jdField_e_of_type_AndroidViewView, localLayoutParams);
        this.jdField_e_of_type_AndroidViewView = View.inflate(this, 2131561499, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = k;
        paramLinearLayout.addView(this.jdField_e_of_type_AndroidViewView, localLayoutParams);
        this.jdField_e_of_type_AndroidViewView = View.inflate(this, 2131561499, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = k;
        paramLinearLayout.addView(this.jdField_e_of_type_AndroidViewView, localLayoutParams);
        this.jdField_e_of_type_AndroidViewView = View.inflate(this, 2131561499, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = k;
        paramLinearLayout.addView(this.jdField_e_of_type_AndroidViewView, localLayoutParams);
        this.jdField_e_of_type_AndroidViewView = View.inflate(this, 2131561414, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = k;
        paramLinearLayout.addView(this.jdField_e_of_type_AndroidViewView, localLayoutParams);
      }
    }
  }
  
  public void a(blih paramblih)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramblih);
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
        this.app.a().b(paramCardContactInfo);
        bdll.b(this.app, "CliOper", "", "", "P_prof", "call", a(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(a(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        return;
        paramCardContactInfo = null;
      }
      catch (Exception localException)
      {
        QLog.e("FriendProfileCardActivity", 1, "callContact fail.", localException);
        continue;
      }
      label149:
      a(2131693009, 1);
    }
  }
  
  public void a(Card paramCard, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "onSwitchedToFriend, uin: " + paramString + ", card = " + paramCard);
    }
    if (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33) {
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    }
    this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString = paramString;
    b(true);
    long l = 0L;
    if (paramCard != null)
    {
      l = paramCard.feedPreviewTime;
      paramString = paramCard.vSeed;
      this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataCard = paramCard;
      a(paramCard, false);
      paramCard = paramString;
      if ((this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 56) && (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 57)) {
        break label184;
      }
    }
    label184:
    for (paramString = this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b;; paramString = null)
    {
      a(l, paramCard, paramString, true);
      return;
      e();
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
    this.jdField_a_of_type_Bhsx.a("initUpdateInfoStart", true);
    this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataCard = paramCard;
    this.jdField_a_of_type_Azxr.jdField_d_of_type_Boolean = paramBoolean;
    b(this.jdField_a_of_type_Azxr);
    r();
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_Azxr, paramBoolean, new String[0]);
    a(paramBoolean);
    int j;
    if ((this.jdField_a_of_type_Abia != null) && (this.jdField_a_of_type_Abia.isShowing()) && (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataCard != null))
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataCard.strReMark)) {
        this.jdField_a_of_type_Abia.a(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataCard.strReMark + getResources().getString(2131697855));
      }
    }
    else
    {
      if (paramCard != null) {
        this.jdField_a_of_type_Azxr.jdField_b_of_type_Int = paramCard.extendFriendEntryAddFriend;
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
      if (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break label348;
      }
      bdll.b(null, "dc00898", "", "", "qq_vip", "0X800A777", j, 0, "", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_Bhsx.a("initUpdateInfoEnd", "initUpdateInfoStart", false);
      return;
      if (TextUtils.isEmpty(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataCard.strNick)) {
        break;
      }
      this.jdField_a_of_type_Abia.a(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataCard.strNick + getResources().getString(2131697855));
      break;
      label340:
      j = paramCard.mQQLevelType;
      break label217;
      label348:
      bdll.b(null, "dc00898", "", "", "qq_vip", "0X800A776", j, 0, "", "", "", "");
    }
  }
  
  public void a(Card paramCard, boolean paramBoolean, int paramInt)
  {
    if (paramCard != null) {}
    try
    {
      if (!QLog.isColorLevel()) {
        break label470;
      }
      QLog.d("FriendProfileCardActivity", 2, String.format("onCardUpdate isNetCard=%s msgType=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    }
    finally {}
    if (paramCard.lCurrentBgId >= 0L)
    {
      bdll.b(this.app, "CliOper", "", "", "card_mall", "Prof_in_client", a(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(a(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), Long.toString(paramCard.lCurrentBgId), "", "");
      VasWebviewUtil.reportCommercialDrainage(this.app.c(), "card_mall", "prof_in_client", "", 1, 0, 0, "", Integer.toString(a(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), paramCard.lCurrentBgId + "", paramCard.lCurrentStyleId + "", "", "", "", 0, 0, 0, 0);
    }
    label214:
    a(paramCard, paramBoolean);
    a(this.jdField_a_of_type_Azxr);
    if ((paramCard.tempChatSig != null) && (paramCard.tempChatSig.length > 0)) {
      this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b = paramCard.tempChatSig;
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
    if (this.jdField_b_of_type_Blhq != null) {
      this.jdField_b_of_type_Blhq.removeMessages(10);
    }
    for (;;)
    {
      label384:
      Message localMessage = this.jdField_b_of_type_Blhq.obtainMessage(5, j, paramInt, paramCard);
      if ((bool1) && (bool2))
      {
        localMessage.arg2 = 12;
        label415:
        localMessage.sendToTarget();
        if (bool3) {
          this.jdField_b_of_type_Blhq.obtainMessage(5, j, 17, paramCard).sendToTarget();
        }
        return;
      }
      label470:
      do
      {
        j = 0;
        break label384;
        if (!bool1) {
          break label415;
        }
        localMessage.arg2 = 11;
        break label415;
        if (paramInt == 1) {
          break;
        }
        if (paramInt != 8) {
          break label214;
        }
        break;
      } while (!paramBoolean);
      int j = 1;
    }
  }
  
  public void a(ContactCard paramContactCard, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, String.format("updateContactCardInfo card=%s isNetRet=%s", new Object[] { paramContactCard, Boolean.valueOf(paramBoolean) }));
    }
    this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataContactCard = paramContactCard;
    this.jdField_a_of_type_Azxr.jdField_d_of_type_Boolean = paramBoolean;
    b(this.jdField_a_of_type_Azxr);
    if (a(paramContactCard, paramBoolean)) {
      a(this.jdField_a_of_type_Azxr);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_Azxr, paramBoolean, new String[0]);
    a(paramBoolean);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_JavaLangString = paramString;
    a(this.jdField_a_of_type_Azxr, 4, paramString);
    if (this.jdField_a_of_type_Azxr.jdField_a_of_type_Bhdh == null) {
      this.jdField_a_of_type_Azxr.jdField_a_of_type_Bhdh = new bhdh();
    }
    paramString = (bhdh)this.jdField_a_of_type_Azxr.jdField_a_of_type_Bhdh.clone();
    a(this.jdField_a_of_type_Azxr);
    switch (paramString.a(this.jdField_a_of_type_Azxr.jdField_a_of_type_Bhdh))
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_Azxr, true, new String[] { "map_key_qzone", "map_key_account_base_info" });
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.c(this.jdField_a_of_type_Azxr);
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView != null) {
          this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.c(this.jdField_a_of_type_Azxr);
        }
      }
    }
  }
  
  void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "update buttons");
    }
    if (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
      a(1);
    }
    label288:
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 80)
      {
        a(9);
        return;
      }
      if (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 53) {
        break;
      }
      if (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataContactCard.bindQQ) {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin)) {
          if (TextUtils.equals(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin, this.app.getCurrentAccountUin()))
          {
            a(0);
            this.jdField_b_of_type_Int = 0;
          }
        }
      }
      for (;;)
      {
        if ((!paramBoolean) || (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int != 105)) {
          break label288;
        }
        bdll.b(this.app, "CliOper", "", "", "0X800716B", "0X800716B", this.jdField_b_of_type_Int, 0, "", "", "", "");
        return;
        a(4);
        break;
        if (((axfr)this.app.getManager(11)).c(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataContactCard.mobileNo) != null)
        {
          this.jdField_b_of_type_Int = 1;
          if (this.jdField_a_of_type_Azxr.jdField_b_of_type_Boolean) {}
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
    boolean bool4 = ProfileActivity.AllInOne.d(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    boolean bool1 = ProfileActivity.AllInOne.e(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    paramBoolean = ProfileActivity.AllInOne.c(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    if (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 113)
    {
      paramBoolean = false;
      bool1 = false;
    }
    boolean bool2 = bool1;
    boolean bool3 = bool4;
    if (bhjx.b(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
    {
      if (!this.h) {
        break label570;
      }
      paramBoolean = false;
      bool2 = false;
    }
    for (bool3 = false;; bool3 = bool4)
    {
      bool1 = bool2;
      if (ProfileActivity.AllInOne.k(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_ArrayOfByte != null)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_ArrayOfByte.length > 0) {
            bool1 = true;
          }
        }
      }
      if (!ProfileActivity.AllInOne.b(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        paramBoolean = false;
      }
      if ((bool1) && (this.jdField_a_of_type_Azxr.jdField_b_of_type_Boolean))
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
      label570:
      paramBoolean = false;
      bool2 = bool1;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    int k = 1;
    if ((this.app == null) || (this.jdField_b_of_type_Blhq == null) || (this.jdField_a_of_type_Azxr == null) || (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null)) {}
    label316:
    label335:
    label360:
    label361:
    for (;;)
    {
      return;
      if ((!ProfileActivity.AllInOne.b(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) && (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) && (!TextUtils.equals(paramString, this.app.getCurrentAccountUin())) && (!TextUtils.equals(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.app.getCurrentAccountUin())))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, String.format("checkAndSwitch2Friend phone: %s, check:%s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), bhjx.b(paramString) }));
        }
        Message localMessage;
        if (paramBoolean1)
        {
          localObject = a(paramString, a(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne));
          localMessage = Message.obtain();
          localMessage.what = 3;
          if (localObject == null) {}
          for (;;)
          {
            localMessage.obj = paramString;
            this.jdField_b_of_type_Blhq.sendMessage(localMessage);
            return;
            paramString = (String)localObject;
          }
        }
        Object localObject = (anyw)this.app.getManager(51);
        int j;
        if (!paramBoolean2)
        {
          j = 1;
          if (j != 0) {
            break label360;
          }
          if (localObject != null) {
            break label316;
          }
          paramString = null;
          label235:
          if ((paramString == null) || (!paramString.isFriend())) {
            break label335;
          }
          j = k;
        }
        for (;;)
        {
          label250:
          if (j == 0) {
            break label361;
          }
          if (localObject == null) {}
          for (paramString = null;; paramString = ((anyw)localObject).b(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
          {
            localMessage = Message.obtain();
            localMessage.what = 3;
            localObject = paramString;
            if (paramString == null) {
              localObject = this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
            }
            localMessage.obj = localObject;
            this.jdField_b_of_type_Blhq.sendMessage(localMessage);
            return;
            j = 0;
            break;
            paramString = ((anyw)localObject).e(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            break label235;
            j = 0;
            break label250;
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
    blir localblir = (blir)blji.a(this, null);
    paramInt = 0;
    if (paramInt < paramArrayOfInt.length)
    {
      if (paramArrayOfInt[paramInt] == 16) {
        localblir.d(this.jdField_a_of_type_ArrayOfJavaLangString[paramArrayOfInt[paramInt]]);
      }
      for (;;)
      {
        paramInt += 1;
        break;
        if ((paramArrayOfInt[paramInt] >= 0) && (paramArrayOfInt[paramInt] < this.jdField_a_of_type_ArrayOfJavaLangString.length)) {
          localblir.a(this.jdField_a_of_type_ArrayOfJavaLangString[paramArrayOfInt[paramInt]], 1);
        }
      }
    }
    localblir.a(new aeqa(this, localblir));
    try
    {
      if (!isFinishing()) {
        localblir.show();
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
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView != null) {
      return this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.a(paramView, paramMotionEvent);
    }
    return false;
  }
  
  boolean a(azxr paramazxr)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "checkParamValidate() cardInfo.allinone = " + paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    }
    if (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) {}
    while (TextUtils.isEmpty(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    if (ProfileActivity.AllInOne.g(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {}
    try
    {
      bapc.b(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      if ((paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 56) || (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 55)) {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, "rich statuc profile, ricthStatus id = " + paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_k_of_type_Int + ", entry = " + paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int);
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder(300);
          localStringBuilder.append("checkParamValidate, [pa: ").append(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int).append(", uin: ").append(bhjx.b(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
          if (ProfileActivity.e(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)) {
            localStringBuilder.append(", allinone_discussUin: ").append(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString);
          }
          if (ProfileActivity.f(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)) {
            localStringBuilder.append(", allinone_troopUin: ").append(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d).append(",  allinone_troopcode: ").append(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_JavaLangString).append(", sub_source_id: ").append(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_l_of_type_Int).append(", troopUin: ").append(paramazxr.jdField_a_of_type_JavaLangString);
          }
          Bundle localBundle = getIntent().getBundleExtra("flc_extra_param");
          if (localBundle != null)
          {
            localStringBuilder.append(", extra_param_troop_code: ").append(localBundle.getString("troop_code"));
            localStringBuilder.append(", extra_param_troop_uin: ").append(localBundle.getString("troop_uin"));
            localStringBuilder.append(", extra_param_notify_type: ").append(localBundle.getInt("flc_notify_type"));
            localStringBuilder.append(", extra_param_recommend_uin: ").append(localBundle.getString("flc_recommend_uin"));
          }
          localStringBuilder.append(", reportExtraParam: ").append(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_AndroidOsBundle);
          localStringBuilder.append("]");
          QLog.i("addFriendTag", 2, localStringBuilder.toString());
        }
        return a();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.profilecard.FrdProfileCard", 2, "通讯录陌生人： cardInfo.allinone.uin = " + paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        break;
        paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_k_of_type_Int = 0;
      }
      return false;
    }
    catch (NumberFormatException paramazxr) {}
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
      if (!bhjx.a(this.jdField_a_of_type_Azxr.jdField_a_of_type_ArrayOfJavaLangString[0], paramCard.strNick))
      {
        bool2 = true;
        this.jdField_a_of_type_Azxr.jdField_a_of_type_ArrayOfJavaLangString[0] = paramCard.strNick;
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
        if ((!bool2) && (bhjx.a(this.jdField_a_of_type_Azxr.jdField_a_of_type_ArrayOfJavaLangString[4], paramCard.strReMark))) {
          break label496;
        }
        bool1 = true;
        label114:
        this.jdField_a_of_type_Azxr.jdField_a_of_type_ArrayOfJavaLangString[4] = paramCard.strReMark;
      }
      if (!paramBoolean)
      {
        paramBoolean = bool1;
        if (TextUtils.isEmpty(paramCard.strAutoRemark)) {}
      }
      else
      {
        if ((!bool1) && (bhjx.a(this.jdField_a_of_type_Azxr.jdField_a_of_type_ArrayOfJavaLangString[6], paramCard.strAutoRemark))) {
          break label501;
        }
        paramBoolean = true;
        label169:
        this.jdField_a_of_type_Azxr.jdField_a_of_type_ArrayOfJavaLangString[6] = paramCard.strAutoRemark;
      }
      boolean bool1 = paramBoolean;
      if (!TextUtils.isEmpty(paramCard.strContactName))
      {
        if ((paramBoolean) || (!bhjx.a(this.jdField_a_of_type_Azxr.jdField_a_of_type_ArrayOfJavaLangString[3], paramCard.strContactName)))
        {
          bool1 = true;
          label220:
          this.jdField_a_of_type_Azxr.jdField_a_of_type_ArrayOfJavaLangString[3] = paramCard.strContactName;
        }
      }
      else
      {
        paramBoolean = bool1;
        if (!TextUtils.isEmpty(paramCard.strAutoRemark)) {
          if ((!bool1) && (bhjx.a(this.jdField_a_of_type_Azxr.jdField_a_of_type_ArrayOfJavaLangString[2], paramCard.strAutoRemark))) {
            break label511;
          }
        }
      }
      label496:
      label501:
      label511:
      for (paramBoolean = true;; paramBoolean = false)
      {
        this.jdField_a_of_type_Azxr.jdField_a_of_type_ArrayOfJavaLangString[2] = paramCard.strAutoRemark;
        if (QLog.isColorLevel())
        {
          paramCard = new StringBuilder();
          paramCard.append("updateNameList()").append(", bRet = ").append(paramBoolean).append(", strNick = ");
          paramCard.append(bhjx.b(this.jdField_a_of_type_Azxr.jdField_a_of_type_ArrayOfJavaLangString[0])).append(", strRemark = ");
          paramCard.append(bhjx.b(this.jdField_a_of_type_Azxr.jdField_a_of_type_ArrayOfJavaLangString[4])).append(", strContactName = ");
          paramCard.append(bhjx.b(this.jdField_a_of_type_Azxr.jdField_a_of_type_ArrayOfJavaLangString[3])).append(", strCircleName = ");
          paramCard.append(bhjx.b(this.jdField_a_of_type_Azxr.jdField_a_of_type_ArrayOfJavaLangString[2])).append(", strRecommenName = ");
          paramCard.append(bhjx.b(this.jdField_a_of_type_Azxr.jdField_a_of_type_ArrayOfJavaLangString[5])).append(", strTroopNickName = ");
          paramCard.append(bhjx.b(this.jdField_a_of_type_Azxr.jdField_a_of_type_ArrayOfJavaLangString[1])).append(", strAutoRemark = ");
          paramCard.append(bhjx.b(this.jdField_a_of_type_Azxr.jdField_a_of_type_ArrayOfJavaLangString[6]));
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
      if (!bhjx.a(this.jdField_a_of_type_Azxr.jdField_a_of_type_ArrayOfJavaLangString[0], paramContactCard.nickName))
      {
        paramBoolean = true;
        this.jdField_a_of_type_Azxr.jdField_a_of_type_ArrayOfJavaLangString[0] = paramContactCard.nickName;
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramContactCard.strContactName))
      {
        if (!paramBoolean)
        {
          paramBoolean = bool2;
          if (bhjx.a(this.jdField_a_of_type_Azxr.jdField_a_of_type_ArrayOfJavaLangString[3], paramContactCard.strContactName)) {}
        }
        else
        {
          paramBoolean = true;
        }
        this.jdField_a_of_type_Azxr.jdField_a_of_type_ArrayOfJavaLangString[3] = paramContactCard.strContactName;
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53) {
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
  
  public void b(blih paramblih)
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.remove(paramblih);
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
      bdll.b(this.app, "CliOper", "", "", "P_prof", "send_sms", a(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(a(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      return;
      paramCardContactInfo = null;
      break;
      label133:
      a(2131693009, 1);
    }
  }
  
  void b(String paramString)
  {
    if (isFinishing()) {
      return;
    }
    if ((this.jdField_a_of_type_Abia != null) && (!this.jdField_a_of_type_Abia.isShowing()))
    {
      this.jdField_a_of_type_Abia.show();
      return;
    }
    this.jdField_a_of_type_Abia = new abia(this);
    this.jdField_a_of_type_Abia.a(getResources().getString(2131697855));
    String str2 = getString(2131717997);
    String str1 = str2;
    if (paramString != null) {
      str1 = str2 + paramString;
    }
    paramString = new aepu(this, this);
    this.jdField_a_of_type_Abia.a(str1, paramString);
    this.jdField_a_of_type_Abia.a(paramString);
    this.jdField_a_of_type_Abia.show();
  }
  
  void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "initCardContactInfoList");
    }
    Object localObject3;
    if ((ProfileActivity.AllInOne.b(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33) || (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 32) || (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 31) || (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 34) || (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 51) || (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 50) || (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 36) || (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 29) || (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53))
    {
      if (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.size() == 0)
      {
        localObject3 = (axfr)this.app.getManager(11);
        if (localObject3 != null) {
          break label230;
        }
      }
    }
    label230:
    label491:
    do
    {
      return;
      Object localObject1;
      Object localObject2;
      if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        localObject1 = ((axfr)localObject3).a(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        localObject2 = localObject1;
        if (paramBoolean) {
          break label491;
        }
        localObject2 = (FriendListHandler)this.app.a(1);
        if ((!((FriendListHandler)localObject2).b()) && (!((FriendListHandler)localObject2).c())) {
          ((FriendListHandler)localObject2).c(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, false);
        }
      }
      while (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53)
      {
        this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.add(new ProfileActivity.CardContactInfo(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_k_of_type_JavaLangString, this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, ""));
        return;
        localObject2 = ((axfr)localObject3).c(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = ((axfr)localObject3).b(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(((PhoneContact)localObject2).mobileCode))
            {
              this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject2).mobileCode;
              localObject1 = localObject2;
            }
          }
        }
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          localObject3 = (FriendListHandler)this.app.a(1);
          localObject2 = localObject1;
          if (!((FriendListHandler)localObject3).c())
          {
            ((FriendListHandler)localObject3).c(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, true);
            localObject2 = localObject1;
          }
        }
        localObject1 = localObject2;
      }
      if (localObject1 != null)
      {
        this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.add(new ProfileActivity.CardContactInfo(((PhoneContact)localObject1).name, ((PhoneContact)localObject1).mobileCode, ((PhoneContact)localObject1).nationCode));
        return;
      }
    } while ((this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33) && (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 32) && (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 31) && (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 34) && (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 51) && (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 50) && (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 36) && (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 29));
    this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.add(new ProfileActivity.CardContactInfo("", this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, ""));
  }
  
  void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null) {
      return;
    }
    bbav localbbav = (bbav)this.app.getManager(36);
    this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = localbbav.a(String.format("%d%s%d", new Object[] { Integer.valueOf(100100), ".", Integer.valueOf(100120) }));
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
    localbbav.a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
  }
  
  public void c(ProfileActivity.CardContactInfo paramCardContactInfo)
  {
    if (paramCardContactInfo == null)
    {
      paramCardContactInfo = null;
      if ((paramCardContactInfo != null) && (paramCardContactInfo.length() > 0))
      {
        if (!bhnv.d(BaseApplication.getContext())) {
          break label189;
        }
        if (("".equals(paramCardContactInfo)) || (paramCardContactInfo.equals(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_JavaLangString))) {
          break label178;
        }
        FriendListHandler localFriendListHandler = (FriendListHandler)this.app.a(1);
        if (localFriendListHandler == null) {
          break label167;
        }
        localFriendListHandler.a(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramCardContactInfo, false);
        this.jdField_a_of_type_Int |= 0x1;
        a(paramCardContactInfo);
      }
    }
    for (;;)
    {
      bdll.b(this.app, "CliOper", "", "", "P_prof", "Edit_name", a(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(a(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      return;
      paramCardContactInfo = paramCardContactInfo.jdField_a_of_type_JavaLangString;
      break;
      label167:
      a(2131693035, 1);
      continue;
      label178:
      a(2131693021, 1);
      continue;
      label189:
      a(2131694005, 1);
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo != null) && (this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.iNewFlag.get() != 0))
    {
      bbav localbbav = (bbav)this.app.getManager(36);
      if (localbbav != null) {
        localbbav.b(String.format("%d%s%d", new Object[] { Integer.valueOf(100100), ".", Integer.valueOf(100120) }));
      }
      this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = null;
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, String.format("doOnActivityResult requestCode=%s resultCode=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_Baei != null) {
      this.jdField_a_of_type_Baei.a(paramInt1, paramInt2, paramIntent);
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
            } while ((this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g != 101) || (paramInt2 != -1));
            finish();
            return;
            if (paramInt1 != 1035) {
              break;
            }
          } while (this.jdField_a_of_type_Akrf == null);
          this.jdField_a_of_type_Akrf.a(paramInt2, paramIntent);
          return;
        } while (paramInt2 != -1);
        switch (paramInt1)
        {
        default: 
          return;
        case 5: 
          paramIntent = bhmq.b(this, this.jdField_a_of_type_AndroidNetUri);
          paramInt1 = bhhz.b(this);
          localObject = new Intent();
          ((Intent)localObject).putExtra("Business_Origin", 100);
          PhotoUtils.a((Intent)localObject, this, FriendProfileCardActivity.class.getName(), paramInt1, paramInt1, 1080, 1080, paramIntent, bhhz.a());
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
        if (!bhjx.a(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_JavaLangString, localObject)) {
          a((String)localObject);
        }
      }
      setResult(-1);
      finish();
      return;
      paramIntent = ((anyw)this.app.getManager(51)).b(this.app.getCurrentAccountUin());
    } while ((paramIntent == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView == null));
    this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataCard = paramIntent;
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_Azxr, true, new String[] { "map_key_tag" });
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
    this.jdField_a_of_type_Bhsx = new bhsx("FriendProfileCardActivity");
    Intent localIntent = getIntent();
    if ((this.app == null) || (TextUtils.isEmpty(this.app.getAccount())) || (localIntent == null))
    {
      QLog.e("FriendProfileCardActivity", 1, "doOnCreate invalid params 1.");
      finish();
      return false;
    }
    ProfileActivity.AllInOne localAllInOne = a(localIntent);
    this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = localAllInOne;
    this.jdField_a_of_type_Azxr.jdField_a_of_type_AndroidViewView$OnClickListener = this.jdField_a_of_type_AndroidViewView$OnClickListener;
    this.jdField_a_of_type_Bjaz = new bjaz(this.app, this.jdField_a_of_type_Bjba);
    this.jdField_a_of_type_Azxr.jdField_a_of_type_Bjaz = this.jdField_a_of_type_Bjaz;
    this.h = localIntent.getBooleanExtra("key_from_ark_babyq", false);
    this.jdField_e_of_type_Boolean = localIntent.getBooleanExtra("key_from_extends_friend", false);
    this.f = localIntent.getBooleanExtra("key_from_extends_friend_limit_chat", false);
    if (!a(this.jdField_a_of_type_Azxr))
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
    this.jdField_a_of_type_Blhq = new blhq(ThreadManager.getSubThreadLooper(), this.jdField_b_of_type_AndroidOsHandler$Callback);
    this.jdField_b_of_type_Blhq = new blhq(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    n();
    m();
    t();
    b();
    addObserver(this.jdField_a_of_type_Anuw);
    addObserver(this.jdField_a_of_type_Anyu);
    this.app.registObserver(this.jdField_a_of_type_Azov);
    ((VasQuickUpdateManager)this.app.getManager(184)).addCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
    try
    {
      b(false);
      if (bhwl.a == null) {
        ThreadManager.excute(new FriendProfileCardActivity.2(this), 16, null, true);
      }
      this.jdField_a_of_type_Azxr.jdField_a_of_type_ArrayOfJavaLangString = new String[7];
      ThreadManager.excute(new FriendProfileCardActivity.3(this), 16, null, true);
      e();
      if (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33) {
        a();
      }
      for (;;)
      {
        g();
        o();
        c(getIntent());
        u();
        if (this.jdField_a_of_type_Baei != null) {
          this.jdField_a_of_type_Baei.a(this, paramBundle);
        }
        return true;
        a(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataCard, false);
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
    if (this.jdField_b_of_type_Blhq != null)
    {
      this.jdField_b_of_type_Blhq.removeCallbacksAndMessages(null);
      this.jdField_b_of_type_Blhq.removeMessages(0);
    }
    if (this.jdField_a_of_type_Blhq != null)
    {
      this.jdField_a_of_type_Blhq.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Blhq.removeMessages(0);
      this.jdField_a_of_type_Blhq = null;
    }
    super.doOnDestroy();
    if (this.app != null) {
      this.app.removeHandler(getClass());
    }
    if (this.jdField_a_of_type_Bjaz != null) {
      this.jdField_a_of_type_Bjaz.a();
    }
    try
    {
      if (this.jdField_a_of_type_Boolean)
      {
        unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.jdField_a_of_type_Boolean = false;
      }
      removeObserver(this.jdField_a_of_type_Anyu);
      removeObserver(this.jdField_a_of_type_Anuw);
      if (this.app != null) {
        this.app.unRegistObserver(this.jdField_a_of_type_Azov);
      }
      if (this.app != null)
      {
        VasQuickUpdateManager localVasQuickUpdateManager = (VasQuickUpdateManager)this.app.getManager(184);
        if (localVasQuickUpdateManager != null) {
          localVasQuickUpdateManager.removeCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
        }
      }
      if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()))
      {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
        this.jdField_a_of_type_AndroidAppDialog = null;
      }
      if (this.jdField_a_of_type_Abia != null)
      {
        this.jdField_a_of_type_Abia.dismiss();
        this.jdField_a_of_type_Abia = null;
      }
      if ((this.jdField_a_of_type_Azxr != null) && (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (azxy.a(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataCard))) {
        QLog.i("FriendProfileCardActivity", 1, "FriendProfileCardActivity.onDestroy()");
      }
      if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() == 0) {
        bhhz.b();
      }
      if (this.jdField_a_of_type_Akrf != null) {
        this.jdField_a_of_type_Akrf.f();
      }
      if (this.jdField_a_of_type_Baei != null) {
        this.jdField_a_of_type_Baei.f();
      }
      x();
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
    if (this.jdField_a_of_type_Baei != null) {
      this.jdField_a_of_type_Baei.a(paramIntent);
    }
    if (paramIntent.getBooleanExtra("key_back_from_add_friend", false)) {
      doOnActivityResult(1000, -1, paramIntent);
    }
    if (paramIntent != null)
    {
      ProfileActivity.AllInOne localAllInOne = (ProfileActivity.AllInOne)paramIntent.getParcelableExtra("AllInOne");
      if ((localAllInOne != null) && (localAllInOne.jdField_h_of_type_Int == 115))
      {
        this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = localAllInOne;
        a(0L, null, null, false);
      }
    }
    if (this.jdField_a_of_type_Akrf == null)
    {
      c(paramIntent);
      return;
    }
    this.jdField_a_of_type_Akrf.b(paramIntent);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_Baei != null) {
      this.jdField_a_of_type_Baei.d();
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
    if (this.jdField_a_of_type_Baei != null) {
      this.jdField_a_of_type_Baei.c();
    }
    AbstractVideoImage.resumeAll();
    ApngImage.playByTag(9);
    c();
    k();
    if ((this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 115) && (AddFriendLogicActivity.jdField_b_of_type_Boolean)) {
      b(getIntent().getStringExtra("src_name"));
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if (this.jdField_a_of_type_Baei != null) {
      this.jdField_a_of_type_Baei.b();
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    if (this.jdField_a_of_type_Baei != null) {
      this.jdField_a_of_type_Baei.e();
    }
    if ((this.jdField_a_of_type_Abia != null) && (this.jdField_a_of_type_Abia.isShowing()))
    {
      this.jdField_a_of_type_Abia.dismiss();
      this.jdField_a_of_type_Abia = null;
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      this.jdField_a_of_type_Bhsx.a("doOnWindowFocusChanged", false);
      if (this.jdField_a_of_type_Badu != null)
      {
        bagb localbagb = (bagb)this.jdField_a_of_type_Badu.a(1020);
        if (localbagb != null) {
          localbagb.a();
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
    this.jdField_a_of_type_Bhsx.a("initInfoCardCommonLayoutStart", true);
    this.jdField_d_of_type_AndroidViewView = View.inflate(this, 2131561484, null);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView = ((PullToZoomHeaderListView)this.jdField_d_of_type_AndroidViewView.findViewById(2131364907));
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.setMotionEventInterceptor(this);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.setNeedCheckSpringback(true);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.setOnScrollListener(this.jdField_a_of_type_Blih);
    this.jdField_b_of_type_AndroidViewView = this.jdField_d_of_type_AndroidViewView.findViewById(2131365177);
    this.jdField_c_of_type_AndroidViewView = this.jdField_d_of_type_AndroidViewView.findViewById(2131374418);
    this.jdField_a_of_type_AndroidViewView = View.inflate(this, 2131561437, null);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131368648));
    Object localObject = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368642);
    if (localObject != null) {}
    try
    {
      localObject = (Animatable)((ImageView)localObject).getDrawable();
      if (!((Animatable)localObject).isRunning()) {
        ((Animatable)localObject).start();
      }
      label189:
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView = ((ProfileCardMoreInfoView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368656));
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_Azxr, this.app, this, this.h, this.jdField_a_of_type_Bjaz);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_b_of_type_Boolean = this.jdField_e_of_type_Boolean;
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_c_of_type_Boolean = this.f;
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366289));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131379718));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_d_of_type_AndroidViewView.findViewById(2131363990));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.addHeaderView(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.setAdapter(new blrq(null));
      localObject = new FriendProfileCardActivity.ProfileTopGestureLayout(this, this);
      ((FriendProfileCardActivity.ProfileTopGestureLayout)localObject).setOnFlingGesture(this);
      ((FriendProfileCardActivity.ProfileTopGestureLayout)localObject).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      ((FriendProfileCardActivity.ProfileTopGestureLayout)localObject).addView(this.jdField_d_of_type_AndroidViewView);
      setContentView((View)localObject);
      localObject = (FrameLayout)findViewById(16908290);
      if (localObject != null) {
        ((FrameLayout)localObject).setBackgroundResource(2130845770);
      }
      if (this.jdField_b_of_type_Blhq != null)
      {
        localObject = this.jdField_b_of_type_Blhq.obtainMessage(10);
        this.jdField_b_of_type_Blhq.sendMessageDelayed((Message)localObject, 10000L);
      }
      s();
      this.jdField_a_of_type_Bhsx.a("initInfoCardCommonLayoutEnd", "initInfoCardCommonLayoutStart", false);
      return;
    }
    catch (Exception localException)
    {
      break label189;
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Azxr.jdField_b_of_type_Boolean)
    {
      q();
      return;
    }
    if (ProfileActivity.AllInOne.k(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
    {
      atck.a(this.app).a(this.app, this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne, new aepp(this));
      return;
    }
    b(this.app, this, this.jdField_a_of_type_Azxr);
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
    if ((this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g == 100) && (GesturePWDUtils.getJumpLock(getActivity(), this.app.getCurrentAccountUin()))) {
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
      this.jdField_a_of_type_AndroidViewView.findViewById(2131368664).setVisibility(8);
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
      this.jdField_a_of_type_AndroidViewView.findViewById(2131368664).setVisibility(0);
    }
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
      bafb.a(this.app, this, this.jdField_a_of_type_Azxr);
      bdll.b(this.app, "CliOper", "", "", "0X8006A76", "0X8006A76", 0, 0, "", "", "", "");
      baew.j(this.app, this.jdField_a_of_type_Azxr);
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
    if ((this.jdField_a_of_type_Baei != null) && (this.jdField_a_of_type_Baei.a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfileCardActivity", 2, "onBackEvent event cost by component");
      }
      return true;
    }
    if (this.jdField_a_of_type_Akrf != null) {
      this.jdField_a_of_type_Akrf.c();
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
    if ((this.jdField_a_of_type_Azxr != null) && (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33))
    {
      this.jdField_a_of_type_Bhsx = new bhsx();
      this.jdField_d_of_type_Boolean = false;
      if (this.jdField_a_of_type_Blhq != null)
      {
        Message localMessage = this.jdField_a_of_type_Blhq.obtainMessage();
        if (ProfileActivity.AllInOne.g(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
        {
          localMessage.what = 1;
          localMessage.obj = this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
          this.jdField_a_of_type_Blhq.sendMessage(localMessage);
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