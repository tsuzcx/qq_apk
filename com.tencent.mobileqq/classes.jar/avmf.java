import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.image.VideoDrawable.VideoDrawableParams;
import com.tencent.jungle.nearby.nio.proto.nearby.BarInfo;
import com.tencent.jungle.nearby.nio.proto.nearby.Cmd0x1RspBody;
import com.tencent.jungle.nearby.nio.proto.nearby.FansInfo;
import com.tencent.jungle.nearby.nio.proto.nearby.FeedInfo;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.ShowExternalTroop;
import com.tencent.mobileqq.data.StrangerInfo;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.musicgene.MusicGeneQQBrowserActivity;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyCardVoteView;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.13;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.20;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.26;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.28;
import com.tencent.mobileqq.nearby.profilecard.SavorTagIcon;
import com.tencent.mobileqq.nearby.profilecard.SavorTagImg;
import com.tencent.mobileqq.nearby.widget.AvatarWallViewPager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomImgView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class avmf
  extends avks
  implements View.OnClickListener, avpu, benm
{
  public static String[] b;
  public static String[] c;
  int jdField_a_of_type_Int = 0;
  DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new avna(this);
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new avmg(this);
  Handler jdField_a_of_type_AndroidOsHandler = new avmy(this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new avmx(this);
  private Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new avne(this);
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private apit jdField_a_of_type_Apit;
  protected auub a;
  private auwu jdField_a_of_type_Auwu;
  private avnj jdField_a_of_type_Avnj;
  avpv jdField_a_of_type_Avpv = null;
  protected awqq a;
  private bfoj jdField_a_of_type_Bfoj = new avnb(this);
  bhtd jdField_a_of_type_Bhtd;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private NearbyPeopleCard jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
  private HeartLayout jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout;
  private NearbyCardVoteView jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView;
  public NearbyPeopleProfileActivity a;
  SavorTagImg jdField_a_of_type_ComTencentMobileqqNearbyProfilecardSavorTagImg;
  private AvatarWallViewPager jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager;
  RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  ProgressButton jdField_a_of_type_ComTencentMobileqqWidgetProgressButton;
  CustomImgView jdField_a_of_type_ComTencentWidgetCustomImgView;
  private ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  String jdField_a_of_type_JavaLangString;
  private WeakReference<bdbk> jdField_a_of_type_JavaLangRefWeakReference;
  List<String> jdField_a_of_type_JavaUtilList;
  protected final Map<String, View> a;
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private byte[] jdField_a_of_type_ArrayOfByte;
  int[] jdField_a_of_type_ArrayOfInt = { 2131369276, 2131369270, 2131369269, 2131369277 };
  RelativeLayout[] jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout;
  avau[] jdField_a_of_type_ArrayOfAvau;
  private URLImageView[] jdField_a_of_type_ArrayOfComTencentImageURLImageView;
  SavorTagIcon[] jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon;
  SavorTagImg[] jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg;
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  int jdField_b_of_type_Int;
  View jdField_b_of_type_AndroidViewView;
  private Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  String jdField_b_of_type_JavaLangString = "";
  AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  public boolean b;
  int[] jdField_b_of_type_ArrayOfInt = { 2131369274, 2131369275, 2131369271 };
  RelativeLayout[] jdField_b_of_type_ArrayOfAndroidWidgetRelativeLayout;
  int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  String jdField_c_of_type_JavaLangString = "";
  AtomicInteger jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  public boolean c;
  int jdField_d_of_type_Int;
  private View jdField_d_of_type_AndroidViewView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_d_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  String jdField_d_of_type_JavaLangString = "";
  public boolean d;
  int jdField_e_of_type_Int = 0;
  private View jdField_e_of_type_AndroidViewView;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_e_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_e_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  String jdField_e_of_type_JavaLangString = "";
  public boolean e;
  private int jdField_f_of_type_Int;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_f_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_f_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_f_of_type_AndroidWidgetTextView;
  protected String f;
  public boolean f;
  private LinearLayout jdField_g_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_g_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_g_of_type_AndroidWidgetTextView;
  public boolean g;
  private LinearLayout jdField_h_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_h_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_h_of_type_AndroidWidgetTextView;
  public boolean h;
  private LinearLayout jdField_i_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_i_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_i_of_type_AndroidWidgetTextView;
  public boolean i;
  private RelativeLayout jdField_j_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_j_of_type_AndroidWidgetTextView;
  public boolean j;
  private RelativeLayout jdField_k_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_k_of_type_AndroidWidgetTextView;
  public boolean k;
  private RelativeLayout jdField_l_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_l_of_type_AndroidWidgetTextView;
  public boolean l;
  private TextView jdField_m_of_type_AndroidWidgetTextView;
  boolean jdField_m_of_type_Boolean = true;
  private TextView jdField_n_of_type_AndroidWidgetTextView;
  boolean jdField_n_of_type_Boolean = true;
  private TextView jdField_o_of_type_AndroidWidgetTextView;
  boolean jdField_o_of_type_Boolean = false;
  private TextView jdField_p_of_type_AndroidWidgetTextView;
  boolean jdField_p_of_type_Boolean = false;
  private TextView jdField_q_of_type_AndroidWidgetTextView;
  boolean jdField_q_of_type_Boolean = false;
  private TextView jdField_r_of_type_AndroidWidgetTextView;
  boolean jdField_r_of_type_Boolean = false;
  private TextView jdField_s_of_type_AndroidWidgetTextView;
  boolean jdField_s_of_type_Boolean = false;
  boolean t = false;
  protected boolean u = true;
  private boolean v;
  private boolean w;
  
  static
  {
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "0X800553B", "0X800553C", "0X800553D", "0X800553E", "0X800553F", "0X8005540", "0X8005541" };
    jdField_c_of_type_ArrayOfJavaLangString = new String[] { "0X8005542", "0X8005543", "0X8005544", "0X8005545", "0X8005546", "0X8005547", "0X8005548" };
  }
  
  public avmf(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity)
  {
    super(paramNearbyPeopleProfileActivity);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity = paramNearbyPeopleProfileActivity;
    this.jdField_a_of_type_Bhtd = new bhtd(ThreadManager.getSubThreadLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    if (paramNearbyPeopleProfileActivity.getIntent().getIntExtra("frome_where", 0) == 35) {}
    for (;;)
    {
      this.jdField_p_of_type_Boolean = bool;
      this.jdField_o_of_type_Boolean = paramNearbyPeopleProfileActivity.getIntent().getBooleanExtra("is_from_werewolves", false);
      return;
      bool = false;
    }
  }
  
  private void a(TextView paramTextView)
  {
    int i1 = paramTextView.getWidth();
    int i2 = paramTextView.getHeight();
    Object localObject2 = new StringBuilder();
    if (this.jdField_f_of_type_Int > 0) {}
    for (Object localObject1 = "+ ";; localObject1 = "- ")
    {
      paramTextView.setText((String)localObject1 + String.valueOf(Math.abs(this.jdField_f_of_type_Int)));
      if (paramTextView.getVisibility() != 0) {
        paramTextView.setVisibility(0);
      }
      localObject1 = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, i1 / 2, i2 / 2);
      localObject2 = new AlphaAnimation(0.0F, 1.0F);
      AnimationSet localAnimationSet = new AnimationSet(true);
      localAnimationSet.setInterpolator(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 17432584);
      localAnimationSet.addAnimation((Animation)localObject1);
      localAnimationSet.addAnimation((Animation)localObject2);
      localAnimationSet.setDuration(1500L);
      paramTextView.setAnimation(localAnimationSet);
      localAnimationSet.start();
      this.jdField_f_of_type_Int = 0;
      return;
    }
  }
  
  private void a(String paramString)
  {
    Object localObject = paramString;
    if (TextUtils.isEmpty(paramString)) {
      localObject = String.format("https://y.qq.com/m/gene/index.html?uin=%s&_bid=155&_wv=10017", new Object[] { this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin });
    }
    paramString = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, MusicGeneQQBrowserActivity.class);
    paramString.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin());
    paramString.putExtra("url", (String)localObject);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
      paramString.putExtra("BUDNLE_KEY_IS_MY_PROFILE", true);
    }
    for (;;)
    {
      localObject = Calendar.getInstance();
      if ((localObject != null) && (QLog.isColorLevel()))
      {
        localObject = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(((Calendar)localObject).getTime());
        if (QLog.isDevelopLevel()) {
          QLog.d("Q.nearby_people_card.", 4, "musicgene123 startactivity " + (String)localObject);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(paramString);
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004182 ", "0X8004182", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      return;
      paramString.putExtra("BUDNLE_KEY_IS_MY_PROFILE", false);
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_h_of_type_Int == 5) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_f_of_type_Boolean))
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a().a();
      localObject = str;
      if (str == null) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131699208);
      }
      amkl.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, paramString, (String)localObject, 1010);
    }
    Object localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, ChatActivity.class);
    ((Intent)localObject).putExtra("PREVIOUS_WINDOW", NearbyPeopleProfileActivity.class.getName());
    ((Intent)localObject).putExtra("PREVIOUS_UIN", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
    ((Intent)localObject).putExtra("cSpecialFlag", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_AndroidContentIntent.getExtras().getInt("cSpecialFlag"));
    ((Intent)localObject).putExtra("uin", paramString);
    ((Intent)localObject).putExtra("uintype", paramInt);
    ((Intent)localObject).putExtra("aio_msg_source", 3);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.j != 0) {
      ((Intent)localObject).putExtra("entrance", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.j);
    }
    if (paramInt == 1001)
    {
      ((Intent)localObject).putExtra("rich_accost_sig", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b);
      ((Intent)localObject).putExtra("gender", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender);
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString);
      ((Intent)localObject).addFlags(67108864);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.finish();
      return;
      if (paramInt == 1010)
      {
        ((Intent)localObject).putExtra("rich_date_sig", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b);
        ((Intent)localObject).putExtra("gender", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender);
      }
    }
  }
  
  private void a(List<StrangerInfo> paramList)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("updateVistorHeader visitor count:");
      if (paramList != null) {
        break label106;
      }
    }
    label106:
    for (int i1 = 0;; i1 = paramList.size())
    {
      QLog.d("Q.nearby.visitor", 2, i1);
      localObject1 = avuf.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, new Object[] { Integer.valueOf(4105), "100510.100523" });
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a((BusinessInfoCheckUpdate.AppInfo)localObject1);
      if ((paramList != null) && (paramList.size() != 0)) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    if (paramList.size() > 3) {}
    int i2;
    for (i1 = 3;; i1 = paramList.size())
    {
      localObject1 = new ArrayList(3);
      i2 = 0;
      while (i2 < i1)
      {
        localObject2 = (StrangerInfo)paramList.get(i2);
        if (localObject2 != null) {
          ((List)localObject1).add(localObject2);
        }
        i2 += 1;
      }
    }
    int i3 = ((List)localObject1).size();
    paramList = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources();
    Object localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    if (((RelativeLayout.LayoutParams)localObject2).width != this.jdField_b_of_type_Int * i3 + (i3 - 1) * this.jdField_c_of_type_Int) {
      ((RelativeLayout.LayoutParams)localObject2).width = (this.jdField_b_of_type_Int * i3 + (i3 - 1) * this.jdField_c_of_type_Int);
    }
    for (i1 = 1;; i1 = 0)
    {
      if ((!this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b()) && (((RelativeLayout.LayoutParams)localObject2).rightMargin != aepi.a(35.0F, paramList)))
      {
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = aepi.a(35.0F, paramList);
        i2 = 1;
      }
      for (;;)
      {
        if (i2 != 0) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        i1 = 0;
        while (i1 < i3)
        {
          localObject2 = new LinearLayout.LayoutParams(aepi.a(30.0F, paramList), aepi.a(30.0F, paramList));
          ((LinearLayout.LayoutParams)localObject2).rightMargin = aepi.a(5.0F, paramList);
          StrangerInfo localStrangerInfo = (StrangerInfo)((List)localObject1).get(i1);
          if (localStrangerInfo != null)
          {
            CustomImgView localCustomImgView = new CustomImgView(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
            Drawable localDrawable = localCustomImgView.a();
            if ((localDrawable != null) && ((localDrawable instanceof bdaf))) {
              ((bdaf)localDrawable).a();
            }
            localCustomImgView.setImageDrawable(bdbk.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, 202, String.valueOf(localStrangerInfo.tinyId), true));
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localCustomImgView, (ViewGroup.LayoutParams)localObject2);
          }
          i1 += 1;
        }
        i2 = i1;
        if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b())
        {
          i2 = i1;
          if (((RelativeLayout.LayoutParams)localObject2).rightMargin != aepi.a(45.0F, paramList))
          {
            ((RelativeLayout.LayoutParams)localObject2).rightMargin = aepi.a(45.0F, paramList);
            i2 = 1;
          }
        }
      }
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      return;
    }
  }
  
  private byte[] a()
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localObject2.length != 0) {}
    }
    else
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.d != 51) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a().m(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      }
    }
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (localObject1.length != 0) {}
    }
    else
    {
      localObject2 = localObject1;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.d == 51) {
        localObject2 = this.jdField_a_of_type_ArrayOfByte;
      }
    }
    if ((localObject2 == null) && (QLog.isColorLevel())) {
      QLog.e("Q.nearby_people_card.", 2, "nearbySig is null ");
    }
    return localObject2;
  }
  
  private void b(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("operation", paramInt);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add("nearby.qq.com");
      athj.a("nearbyYanzhiCallback", localJSONObject, localArrayList, null);
      return;
    }
    catch (JSONException localJSONException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("NearbyProfileDisplayTribePanel", 2, localJSONException.toString());
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    int i1 = 0;
    switch (paramInt2)
    {
    default: 
      if (i1 == 0) {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
      break;
    }
    label135:
    Object localObject1;
    label184:
    do
    {
      return;
      i1 = 2131699705;
      break;
      i1 = 2131699193;
      azqs.b(null, "dc00899", "grp_lbs", "", "data_card", "exp_gift", 0, 0, "", "", "", "");
      break;
      if (this.w)
      {
        i1 = 2131696843;
        if (!this.w) {
          break label184;
        }
      }
      for (localObject1 = "exp_followed";; localObject1 = "exp_follow")
      {
        azqs.b(null, "dc00899", "grp_lbs", "", "data_card", (String)localObject1, 0, 0, "", "", "", "");
        break;
        i1 = 2131696841;
        break label135;
      }
      i1 = 2131719767;
      azqs.b(null, "dc00899", "grp_lbs", "", "data_card", "exp_msg", 0, 0, "", "", "", "");
      break;
      i1 = 2131693560;
      break;
      i1 = 2131694753;
      break;
      i1 = 2131699251;
      break;
      localObject1 = this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt1);
      ((View)localObject1).setVisibility(0);
      if (paramInt1 == 0) {
        ((View)localObject1).setVisibility(8);
      }
      if (paramInt2 == 40) {
        break label499;
      }
      localObject2 = (Button)((View)localObject1).findViewById(2131379107);
      ((Button)localObject2).setText(i1);
      if (paramInt2 == 38)
      {
        ((Button)localObject2).setBackgroundResource(2130849482);
        ((Button)localObject2).setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131165556));
      }
      ((Button)localObject2).setOnClickListener(this);
      localObject3 = new awor(paramInt2, null);
      ((Button)localObject2).setTag(localObject3);
      ((View)localObject1).setTag(localObject3);
      if ((paramInt2 == 60) && (this.w))
      {
        ((Button)localObject2).setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131166936));
        ((Button)localObject2).setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130839147));
        return;
      }
      if ((paramInt2 == 8) && (this.jdField_q_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Boolean))
      {
        ((Button)localObject2).setBackgroundResource(2130849482);
        ((Button)localObject2).setTextColor(Color.parseColor("#BBBBBB"));
        return;
      }
    } while ((paramInt2 != 36) || (!this.jdField_r_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Boolean));
    ((Button)localObject2).setBackgroundResource(2130849482);
    ((Button)localObject2).setTextColor(Color.parseColor("#BBBBBB"));
    return;
    label499:
    ((Button)((View)localObject1).findViewById(2131379107)).setVisibility(8);
    Object localObject2 = new awor(paramInt2, null);
    Object localObject3 = (ProgressButton)((View)localObject1).findViewById(2131372345);
    if (localObject3 != null)
    {
      ((ProgressButton)localObject3).setVisibility(0);
      ((ProgressButton)localObject3).setText(i1);
      if (paramInt2 == 38)
      {
        ((ProgressButton)localObject3).setBackgroundResource(2130849482);
        ((ProgressButton)localObject3).setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131165556));
      }
      ((ProgressButton)localObject3).setOnClickListener(this);
      ((ProgressButton)localObject3).setTag(localObject2);
    }
    ((View)localObject1).setTag(localObject2);
  }
  
  private void b(byte[] paramArrayOfByte)
  {
    Object localObject = null;
    this.jdField_r_of_type_AndroidWidgetTextView.setVisibility(0);
    if (paramArrayOfByte != null)
    {
      RichStatus localRichStatus = RichStatus.parseStatus(paramArrayOfByte);
      paramArrayOfByte = (byte[])localObject;
      if (localRichStatus != null) {
        paramArrayOfByte = localRichStatus.toSpannableString(null, -8947849, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131165307));
      }
      localObject = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        localObject = new SpannableString("");
      }
      if ((localRichStatus != null) && (!TextUtils.isEmpty(localRichStatus.actionText)))
      {
        localObject = new SpannableStringBuilder((CharSequence)localObject);
        ((SpannableStringBuilder)localObject).insert(0, "[S] ");
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Ayec != null) {}
        for (paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Ayec.a(localRichStatus.actionId, 200);; paramArrayOfByte = bdal.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources(), 2130849040))
        {
          paramArrayOfByte = new bevq(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources(), paramArrayOfByte, false, false);
          int i1 = (int)(this.jdField_r_of_type_AndroidWidgetTextView.getTextSize() * 1.1F + 0.5F);
          paramArrayOfByte.setBounds(0, 0, i1, i1);
          paramArrayOfByte = new beri(paramArrayOfByte, 0);
          paramArrayOfByte.a(-0.1F);
          ((SpannableStringBuilder)localObject).setSpan(paramArrayOfByte, 0, "[S]".length(), 17);
          this.jdField_r_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "exp_word", 0, 0, "", "", "", "");
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "exp_word", 0, 0, "", "", "", "");
          return;
        }
      }
      paramArrayOfByte = bdnn.d(((SpannableString)localObject).toString());
      if (TextUtils.isEmpty(paramArrayOfByte))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2)
        {
          this.jdField_r_of_type_AndroidWidgetTextView.setVisibility(8);
          return;
        }
        this.jdField_r_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
      }
      this.jdField_r_of_type_AndroidWidgetTextView.setText(paramArrayOfByte.trim());
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2)
    {
      this.jdField_r_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    this.jdField_r_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private int c()
  {
    int i2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_AndroidContentIntent.getIntExtra("frome_where", 6);
    int i1;
    if (i2 > 0)
    {
      i1 = i2;
      if (i2 < 6) {}
    }
    else
    {
      i1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int;
      if (i1 != 5) {
        break label47;
      }
      i1 = 1;
    }
    return i1;
    label47:
    if (ProfileActivity.c(i1)) {
      return 3;
    }
    if (((i1 >= 10) && (i1 <= 19)) || (i1 == 30)) {
      return 2;
    }
    return 6;
  }
  
  private int d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null)) {
      return 1001;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.lUserFlag & 0x800) != 0L) {
      return 0;
    }
    return bddf.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
  }
  
  private void o()
  {
    this.jdField_a_of_type_Auwu.a();
  }
  
  private void p()
  {
    ArrayList localArrayList1 = new ArrayList(4);
    Object localObject = new ArrayList(3);
    ArrayList localArrayList2 = new ArrayList(9);
    if (this.jdField_f_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) {
      localArrayList2.add(this.jdField_f_of_type_AndroidWidgetRelativeLayout);
    }
    int i1 = 0;
    String str1;
    label139:
    String str2;
    if (i1 < 3)
    {
      if (this.jdField_a_of_type_ArrayOfAvau[(i1 + 4)].jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        ((List)localObject).add(this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[i1]);
        localArrayList2.add(this.jdField_b_of_type_ArrayOfAndroidWidgetRelativeLayout[i1]);
        this.jdField_b_of_type_ArrayOfAndroidWidgetRelativeLayout[i1].setVisibility(0);
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2)
        {
          str1 = "1";
          if (this.jdField_a_of_type_ArrayOfAvau[i1].jdField_a_of_type_Int > 4) {
            break label223;
          }
          str2 = this.jdField_a_of_type_ArrayOfAvau[i1].jdField_a_of_type_Int + 3 + "";
          label182:
          azqs.b(localQQAppInterface, "dc00899", "grp_lbs", "", "data_card", "exp_tag", 0, 0, str1, "", str2, "");
        }
      }
      for (;;)
      {
        i1 += 1;
        break;
        str1 = "2";
        break label139;
        label223:
        str2 = this.jdField_a_of_type_ArrayOfAvau[i1].jdField_a_of_type_Int - 4 + "";
        break label182;
        this.jdField_b_of_type_ArrayOfAndroidWidgetRelativeLayout[i1].setVisibility(8);
      }
    }
    i1 = 0;
    if (i1 < 4)
    {
      if (this.jdField_a_of_type_ArrayOfAvau[i1].jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        localArrayList1.add(this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[i1]);
        localArrayList2.add(this.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i1]);
        this.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i1].setVisibility(0);
        localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2)
        {
          str1 = "1";
          label354:
          if (this.jdField_a_of_type_ArrayOfAvau[i1].jdField_a_of_type_Int > 4) {
            break label438;
          }
          str2 = this.jdField_a_of_type_ArrayOfAvau[i1].jdField_a_of_type_Int + 3 + "";
          label397:
          azqs.b((QQAppInterface)localObject, "dc00899", "grp_lbs", "", "data_card", "exp_tag", 0, 0, str1, "", str2, "");
        }
      }
      for (;;)
      {
        i1 += 1;
        break;
        str1 = "2";
        break label354;
        label438:
        str2 = this.jdField_a_of_type_ArrayOfAvau[i1].jdField_a_of_type_Int - 4 + "";
        break label397;
        this.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i1].setVisibility(8);
      }
    }
    if (localArrayList2.size() > 0) {
      ((View)localArrayList2.get(0)).setBackgroundDrawable(null);
    }
    for (;;)
    {
      if (localArrayList2.size() > 1) {
        ((View)localArrayList2.get(localArrayList2.size() - 1)).setBackgroundResource(2130849757);
      }
      return;
      if (localArrayList2.size() == 0) {
        this.jdField_c_of_type_AndroidViewView.findViewById(2131369222).setVisibility(8);
      }
    }
  }
  
  private void q()
  {
    this.jdField_g_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    if (this.jdField_h_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_h_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
  
  private void r()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_h_of_type_Boolean) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bVideoHeadUrl)))
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetCustomImgView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    u();
  }
  
  private void s()
  {
    this.jdField_e_of_type_AndroidViewView.setBackgroundResource(2130845142);
    this.jdField_m_of_type_AndroidWidgetTextView.setOnClickListener(null);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2)
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_l_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_l_of_type_AndroidWidgetTextView.setText(2131695620);
      this.jdField_l_of_type_AndroidWidgetTextView.setOnClickListener(new avmm(this));
      return;
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_l_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_l_of_type_AndroidWidgetTextView.setText(2131695620);
    this.jdField_l_of_type_AndroidWidgetTextView.setOnClickListener(new avmn(this));
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_Awqq != null) {
      this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.addOrUpdateBuisEntry(this.jdField_a_of_type_Awqq);
    }
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Auxh == null) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null));
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Auxh.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, 0, 1);
        return;
      }
      catch (NumberFormatException localNumberFormatException) {}
    } while (!QLog.isColorLevel());
    QLog.e("Q.nearby_people_card.", 2, "NumberFormatException");
  }
  
  private void u()
  {
    bool = true;
    this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131167040));
    try
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130845138));
      this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(null);
      Object localObject = bdbk.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, 200, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin), 3);
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localObject);
      this.jdField_a_of_type_ComTencentWidgetCustomImgView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetCustomImgView.setImageDrawable((Drawable)localObject);
      int i1 = (int)(70.0F * this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Float + 0.5D);
      int i2 = (int)(2.0F * this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Float + 0.5D);
      localObject = new Paint();
      ((Paint)localObject).setColor(-1);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      ((Paint)localObject).setStrokeWidth(i2);
      ((Paint)localObject).setAntiAlias(true);
      try
      {
        Bitmap localBitmap = Bitmap.createBitmap(i2 * 2 + i1, i2 * 2 + i1, Bitmap.Config.ARGB_8888);
        if (localBitmap != null)
        {
          new Canvas(localBitmap).drawCircle(i1 / 2 + i2, i2 + i1 / 2, i1 / 2, (Paint)localObject);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.i("Q.nearby_people_card.", 2, "onHeadSizeIsSmall create bitmap oom.");
            continue;
            this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130845140);
            bool = false;
            continue;
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 3)
            {
              this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
              this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
              this.jdField_a_of_type_ComTencentWidgetCustomImgView.setOnClickListener(this);
            }
          }
        }
      }
      this.jdField_e_of_type_AndroidViewView.setBackgroundDrawable(null);
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        if (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130845141);
          this.jdField_a_of_type_ComTencentWidgetCustomImgView.setTag(Boolean.valueOf(bool));
          this.jdField_a_of_type_ComTencentWidgetCustomImgView.setOnClickListener(this);
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.i();
          return;
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.nearby_people_card.", 2, "onHeadSizeIsSmall getDrawable oom.");
        }
      }
    }
  }
  
  private void v()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.finish();
    bdfa.anim(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, false, false);
  }
  
  private void w()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Auxh != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Boolean) {
        break label253;
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Auxh.a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin()).longValue(), Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin).longValue(), this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.vCookies, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.favoriteSource, this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get(), 0);
        bool = ((auvr)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(207)).c(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin).longValue());
        if (PraiseManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app) <= 0) {
          break label239;
        }
        if (!bool) {
          break label234;
        }
        i1 = 3;
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "P_prof", "Prof_good", 2, this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get(), i1, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int)), String.valueOf(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()), this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      }
    }
    label234:
    label239:
    label253:
    while ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0) && (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0)) {
      for (;;)
      {
        boolean bool;
        return;
        i1 = 2;
        continue;
        if (bool) {
          i1 = 1;
        } else {
          i1 = 0;
        }
      }
    }
    ArrayList localArrayList = new ArrayList();
    auvw localauvw = new auvw();
    localauvw.jdField_a_of_type_Int = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    localauvw.jdField_b_of_type_Int = this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    localauvw.jdField_a_of_type_Long = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin).longValue();
    localauvw.d = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.favoriteSource;
    localArrayList.add(localauvw);
    if (NearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.j)) {}
    for (int i1 = 510;; i1 = 509)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Auxh.a(localArrayList, i1);
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      return;
    }
  }
  
  protected int a()
  {
    return 2131561088;
  }
  
  View a(int paramInt, PicInfo paramPicInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyProfileDisplayTribePanel", 2, "getAvatarWallItemView, position = " + paramInt + ", info = " + paramPicInfo.toString());
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    localRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    CustomImgView localCustomImgView = new CustomImgView(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    localCustomImgView.setLayoutParams(new LinearLayout.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_f_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_f_of_type_Int));
    localRelativeLayout.addView(localCustomImgView, new LinearLayout.LayoutParams(-1, -1));
    Object localObject1 = new ImageView(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    ((ImageView)localObject1).setBackgroundResource(2130841043);
    ((ImageView)localObject1).setImageResource(2130845434);
    ((ImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
    ((ImageView)localObject1).setVisibility(8);
    int i1 = xsm.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 24.0F);
    Object localObject2 = new RelativeLayout.LayoutParams(i1, i1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(13);
    ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localRelativeLayout.addView((View)localObject1);
    localCustomImgView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130844654));
    localCustomImgView.setTag(paramPicInfo);
    localCustomImgView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (AppSetting.jdField_c_of_type_Boolean) {
      localRelativeLayout.setContentDescription(alud.a(2131707720) + paramInt);
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130845300);
    try
    {
      if ((!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_p_of_type_Boolean) || (TextUtils.isEmpty(paramPicInfo.jdField_d_of_type_JavaLangString))) {
        break label536;
      }
      this.jdField_a_of_type_JavaUtilMap.put(paramPicInfo.jdField_d_of_type_JavaLangString, localRelativeLayout);
      if (antx.b(paramPicInfo.jdField_d_of_type_JavaLangString))
      {
        localRelativeLayout.getChildAt(1).setVisibility(8);
        a(paramPicInfo, localRelativeLayout);
        return localRelativeLayout;
      }
      if (!bdin.h(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity)) {
        break label523;
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.c(paramPicInfo.jdField_d_of_type_JavaLangString);
      localRelativeLayout.getChildAt(1).setVisibility(0);
    }
    catch (MalformedURLException paramPicInfo)
    {
      while (QLog.isColorLevel())
      {
        QLog.d("Q.nearby_people_card.", 2, "PicGallery.getView() new URL(). " + paramPicInfo.getMessage(), paramPicInfo);
        return localRelativeLayout;
        localRelativeLayout.getChildAt(1).setVisibility(0);
        continue;
        localRelativeLayout.getChildAt(1).setVisibility(8);
      }
      if (bdnn.a(paramPicInfo.jdField_a_of_type_JavaLangString)) {
        break label641;
      }
      paramPicInfo = bauz.a(paramPicInfo.jdField_a_of_type_JavaLangString);
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_f_of_type_Int;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_f_of_type_Int;
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
      paramPicInfo = URLDrawable.getDrawable(paramPicInfo, (URLDrawable.URLDrawableOptions)localObject2);
      paramPicInfo.setDownloadListener(new auue(BaseApplicationImpl.getApplication(), "actNearbyPeoplePicDownload"));
      localCustomImgView.setImageDrawable(paramPicInfo);
    }
    if ((paramPicInfo.jdField_c_of_type_JavaLangString != null) && (paramPicInfo.jdField_c_of_type_JavaLangString.length() > 0))
    {
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_f_of_type_Int;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_f_of_type_Int;
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
      localCustomImgView.setImageDrawable(URLDrawable.getDrawable(new File(paramPicInfo.jdField_c_of_type_JavaLangString).toURL(), (URLDrawable.URLDrawableOptions)localObject2));
      return localRelativeLayout;
    }
    label523:
    label536:
    return localRelativeLayout;
  }
  
  public void a()
  {
    bfod.a(this.jdField_a_of_type_Bfoj);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    a(this.jdField_f_of_type_Int);
    if (!this.v)
    {
      i1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int;
      NearbyPeopleProfileActivity localNearbyPeopleProfileActivity = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
      if (i1 == 3)
      {
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon == null) {
          break label167;
        }
        i1 = 0;
        if (i1 >= 4) {
          break label167;
        }
        if (!this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[i1].a()) {
          break label151;
        }
      }
    }
    label151:
    label167:
    for (int i1 = 1;; i1 = 0)
    {
      int i3 = i1;
      int i2;
      if (i1 == 0)
      {
        i3 = i1;
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg != null) {
          i2 = 0;
        }
      }
      for (;;)
      {
        i3 = i1;
        if (i2 < 3)
        {
          if (this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[i2].a()) {
            i3 = 1;
          }
        }
        else
        {
          if (i3 != 0)
          {
            this.v = true;
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8005549", "0X8005549", 0, 0, "", "", "", "");
          }
          return;
          i1 += 1;
          break;
        }
        i2 += 1;
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
    if (this.jdField_f_of_type_Int == 0) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Charm", 2, "prepare2ScoreAnim() diff=" + paramInt);
    }
    TextView localTextView = (TextView)this.jdField_g_of_type_AndroidWidgetRelativeLayout.findViewById(2131365340);
    Rect localRect;
    if (localTextView.getTag() == null)
    {
      localRect = new Rect();
      localTextView.setTag(localRect);
    }
    for (;;)
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getWindow().getDecorView();
      localTextView.getGlobalVisibleRect(localRect);
      if (localRect.bottom >= localView.getHeight()) {
        break;
      }
      a(localTextView);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(202, 2500L);
      return;
      localRect = (Rect)localTextView.getTag();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      try
      {
        this.jdField_a_of_type_ComTencentWidgetCustomImgView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        String str = bddf.a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin));
        Object localObject = new URL("profile_img_big", null, str);
        if (paramInt2 == 1) {
          URLDrawable.removeMemoryCacheByUrl(((URL)localObject).toString());
        }
        localObject = new PicInfo();
        ((PicInfo)localObject).jdField_c_of_type_JavaLangString = str;
        if (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_i_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.add(0, localObject);
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_i_of_type_Boolean = true;
        }
        for (;;)
        {
          if (this.jdField_a_of_type_Avnj != null) {
            this.jdField_a_of_type_Avnj.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList);
          }
          if (paramInt2 == 1) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.i();
          return;
          if (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.set(0, localObject);
          }
        }
        QLog.i("Q.nearby_people_card.", 2, localMalformedURLException.getMessage());
      }
      catch (MalformedURLException localMalformedURLException)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
    } else if (paramInt2 == 1) {}
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Int - 150.0F * this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Float;
    Object localObject2 = null;
    Object localObject1;
    if ((paramInt2 > paramInt4) && (paramInt2 >= f1) && (this.jdField_h_of_type_AndroidWidgetRelativeLayout.getVisibility() == 8)) {
      localObject1 = this.jdField_a_of_type_AndroidViewAnimationAnimation;
    }
    for (;;)
    {
      if ((localObject1 != null) && (localObject1 != this.jdField_h_of_type_AndroidWidgetRelativeLayout.getAnimation()))
      {
        ((Animation)localObject1).reset();
        this.jdField_h_of_type_AndroidWidgetRelativeLayout.startAnimation((Animation)localObject1);
        this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.startAnimation((Animation)localObject1);
      }
      return;
      localObject1 = localObject2;
      if (paramInt2 < paramInt4)
      {
        localObject1 = localObject2;
        if (paramInt2 <= f1)
        {
          localObject1 = localObject2;
          if (this.jdField_h_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) {
            localObject1 = this.jdField_b_of_type_AndroidViewAnimationAnimation;
          }
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    default: 
    case 1000: 
    case 11000: 
    case 1018: 
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.setResult(-1);
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.finish();
          return;
        } while (paramIntent == null);
        return;
      } while (paramInt2 != -1);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int = 25;
      i();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NearbyLikeLimitManager", 2, "NearbyPeopleProfileActivity->doOnActivityResult, resultCode=" + paramInt2);
    }
    if (NearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.j)) {
      paramInt1 = 510;
    }
    for (;;)
    {
      paramIntent = (auxh)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a(60);
      try
      {
        l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
        paramIntent.a(l1, 0L, paramInt1);
        return;
        paramInt1 = 509;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("NearbyLikeLimitManager", 2, "doOnActivityResult req NearbyLikeLimitInfo: mCard.uin=" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
          }
          long l1 = 0L;
        }
      }
    }
  }
  
  protected void a(View paramView)
  {
    this.jdField_c_of_type_AndroidViewView = paramView;
    this.jdField_k_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131369198));
    this.jdField_l_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131369201));
    this.jdField_f_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131369231));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131377770));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131377706));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131377668));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131377671));
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131379191));
    this.jdField_i_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131369230));
    this.jdField_j_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131369308));
    paramView = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources();
    this.jdField_b_of_type_Int = paramView.getDimensionPixelSize(2131297282);
    this.jdField_c_of_type_Int = paramView.getDimensionPixelSize(2131297281);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131380057));
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.jdField_j_of_type_AndroidWidgetRelativeLayout).a(21).c(30).a();
    this.jdField_a_of_type_ArrayOfComTencentImageURLImageView = new URLImageView[] { (URLImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131368136), (URLImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131368137), (URLImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131368138) };
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131368179));
    this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131379199));
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView = ((NearbyCardVoteView)this.jdField_c_of_type_AndroidViewView.findViewById(2131380087));
    if (this.jdField_p_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout = ((HeartLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131367633));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.jdField_c_of_type_AndroidViewView.findViewById(2131363439));
    this.jdField_o_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131377646));
    this.jdField_p_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131377692));
    this.jdField_q_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131377645));
    this.jdField_r_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131380358));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131377712));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131377708));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131377707));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131369237));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131369184));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131369225));
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131369180));
    this.jdField_g_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131365278));
    this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131377643));
    this.jdField_e_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131375985);
    this.jdField_m_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131368670));
    this.jdField_k_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131368624));
    this.jdField_l_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131368655));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131368646));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131368182));
    this.jdField_a_of_type_ComTencentImageURLImageView.setColorFilter(436207616);
    this.jdField_a_of_type_ComTencentWidgetCustomImgView = ((CustomImgView)this.jdField_c_of_type_AndroidViewView.findViewById(2131368201));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131368202));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131368191));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131368192));
    if (this.jdField_p_of_type_Boolean)
    {
      paramView = this.jdField_c_of_type_AndroidViewView.findViewById(2131379478);
      localObject = (LinearLayout.LayoutParams)paramView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).height = bdaq.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 90.0F);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)this.jdField_c_of_type_AndroidViewView.findViewById(2131378030));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131363392));
    this.jdField_d_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131363436);
    paramView = (ImageView)this.jdField_d_of_type_AndroidViewView.findViewById(2131371242);
    Object localObject = (ImageView)this.jdField_d_of_type_AndroidViewView.findViewById(2131379581);
    ImageView localImageView = (ImageView)this.jdField_d_of_type_AndroidViewView.findViewById(2131369430);
    avmr localavmr = new avmr(this, paramView, (ImageView)localObject, localImageView);
    paramView.setOnClickListener(localavmr);
    ((ImageView)localObject).setOnClickListener(localavmr);
    localImageView.setOnClickListener(localavmr);
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, false, null))
    {
      paramView.setImageResource(2130845161);
      ((ImageView)localObject).setImageResource(2130845163);
      localImageView.setImageResource(2130845159);
      this.jdField_d_of_type_AndroidViewView.setBackgroundColor(0);
    }
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131367763));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131369236));
    this.jdField_n_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131377711));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_c_of_type_AndroidViewView.findViewById(2131363571));
    paramView = (RelativeLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131371166);
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, false, null)) {
      paramView.setBackgroundResource(2130845118);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager = ((AvatarWallViewPager)this.jdField_c_of_type_AndroidViewView.findViewById(2131363008));
      paramView = new RelativeLayout.LayoutParams(-1, -2);
      paramView.addRule(12);
      paramView.bottomMargin = xsm.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 28.0F);
      this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.setDotLayoutParams(paramView);
      this.jdField_h_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131375988));
      this.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131378273));
      this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131369739));
      this.jdField_b_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131375938);
      this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131368190));
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 3)
      {
        this.jdField_j_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_i_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_f_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
      paramView = (LinearLayout.LayoutParams)((RelativeLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131375921)).getLayoutParams();
      if (paramView != null) {
        paramView.height = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Int;
      }
      this.jdField_a_of_type_ComTencentWidgetCustomImgView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130844659));
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(4);
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setVerticalScrollBarEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.mScrollFlag = 1;
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnScrollChangedListener(this);
      this.jdField_a_of_type_AndroidViewAnimationAnimation = new AlphaAnimation(0.0F, 1.0F);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(300L);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setInterpolator(new AccelerateInterpolator());
      this.jdField_b_of_type_AndroidViewAnimationAnimation = new AlphaAnimation(1.0F, 0.0F);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(300L);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setInterpolator(new AccelerateInterpolator());
      this.jdField_k_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_k_of_type_AndroidWidgetTextView.setText(2131690382);
      this.jdField_k_of_type_AndroidWidgetTextView.setOnClickListener(new avmz(this));
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setAppInterface(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app);
      this.jdField_g_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131369287));
      this.jdField_i_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131369911));
      this.jdField_i_of_type_AndroidWidgetLinearLayout.setOnClickListener(new avnd(this));
      this.jdField_s_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131378755));
      this.jdField_a_of_type_Auwu = new auwu(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app);
      this.jdField_a_of_type_Auwu.a(this.jdField_s_of_type_AndroidWidgetTextView);
      return;
      paramView.setBackgroundResource(2130845117);
    }
  }
  
  public void a(View paramView, int paramInt, InterestTagInfo paramInterestTagInfo)
  {
    if ((paramInterestTagInfo == null) || (paramInt == 0) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 1))
    {
      if (auwz.b()) {
        auwz.a("NearbyProfileDisplayTribePanel", new Object[] { "onTagClick", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int), Integer.valueOf(paramInt), paramInterestTagInfo });
      }
      return;
    }
    QQAppInterface localQQAppInterface;
    if (paramInterestTagInfo.bid != 0L)
    {
      paramView = "https://buluo.qq.com/mobile/barindex.html?bid=" + paramInterestTagInfo.bid + "&_wv=1027";
      localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramView);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject);
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
      if (paramInterestTagInfo.bid == 0L) {
        break label310;
      }
      paramView = "tag_same";
      label162:
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2) {
        break label317;
      }
      paramInterestTagInfo = "1";
      label177:
      if (paramInt > 4) {
        break label324;
      }
    }
    label310:
    label317:
    label324:
    for (Object localObject = paramInt + 3 + "";; localObject = paramInt - 4 + "")
    {
      azqs.b(localQQAppInterface, "dc00899", "grp_lbs", "", "data_card", paramView, 0, 0, paramInterestTagInfo, "", (String)localObject, "");
      ThreadManager.post(new NearbyProfileDisplayTribePanel.28(this, paramInt), 5, null, false);
      return;
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
      paramView.putExtra("url", "https://buluo.qq.com/mobile/search_result.html?_bid=128&_wv=1027&search_keyword=" + paramInterestTagInfo.tagName + "&from=nearby_tag");
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(paramView);
      break;
      paramView = "clk_tag";
      break label162;
      paramInterestTagInfo = "2";
      break label177;
    }
  }
  
  public void a(NearbyPeopleCard paramNearbyPeopleCard)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard = paramNearbyPeopleCard;
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setNearbyPeopleCard(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
    }
    paramNearbyPeopleCard = bdne.k(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    if (!TextUtils.isEmpty(paramNearbyPeopleCard)) {}
    int i1;
    int i2;
    Object localObject1;
    Object localObject2;
    try
    {
      this.jdField_e_of_type_JavaLangString = new JSONObject(paramNearbyPeopleCard).getString("ownerLikeJumpURL");
      this.jdField_a_of_type_ComTencentImageURLImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname);
      if (!this.t)
      {
        this.t = true;
        this.jdField_a_of_type_ArrayOfJavaLangString = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getStringArray(2130968663);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon = new SavorTagIcon[4];
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg = new SavorTagImg[3];
        this.jdField_b_of_type_ArrayOfAndroidWidgetRelativeLayout = new RelativeLayout[3];
        this.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout = new RelativeLayout[4];
        this.jdField_a_of_type_ArrayOfAvau = new avau[7];
        i1 = 0;
        while (i1 < 7)
        {
          this.jdField_a_of_type_ArrayOfAvau[i1] = new avau(i1 + 1);
          i1 += 1;
        }
      }
    }
    catch (JSONException paramNearbyPeopleCard)
    {
      for (;;)
      {
        paramNearbyPeopleCard.printStackTrace();
      }
      i2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131166903);
      i1 = 0;
      while (i1 < 4)
      {
        this.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i1] = ((RelativeLayout)((ViewStub)this.jdField_c_of_type_AndroidViewView.findViewById(this.jdField_a_of_type_ArrayOfInt[i1])).inflate());
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[i1] = ((SavorTagIcon)this.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i1].findViewById(2131376120));
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[i1].a(this.jdField_a_of_type_ArrayOfJavaLangString[i1], this.jdField_a_of_type_ArrayOfAvau[i1].jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfAvau[i1].jdField_a_of_type_JavaUtilArrayList, this);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[i1].setRightArrowVisible(false);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[i1].setTitleTextColor(i2);
        if (AppSetting.jdField_c_of_type_Boolean) {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[i1].setClickable(true);
        }
        i1 += 1;
      }
      i1 = 0;
      while (i1 < 3)
      {
        this.jdField_b_of_type_ArrayOfAndroidWidgetRelativeLayout[i1] = ((RelativeLayout)((ViewStub)this.jdField_c_of_type_AndroidViewView.findViewById(this.jdField_b_of_type_ArrayOfInt[i1])).inflate());
        int i3 = i1 + 4;
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[i1] = ((SavorTagImg)this.jdField_b_of_type_ArrayOfAndroidWidgetRelativeLayout[i1].findViewById(2131376120));
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[i1].a(this.jdField_a_of_type_ArrayOfJavaLangString[i3], this.jdField_a_of_type_ArrayOfAvau[i3].jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfAvau[i3].jdField_a_of_type_JavaUtilArrayList, this);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[i1].setRightArrowVisible(false);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[i1].setTitleTextColor(i2);
        if (AppSetting.jdField_c_of_type_Boolean) {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[i1].setClickable(true);
        }
        i1 += 1;
      }
      if (this.jdField_f_of_type_AndroidWidgetRelativeLayout == null)
      {
        this.jdField_f_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((ViewStub)this.jdField_c_of_type_AndroidViewView.findViewById(2131369278)).inflate());
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardSavorTagImg = ((SavorTagImg)this.jdField_f_of_type_AndroidWidgetRelativeLayout.findViewById(2131376120));
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
      localObject2 = "" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2) {
        break label2164;
      }
    }
    paramNearbyPeopleCard = "1";
    azqs.b((QQAppInterface)localObject1, "dc00899", "grp_lbs", (String)localObject2, "data_card", "exp", 0, 0, paramNearbyPeopleCard, "" + this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.j % 20, "", "");
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2)
    {
      this.jdField_j_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      label656:
      if (!NearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.j)) {
        break label2277;
      }
      this.jdField_q_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isForbidSendMsgForTribar;
      this.jdField_r_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isForbidSendGiftMsgForTribar;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.disableSendMsgBtnTipsForTribar;
      this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.disableSendGiftBtnTipsForTribar;
      label713:
      this.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.highScoreNum;
      n();
      a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyInfo);
      s();
      h();
      paramNearbyPeopleCard = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources();
      i1 = paramNearbyPeopleCard.getColor(2131166903);
      i2 = paramNearbyPeopleCard.getColor(2131166983);
      if ((!this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isAuthUser()) && (!this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isFuXiaoJin())) {
        break label2324;
      }
      this.jdField_h_of_type_AndroidWidgetRelativeLayout.findViewById(2131368204).setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130841050);
      label823:
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2) {
        break label2376;
      }
      localObject1 = (TextView)this.jdField_f_of_type_AndroidWidgetLinearLayout.findViewById(2131377706);
      localObject2 = new StringBuilder();
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 0) {
        break label2366;
      }
      paramNearbyPeopleCard = alud.a(2131707692);
      label875:
      ((TextView)localObject1).setText(paramNearbyPeopleCard + alud.a(2131707726));
      label898:
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.iIsGodFlag != 1) {
        break label2414;
      }
      this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 1) {
        break label2401;
      }
      this.jdField_f_of_type_AndroidWidgetImageView.setImageResource(2130845488);
      label938:
      ThreadManager.post(new NearbyProfileDisplayTribePanel.13(this), 8, null, true);
      label953:
      localObject1 = new StringBuilder();
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 0) {
        break label2426;
      }
      ((StringBuilder)localObject1).append("男 ");
      this.jdField_h_of_type_AndroidWidgetTextView.setBackgroundColor(-12348939);
      label991:
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age > 0) {
        ((StringBuilder)localObject1).append("" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age + "岁 ");
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age > 0) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 0) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 1))
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2) {
          break label2459;
        }
        paramNearbyPeopleCard = "1";
        label1093:
        azqs.b((QQAppInterface)localObject2, "dc00899", "grp_lbs", "", "data_card", "exp_info", 0, 0, paramNearbyPeopleCard, "", "", "");
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.constellation != 0) && (bddf.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.constellation) != null))
      {
        ((StringBuilder)localObject1).append(bddf.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.constellation) + " ");
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2) {
          break label2466;
        }
        paramNearbyPeopleCard = "1";
        label1203:
        azqs.b((QQAppInterface)localObject2, "dc00899", "grp_lbs", "", "data_card", "exp_xing", 0, 0, paramNearbyPeopleCard, "", "", "");
      }
      if ((!bdnn.a(bdda.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus - 1))) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus != 1)) {
        break label2473;
      }
      if (((StringBuilder)localObject1).toString().length() <= 0) {
        break label2553;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      label1288:
      if (this.jdField_a_of_type_Auub == null) {
        this.jdField_a_of_type_Auub = auuc.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getAppInterface());
      }
      if (this.jdField_a_of_type_Auub.a()) {
        ((auur)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getAppInterface().getManager(204)).a(new avml(this));
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int != 31) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.q)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.timeDiff)) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2)) {
        break label2565;
      }
      this.jdField_h_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.q + "·" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.timeDiff + alud.a(2131707652));
      this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(0);
      if (QLog.isColorLevel()) {
        QLog.d("Q.hotChatDistance", 2, "bindData, use aioDistance");
      }
      label1480:
      if (QLog.isColorLevel()) {
        QLog.d("NearbyProfileDisplayTribePanel", 2, "bindData, mCard.videoInfo = " + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo);
      }
      if ((auxb.a()) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo != null)) {
        a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo.jdField_d_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 3) {
        break label2760;
      }
      if (((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.lUserFlag & 0x800) == 0L) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.strRemark == null) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.strRemark.equals(""))) {
        break label2736;
      }
      paramNearbyPeopleCard = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.strRemark.trim();
    }
    for (;;)
    {
      label1622:
      if (!TextUtils.isEmpty(paramNearbyPeopleCard)) {
        this.jdField_i_of_type_AndroidWidgetTextView.setText(paramNearbyPeopleCard.trim());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 3)
      {
        this.jdField_m_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        ((TextView)this.jdField_d_of_type_AndroidWidgetLinearLayout.findViewById(2131379219)).setText(paramNearbyPeopleCard);
        label1685:
        b(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan);
        if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.charm != 0L) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 3)) {
          break label2828;
        }
        this.jdField_g_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        label1728:
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2) {
          this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(null);
        }
        this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company = bdnn.d(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company);
        if (!bdnn.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company)) {
          break label2961;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2) {
          break label2928;
        }
        this.jdField_o_of_type_AndroidWidgetTextView.setTextColor(i2);
        this.jdField_o_of_type_AndroidWidgetTextView.setText(alud.a(2131707731));
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        label1817:
        this.jdField_p_of_type_AndroidWidgetTextView.setTextColor(i2);
        if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job <= 0) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job >= bdda.d.length)) {
          break label3046;
        }
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "exp_work", 0, 0, "", "", "", "");
        this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_p_of_type_AndroidWidgetTextView.setText(bdda.d[this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job]);
        this.jdField_p_of_type_AndroidWidgetTextView.setTextColor(i1);
        label1917:
        this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college = bdnn.d(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college);
        if (!bdnn.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college)) {
          break label3130;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2) {
          break label3118;
        }
        this.jdField_q_of_type_AndroidWidgetTextView.setTextColor(i2);
        this.jdField_q_of_type_AndroidWidgetTextView.setText(alud.a(2131707644));
        this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        label1987:
        t();
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 3) {
          break label3248;
        }
        if (!this.jdField_p_of_type_Boolean) {
          break label3215;
        }
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        new azqx(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("data_card").d("exp_face_score").e(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString).a();
      }
      for (;;)
      {
        r();
        j();
        this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.getTagInfos(this.jdField_a_of_type_ArrayOfAvau);
        i1 = 0;
        while (i1 < 4)
        {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[i1].a(this.jdField_a_of_type_ArrayOfAvau[i1].jdField_a_of_type_JavaUtilArrayList);
          if (AppSetting.jdField_c_of_type_Boolean) {
            this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[i1].setContentDescription(this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[i1].a());
          }
          i1 += 1;
        }
        label2164:
        paramNearbyPeopleCard = "2";
        break;
        this.jdField_j_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_j_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new avmh(this));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new avmi(this));
        ((bcod)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(113)).a(1402, new avmj(this));
        azqs.b(null, "dc00899", "grp_lbs", "", "rank_data", "my_point", 0, 0, "", "", "", "");
        break label656;
        label2277:
        this.jdField_q_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isForbidSendMsg;
        this.jdField_r_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isForbidSendGiftMsg;
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.disableSendMsgBtnTips;
        this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.disableSendGiftBtnTips;
        break label713;
        label2324:
        this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_h_of_type_AndroidWidgetRelativeLayout.findViewById(2131368204).setVisibility(8);
        this.jdField_e_of_type_AndroidWidgetLinearLayout.findViewById(2131368204).setVisibility(8);
        break label823;
        label2366:
        paramNearbyPeopleCard = alud.a(2131707673);
        break label875;
        label2376:
        ((TextView)this.jdField_f_of_type_AndroidWidgetLinearLayout.findViewById(2131377706)).setText(alud.a(2131707669));
        break label898;
        label2401:
        this.jdField_f_of_type_AndroidWidgetImageView.setImageResource(2130845487);
        break label938;
        label2414:
        this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
        break label953;
        label2426:
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 1) {
          break label991;
        }
        ((StringBuilder)localObject1).append("女 ");
        this.jdField_h_of_type_AndroidWidgetTextView.setBackgroundColor(-38511);
        break label991;
        label2459:
        paramNearbyPeopleCard = "2";
        break label1093;
        label2466:
        paramNearbyPeopleCard = "2";
        break label1203;
        label2473:
        ((StringBuilder)localObject1).append(bdda.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus - 1));
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2) {}
        for (paramNearbyPeopleCard = "1";; paramNearbyPeopleCard = "2")
        {
          azqs.b((QQAppInterface)localObject2, "dc00899", "grp_lbs", "", "data_card", "exp_relation", 0, 0, paramNearbyPeopleCard, "", "", "");
          break;
        }
        label2553:
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        break label1288;
        label2565:
        if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.aioDistanceAndTime)) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2))
        {
          this.jdField_h_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.aioDistanceAndTime.replace(" ", "·"));
          this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(0);
          break label1480;
        }
        if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.distance)) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.distance)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.timeDiff))) {
          break label1480;
        }
        this.jdField_h_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.distance + "·" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.timeDiff + alud.a(2131707749));
        this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(0);
        break label1480;
        label2736:
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname == null) {
          break label3356;
        }
        paramNearbyPeopleCard = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname.trim();
        break label1622;
        label2760:
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname == null) {
          break label3356;
        }
        paramNearbyPeopleCard = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname.trim();
        break label1622;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2) {
          break label1685;
        }
        this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_m_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_m_of_type_AndroidWidgetTextView.setText(alud.a(2131707709));
        break label1685;
        label2828:
        this.jdField_g_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_j_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.strLevelType);
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2)
        {
          this.jdField_j_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.mHeartNum + alud.a(2131707714));
          this.jdField_j_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131166903));
        }
        this.jdField_g_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
        break label1728;
        label2928:
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2) {
          break label1817;
        }
        this.jdField_d_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130849766);
        break label1817;
        label2961:
        this.jdField_o_of_type_AndroidWidgetTextView.setTextColor(i1);
        this.jdField_o_of_type_AndroidWidgetTextView.setText(new bamp(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company, 1, 16));
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(null);
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "exp_company", 0, 0, "", "", "", "");
        break label1817;
        label3046:
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2)
        {
          this.jdField_p_of_type_AndroidWidgetTextView.setText(alud.a(2131707758));
          break label1917;
        }
        this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        if ((this.jdField_c_of_type_AndroidWidgetRelativeLayout.getVisibility() != 8) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2)) {
          break label1917;
        }
        this.jdField_e_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130849766);
        break label1917;
        label3118:
        this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        break label1987;
        label3130:
        this.jdField_q_of_type_AndroidWidgetTextView.setTextColor(i1);
        this.jdField_q_of_type_AndroidWidgetTextView.setText(new bamp(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college, 1, 16));
        this.jdField_e_of_type_AndroidWidgetRelativeLayout.setOnClickListener(null);
        this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "exp_school", 0, 0, "", "", "", "");
        break label1987;
        label3215:
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        i();
        continue;
        label3248:
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        m();
      }
      i1 = 0;
      while (i1 < 3)
      {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[i1].a(this.jdField_a_of_type_ArrayOfAvau[(i1 + 4)].jdField_a_of_type_JavaUtilArrayList);
        if (AppSetting.jdField_c_of_type_Boolean) {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[i1].setContentDescription(this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[i1].a());
        }
        i1 += 1;
      }
      p();
      new StringBuilder();
      q();
      return;
      label3356:
      paramNearbyPeopleCard = "";
    }
  }
  
  public void a(PicInfo paramPicInfo, RelativeLayout paramRelativeLayout)
  {
    CustomImgView localCustomImgView = (CustomImgView)paramRelativeLayout.getChildAt(0);
    paramRelativeLayout = (ImageView)paramRelativeLayout.getChildAt(1);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130850075);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Int;
    localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Int;
    localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
    localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
    localURLDrawableOptions.mUseMemoryCache = false;
    if (ShortVideoUtils.a())
    {
      localObject = new VideoDrawable.VideoDrawableParams();
      ((VideoDrawable.VideoDrawableParams)localObject).mPlayVideoFrame = true;
      ((VideoDrawable.VideoDrawableParams)localObject).mRequestedFPS = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.n;
      localURLDrawableOptions.mExtraInfo = localObject;
      localCustomImgView.setImageDrawable(URLDrawable.getDrawable(antx.a(paramPicInfo.jdField_d_of_type_JavaLangString), localURLDrawableOptions));
    }
    for (;;)
    {
      if (paramRelativeLayout.getVisibility() == 0) {
        paramRelativeLayout.setVisibility(8);
      }
      return;
      if (!TextUtils.isEmpty(paramPicInfo.jdField_a_of_type_JavaLangString)) {
        localCustomImgView.setImageDrawable(URLDrawable.getDrawable(paramPicInfo.jdField_a_of_type_JavaLangString, localURLDrawableOptions));
      }
    }
  }
  
  void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo.jdField_d_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo.jdField_a_of_type_JavaLangString = paramString1;
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramString1 = URLDrawable.URLDrawableOptions.obtain();
      paramString1.mRequestWidth = aepi.a(43.0F, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources());
      paramString1.mRequestHeight = aepi.a(43.0F, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources());
      paramString1.mFailedDrawable = bdhj.b();
      paramString1.mLoadingDrawable = bdhj.b();
      paramString1.mMemoryCacheKeySuffix = "NearbyVideoRoundIcon";
      paramString1 = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo.jdField_a_of_type_JavaLangString, paramString1);
      paramString1.setDecodeHandler(bcyz.a);
      if (paramString1.getStatus() != 1) {
        paramString1.restartDownload();
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyProfileDisplayTribePanel", 2, "onDownloadVideoHeadFinish, url = " + paramString + ", isSuccess = " + paramBoolean);
    }
    if (paramBoolean)
    {
      paramString = (View)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      if (paramString != null)
      {
        if (!(paramString instanceof RelativeLayout)) {
          break label129;
        }
        paramString = (RelativeLayout)paramString;
        localavti = (avti)paramString.getTag(2131377411);
        if ((localavti == null) || (localavti.jdField_a_of_type_JavaLangObject == null)) {
          break label112;
        }
        a((PicInfo)localavti.jdField_a_of_type_JavaLangObject, paramString);
      }
    }
    label112:
    while (!QLog.isColorLevel())
    {
      avti localavti;
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.e("NearbyProfileDisplayTribePanel", 2, "onDownloadVideoHeadFinish went error .., holder is null or holder.data is null");
      return;
    }
    label129:
    QLog.e("NearbyProfileDisplayTribePanel", 2, "onDownloadVideoHeadFinish went error .., view is not a instance of RelativeLayout");
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Charm", 2, "hideCharmChanged() showAnim=" + paramBoolean);
    }
    TextView localTextView = (TextView)this.jdField_g_of_type_AndroidWidgetRelativeLayout.findViewById(2131365340);
    if (paramBoolean)
    {
      int i1 = localTextView.getWidth();
      int i2 = localTextView.getHeight();
      ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, i1 / 2, i2 / 2);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      AnimationSet localAnimationSet = new AnimationSet(true);
      localAnimationSet.setInterpolator(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 17432584);
      localAnimationSet.addAnimation(localScaleAnimation);
      localAnimationSet.addAnimation(localAlphaAnimation);
      localAnimationSet.setDuration(1500L);
      localAnimationSet.setFillAfter(true);
      localAnimationSet.setFillBefore(false);
      localTextView.setAnimation(localAnimationSet);
      localAnimationSet.start();
      return;
    }
    localTextView.setVisibility(4);
  }
  
  public void a(boolean paramBoolean, int paramInt, List<ShowExternalTroop> paramList)
  {
    if ((!paramBoolean) || (paramList == null) || (paramList.size() == 0) || (paramInt != 0)) {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_Awqq != null)) {
        this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.removeBuisEntry(this.jdField_a_of_type_Awqq);
      }
    }
    do
    {
      return;
      paramList = (ShowExternalTroop)paramList.get(0);
      this.jdField_f_of_type_JavaLangString = paramList.troopUin;
      this.jdField_a_of_type_Awqq = new awqq();
      this.jdField_a_of_type_Awqq.jdField_a_of_type_Int = 1024;
      this.jdField_a_of_type_Awqq.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131696640);
      this.jdField_a_of_type_Awqq.jdField_c_of_type_JavaLangString = paramList.troopName;
      this.jdField_a_of_type_Awqq.jdField_a_of_type_JavaLangString = paramList.strFaceUrl;
    } while ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) || (this.jdField_a_of_type_Awqq.jdField_c_of_type_JavaLangString == null));
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.addOrUpdateBuisEntry(this.jdField_a_of_type_Awqq);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2)
    {
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_join", "", "person_data", "exp", 0, 0, this.jdField_f_of_type_JavaLangString, "1", "", "");
      return;
    }
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_join", "", "person_data", "exp", 0, 0, this.jdField_f_of_type_JavaLangString, "0", "", "");
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
    {
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = "https://gamecenter.qq.com/gamecenter/index/recent_play.html";
      }
      paramString = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, GameCenterActivity.class);
      paramString.putExtra("url", nbv.a(str, "plat=qq&tt=1&_wv=3&qappid=" + AppSetting.a() + "&osv=" + Build.VERSION.RELEASE + "&vuin=" + auwx.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString) + "&vname=" + this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString + "&bn=" + paramBoolean));
      paramString.putExtra("big_brother_source_key", "biz_src_zf_games");
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(paramString);
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      this.jdField_l_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_k_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_i_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_f_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_f_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    label181:
    label349:
    label379:
    int i1;
    label412:
    label478:
    label742:
    label1275:
    do
    {
      return;
      nearby.Cmd0x1RspBody localCmd0x1RspBody = new nearby.Cmd0x1RspBody();
      int i2;
      try
      {
        localCmd0x1RspBody.mergeFrom(paramArrayOfByte);
        localObject1 = localCmd0x1RspBody.bytes_bars_url.get().toStringUtf8();
        this.jdField_d_of_type_JavaLangString = localCmd0x1RspBody.bytes_qunlist_url.get().toStringUtf8();
        this.jdField_a_of_type_ArrayOfByte = localCmd0x1RspBody.bytes_chat_sig.get().toByteArray();
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a().i(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, this.jdField_a_of_type_ArrayOfByte);
        this.w = localCmd0x1RspBody.bool_follow.get();
        if (localCmd0x1RspBody.uint32_if_mask_msg.get() != 1) {
          break label1081;
        }
        bool = true;
        this.jdField_q_of_type_Boolean = bool;
        if (localCmd0x1RspBody.uint32_if_mask_gift.get() != 1) {
          break label1087;
        }
        bool = true;
        this.jdField_r_of_type_Boolean = bool;
        paramArrayOfByte = localCmd0x1RspBody.bytes_feed_wording_title.get().toStringUtf8();
        localObject2 = localCmd0x1RspBody.bytes_feed_wording.get().toStringUtf8();
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramArrayOfByte);
        paramArrayOfByte = apir.b((String)localObject2);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(apir.a(paramArrayOfByte, 16));
        if (localCmd0x1RspBody.bytes_mask_msg_reason.has()) {
          this.jdField_b_of_type_JavaLangString = localCmd0x1RspBody.bytes_mask_msg_reason.get().toStringUtf8();
        }
        if (localCmd0x1RspBody.bytes_mask_gift_reason.has()) {
          this.jdField_c_of_type_JavaLangString = localCmd0x1RspBody.bytes_mask_gift_reason.get().toStringUtf8();
        }
        localObject2 = new ArrayList();
        if ((!localCmd0x1RspBody.rpt_BarInfo_bars.has()) || (localCmd0x1RspBody.rpt_BarInfo_bars.get().size() <= 0)) {
          break label1168;
        }
        this.jdField_f_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        paramArrayOfByte = localCmd0x1RspBody.rpt_BarInfo_bars.get().iterator();
        if (paramArrayOfByte.hasNext())
        {
          localObject3 = (nearby.BarInfo)paramArrayOfByte.next();
          if (((ArrayList)localObject2).size() < 12) {
            break label1093;
          }
        }
        i1 = localCmd0x1RspBody.uint32_bars_num.get();
        if (i1 > 12)
        {
          if (((ArrayList)localObject2).size() <= 11) {
            break label1180;
          }
          ((ArrayList)localObject2).remove(11);
          paramArrayOfByte = new InterestTagInfo();
          paramArrayOfByte.tagName = " ";
          paramArrayOfByte.tagIconUrl = "icon_more_url";
          paramArrayOfByte.tagJumpUrl = "icon_more_url";
          paramArrayOfByte.tagType = 10;
          ((ArrayList)localObject2).add(paramArrayOfByte);
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2) {
            break label1230;
          }
          paramArrayOfByte = "1";
          azqs.b((QQAppInterface)localObject3, "dc00899", "grp_lbs", "", "data_card", "exp_more_tribe", 0, 0, paramArrayOfByte, "", "", "");
        }
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardSavorTagImg.jdField_a_of_type_ComTencentWidgetHorizontalListView == null) {
          break label1237;
        }
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardSavorTagImg.a((List)localObject2);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardSavorTagImg.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131707732) + i1 + ")");
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2) {
          break label1275;
        }
        localObject1 = (nearby.FansInfo)localCmd0x1RspBody.FansInfo_fans.get();
        i1 = ((nearby.FansInfo)localObject1).uint32_fans_num.get();
        i2 = ((nearby.FansInfo)localObject1).uint32_follows_num.get();
        paramArrayOfByte = ((nearby.FansInfo)localObject1).bytes_fans_url.get().toStringUtf8();
        localObject1 = ((nearby.FansInfo)localObject1).bytes_follows_url.get().toStringUtf8();
        this.jdField_f_of_type_AndroidWidgetTextView.setText(alud.a(2131707734) + i1 + alud.a(2131707756));
        this.jdField_g_of_type_AndroidWidgetTextView.setText(alud.a(2131707735) + i2 + alud.a(2131707656));
        this.jdField_k_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new avng(this, paramArrayOfByte));
        this.jdField_l_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new avnh(this, (String)localObject1));
        if ((!localCmd0x1RspBody.rpt_FeedInfo_feeds.has()) || (localCmd0x1RspBody.rpt_FeedInfo_feeds.get().size() <= 0)) {
          break;
        }
        localObject2 = localCmd0x1RspBody.rpt_FeedInfo_feeds.get();
        i2 = ((List)localObject2).size();
        if (((List)localObject2).size() <= 0) {
          break label1322;
        }
        i1 = 0;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        try
        {
          paramArrayOfByte = URLDrawable.getDrawable("" + ((nearby.FeedInfo)((List)localObject2).get(i1)).bytes_pic.get().toStringUtf8(), paramArrayOfByte);
          localObject3 = this.jdField_a_of_type_ArrayOfComTencentImageURLImageView[i1];
          localObject1 = paramArrayOfByte;
          if (paramArrayOfByte == null) {
            localObject1 = new ColorDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131165804));
          }
          ((URLImageView)localObject3).setImageDrawable((Drawable)localObject1);
          this.jdField_a_of_type_ArrayOfComTencentImageURLImageView[i1].setScaleType(ImageView.ScaleType.CENTER_CROP);
          this.jdField_a_of_type_ArrayOfComTencentImageURLImageView[i1].setBackgroundColor(0);
          i1 += 1;
        }
        catch (Exception paramArrayOfByte)
        {
          boolean bool;
          Object localObject2;
          Object localObject3;
          QLog.w("NearbyProfileDisplayTribePanel", 2, paramArrayOfByte.toString());
        }
        paramArrayOfByte = paramArrayOfByte;
        if (!QLog.isColorLevel()) {
          break label1035;
        }
        QLog.w("NearbyProfileDisplayTribePanel", 2, "Cmd0x1RspBody error !:" + paramArrayOfByte);
        this.jdField_l_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_k_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_i_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_f_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_f_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        return;
      }
      if ((i1 < i2) && (i1 < 3))
      {
        paramArrayOfByte = URLDrawable.URLDrawableOptions.obtain();
        paramArrayOfByte.mLoadingDrawable = paramArrayOfByte.mFailedDrawable;
        paramArrayOfByte.mRequestWidth = ((int)(SavorTagImg.jdField_a_of_type_ArrayOfInt[0] * this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Float));
        paramArrayOfByte.mRequestHeight = ((int)(SavorTagImg.jdField_a_of_type_ArrayOfInt[0] * this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Float));
        if (!TextUtils.isEmpty(((nearby.FeedInfo)((List)localObject2).get(i1)).bytes_pic.get().toStringUtf8())) {}
        for (;;)
        {
          bool = false;
          break;
          bool = false;
          break label181;
          InterestTagInfo localInterestTagInfo = new InterestTagInfo();
          localInterestTagInfo.tagName = ((nearby.BarInfo)localObject3).bytes_bar_name.get().toStringUtf8();
          localInterestTagInfo.tagIconUrl = ((nearby.BarInfo)localObject3).bytes_bar_pic.get().toStringUtf8();
          localInterestTagInfo.tagJumpUrl = ((nearby.BarInfo)localObject3).bytes_bar_url.get().toStringUtf8();
          localInterestTagInfo.tagType = 10;
          ((ArrayList)localObject2).add(localInterestTagInfo);
          break label349;
          this.jdField_f_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          break label379;
          if (!QLog.isColorLevel()) {
            break label412;
          }
          QLog.w("NearbyProfileDisplayTribePanel", 2, "buluo num > 12 but the list's size < 12??? buluoNum:" + i1 + "   list.Size:" + ((ArrayList)localObject2).size());
          break label412;
          paramArrayOfByte = "2";
          break label478;
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardSavorTagImg.a(alud.a(2131707690), 10, (List)localObject2, new avnf(this, (String)localObject1));
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardSavorTagImg.setRightArrowVisible(false);
          break label525;
          this.jdField_l_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          this.jdField_k_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          this.jdField_l_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          break label742;
          paramArrayOfByte = null;
        }
      }
      i1 = 2;
      while ((i1 >= i2) && (i1 >= 0))
      {
        this.jdField_a_of_type_ArrayOfComTencentImageURLImageView[i1].setVisibility(8);
        i1 -= 1;
      }
      this.jdField_i_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_f_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      i1 = i2;
      paramArrayOfByte = new avni(this, localCmd0x1RspBody.bytes_feeds_url.get().toStringUtf8());
      this.jdField_i_of_type_AndroidWidgetRelativeLayout.setOnClickListener(paramArrayOfByte);
      this.jdField_f_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramArrayOfByte);
      if (this.jdField_f_of_type_AndroidWidgetLinearLayout.getVisibility() == 0)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2) {
          break label1595;
        }
        paramArrayOfByte = "1";
        azqs.b((QQAppInterface)localObject1, "dc00899", "grp_lbs", "", "data_card", "exp_pub", 0, 0, paramArrayOfByte, "", "" + i1, "");
      }
    } while (this.jdField_f_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0);
    label525:
    label1081:
    label1087:
    label1093:
    label1230:
    label1237:
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
    label1035:
    label1168:
    label1180:
    label1322:
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2) {}
    label1439:
    for (paramArrayOfByte = "1";; paramArrayOfByte = "2")
    {
      azqs.b((QQAppInterface)localObject1, "dc00899", "grp_lbs", "", "data_card", "exp_tribe", 0, 0, paramArrayOfByte, "", "", "");
      return;
      i1 = 0;
      while (i1 < 3)
      {
        this.jdField_a_of_type_ArrayOfComTencentImageURLImageView[i1].setVisibility(8);
        i1 += 1;
      }
      this.jdField_i_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_f_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      i1 = 0;
      break;
      label1595:
      paramArrayOfByte = "2";
      break label1439;
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Apit != null) {
      bool = this.jdField_a_of_type_Apit.jdField_b_of_type_Boolean;
    }
    return bool;
  }
  
  public int b()
  {
    int i11 = 1;
    int i1;
    int i2;
    label21:
    int i3;
    label30:
    int i4;
    label40:
    int i5;
    label50:
    int i6;
    label60:
    int i7;
    label70:
    int i8;
    label80:
    int i9;
    label90:
    int i10;
    if (this.jdField_l_of_type_Boolean)
    {
      i1 = 1;
      if (!this.jdField_k_of_type_Boolean) {
        break label169;
      }
      i2 = 1;
      if (!this.jdField_j_of_type_Boolean) {
        break label174;
      }
      i3 = 1;
      if (!this.jdField_i_of_type_Boolean) {
        break label179;
      }
      i4 = 1;
      if (!this.jdField_h_of_type_Boolean) {
        break label185;
      }
      i5 = 1;
      if (!this.jdField_g_of_type_Boolean) {
        break label191;
      }
      i6 = 1;
      if (!this.jdField_f_of_type_Boolean) {
        break label197;
      }
      i7 = 1;
      if (!this.jdField_e_of_type_Boolean) {
        break label203;
      }
      i8 = 1;
      if (!this.jdField_d_of_type_Boolean) {
        break label209;
      }
      i9 = 1;
      if (!this.jdField_c_of_type_Boolean) {
        break label215;
      }
      i10 = 1;
      label100:
      if (!this.jdField_b_of_type_Boolean) {
        break label221;
      }
    }
    for (;;)
    {
      return i10 << 1 | i1 << 10 | i2 << 9 | i3 << 8 | i4 << 7 | i5 << 6 | i6 << 5 | i7 << 4 | i8 << 3 | i9 << 2 | i11 << 0;
      i1 = 0;
      break;
      label169:
      i2 = 0;
      break label21;
      label174:
      i3 = 0;
      break label30;
      label179:
      i4 = 0;
      break label40;
      label185:
      i5 = 0;
      break label50;
      label191:
      i6 = 0;
      break label60;
      label197:
      i7 = 0;
      break label70;
      label203:
      i8 = 0;
      break label80;
      label209:
      i9 = 0;
      break label90;
      label215:
      i10 = 0;
      break label100;
      label221:
      i11 = 0;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Avpv != null) {
      this.jdField_a_of_type_Avpv.a(10);
    }
    bfod.b(this.jdField_a_of_type_Bfoj);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(6);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uRoomid != 0L)) {
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "content_timer", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, "", "yes", "android");
    }
  }
  
  public void b(NearbyPeopleCard paramNearbyPeopleCard)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.vGiftInfo = paramNearbyPeopleCard.vGiftInfo;
  }
  
  void b(boolean paramBoolean)
  {
    boolean bool1;
    boolean bool2;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.shouldShowLikeBtn()))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setHeartLayout(this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2)
      {
        bool1 = true;
        NearbyCardVoteView localNearbyCardVoteView = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView;
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bVoted == 0) {
          break label127;
        }
        bool2 = true;
        label67:
        localNearbyCardVoteView.a(bool1, bool2, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.likeCount, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.likeCountInc, null, true, paramBoolean, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.praiseList);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setOnClickListener(this);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Apit != null) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.jdField_b_of_type_Boolean = false;
      }
      return;
      bool1 = false;
      break;
      label127:
      bool2 = false;
      break label67;
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setVisibility(4);
    }
  }
  
  boolean b()
  {
    return (bdeu.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_Int != 3000) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_Int != 2);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.a(true);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Boolean) {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
    }
    for (;;)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
      ((NearbyPeopleCard)localObject).likeCount += 1;
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
      ((NearbyPeopleCard)localObject).bAvailVoteCnt = ((short)(((NearbyPeopleCard)localObject).bAvailVoteCnt - 1));
      this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bVoted = 1;
      if (!this.jdField_a_of_type_Bhtd.hasMessages(1))
      {
        localObject = Message.obtain();
        ((Message)localObject).what = 1;
        this.jdField_a_of_type_Bhtd.sendMessageDelayed((Message)localObject, 2000L);
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_q_of_type_Boolean = true;
      b(paramBoolean);
      return;
      if (paramBoolean) {
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
      } else {
        this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
      }
    }
  }
  
  public void d() {}
  
  protected void d(boolean paramBoolean)
  {
    if ((this.jdField_r_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Boolean))
    {
      if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.jdField_c_of_type_JavaLangString, 0).b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getTitleBarHeight());
      }
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    NearbyPeopleProfileActivity.m += 1;
    String str = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
    Object localObject2 = bdeu.a(a());
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    int i1;
    if (Friends.isValidUin(str))
    {
      localObject2 = auwx.a(str);
      str = ((String)localObject1).toLowerCase();
      if (d() == 10002)
      {
        i1 = 6;
        if (!paramBoolean) {
          break label317;
        }
        localObject1 = "near.card.like";
        label138:
        localObject1 = String.format("https://imgcache.qq.com/club/client/flower/release/html/index.html?strangerUin=%s&sign=%s&sourceType=%d&ADTAG=%s&groupCode=%s&_wv=2147347&_bid=2050", new Object[] { localObject2, str, Integer.valueOf(i1), localObject1, "" });
        localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("portraitOnly", true);
        ((Intent)localObject2).putExtra("url", (String)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject2);
        i1 = bdda.c(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int);
        if (!NearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.j)) {
          break label342;
        }
        i1 = 6;
      }
    }
    label317:
    label342:
    for (;;)
    {
      azqs.b(null, "dc00899", "grp_lbs", "", "data_card", "clk_gift", 0, 0, "", "", "", "");
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80052BA", "0X80052BA", i1, 0, "", "", "", "");
      return;
      i1 = 1;
      break;
      localObject1 = "near.card.s";
      break label138;
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131693776));
      return;
    }
  }
  
  public void e() {}
  
  public void f()
  {
    if (this.jdField_a_of_type_Apit != null) {
      this.jdField_a_of_type_Apit.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.a(false);
    }
    if (this.jdField_a_of_type_Bhtd.hasMessages(1))
    {
      this.jdField_a_of_type_Bhtd.removeMessages(1);
      w();
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      bdbk localbdbk = (bdbk)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localbdbk != null) {
        localbdbk.a();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a().jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a().jdField_a_of_type_JavaUtilArrayList.clear();
    }
    this.jdField_a_of_type_Auwu.b();
  }
  
  public void h()
  {
    boolean bool2 = true;
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.shouldShowLikeBtn()) && (!this.jdField_p_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setHeartLayout(this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2)
      {
        bool1 = true;
        NearbyCardVoteView localNearbyCardVoteView = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView;
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bVoted == 0) {
          break label132;
        }
        label73:
        localNearbyCardVoteView.a(bool1, bool2, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.likeCount, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.likeCountInc, null, false, false, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.praiseList);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setOnClickListener(this);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Apit != null) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.jdField_b_of_type_Boolean = false;
      }
      return;
      bool1 = false;
      break;
      label132:
      bool2 = false;
      break label73;
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setVisibility(4);
    }
  }
  
  public void i()
  {
    apib.c(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getClass().getSimpleName(), new Object[] { "card godflag is `", Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag), " sayhello flag is ", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.sayHelloFlag) });
    Button localButton;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.lUserFlag & 0x800) != 0L)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(0).setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(1).setVisibility(8);
      if (!this.jdField_o_of_type_Boolean)
      {
        b(2, 8);
        if ((this.w) || (this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(2).getVisibility() == 0)) {
          break label702;
        }
        localButton = (Button)this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(1).findViewById(2131379107);
        localButton.setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131166934));
        localButton.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130839108));
      }
    }
    for (;;)
    {
      if ((this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(1).getVisibility() != 0) && (this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(2).getVisibility() != 0))
      {
        localButton = (Button)this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(0).findViewById(2131379107);
        localButton.setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131166934));
        localButton.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130839108));
      }
      return;
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break;
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 42) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 14) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 86) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 87) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 88) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 79) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 75) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 89)) {
        if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uRoomid == 0L) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.shouldShowSendMsg()))
        {
          b(0, 36);
          label441:
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uRoomid != 0L) {
            break label608;
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 75) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b != null) || (b())) {
            break label565;
          }
          this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(2).setVisibility(8);
        }
      }
      for (;;)
      {
        b(1, 60);
        break;
        b(2, 40);
        break label441;
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uRoomid == 0L)
        {
          this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(0).setVisibility(8);
          break label441;
        }
        this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(2).setVisibility(8);
        break label441;
        label565:
        if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.shouldShowSendMsg()) && (!this.jdField_o_of_type_Boolean))
        {
          b(2, 8);
        }
        else
        {
          this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(2).setVisibility(8);
          continue;
          label608:
          if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 75) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b == null) && (!b())) {
            this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(0).setVisibility(8);
          } else if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.shouldShowSendMsg()) && (!this.jdField_o_of_type_Boolean)) {
            b(0, 8);
          } else {
            this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(0).setVisibility(8);
          }
        }
      }
      label702:
      ((Button)this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(1).findViewById(2131379107)).setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130839147));
    }
  }
  
  public void j()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_h_of_type_Boolean) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bVideoHeadUrl)))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.setVisibility(0);
      if (this.jdField_a_of_type_Avnj == null)
      {
        this.jdField_a_of_type_Avnj = new avnj(this, this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager);
        this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.setAdapter(this.jdField_a_of_type_Avnj);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_h_of_type_Boolean)
      {
        this.jdField_a_of_type_Avnj.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList);
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 3) {
          break label203;
        }
      }
    }
    label203:
    for (Object localObject = "2";; localObject = "1")
    {
      azqs.b(null, "dc00899", "grp_lbs", "", "data_card", "exp_head", 0, 0, (String)localObject, "", "", "");
      return;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bVideoHeadUrl)) {
        break;
      }
      localObject = new PicInfo();
      ((PicInfo)localObject).jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bVideoHeadUrl;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localObject);
      this.jdField_a_of_type_Avnj.a(localArrayList);
      break;
      this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.setVisibility(8);
      break;
    }
  }
  
  public void k()
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.l == 640) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.l == 0)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_b_of_type_JavaLangString)) && (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_h_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.l, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_b_of_type_JavaLangString, false);
    }
  }
  
  public void l()
  {
    bdeq.a(true);
    int i1 = d();
    if (b())
    {
      localIntent = new Intent();
      localIntent.putExtra("finchat", true);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.setResult(0, localIntent);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.finish();
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) || (bdnn.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin)))
    {
      Intent localIntent;
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, i1);
  }
  
  void m()
  {
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public void n()
  {
    Oidb_0x66b.ReqBody localReqBody = new Oidb_0x66b.ReqBody();
    Object localObject = new oidb_0x5eb.ReqBody();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.c())));
    ((oidb_0x5eb.ReqBody)localObject).rpt_uint64_uins.set(localArrayList);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_nick.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_stranger_nick.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_gender.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_god_flag.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_age.set(1);
    localReqBody.bytes_reqbody_5eb.set(ByteStringMicro.copyFrom(((oidb_0x5eb.ReqBody)localObject).toByteArray()));
    localReqBody.uint32_req_likeinfo.set(1);
    localReqBody.uint32_req_pansocialinfo.set(1);
    localReqBody.uint32_req_giftinfo.set(1);
    localReqBody.uint32_req_configinfo.set(1);
    localReqBody.uint32_req_visitor.set(3);
    localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1643);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).str_client_version.set(AppSetting.f());
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    mzy.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, new avnc(this), ((oidb_sso.OIDBSSOPkg)localObject).toByteArray(), "OidbSvc.0x66b");
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    if ((localObject1 != null) && ((localObject1 instanceof awor)))
    {
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800482E", "0X800482E", 0, 0, "", "", "", "");
      paramView = (awor)localObject1;
      if (QLog.isColorLevel()) {
        QLog.i("NearbyProfileDisplayTribePanel", 2, "click  data.nType= [" + paramView.jdField_a_of_type_Int + "]");
      }
      switch (paramView.jdField_a_of_type_Int)
      {
      }
    }
    for (;;)
    {
      return;
      if ((paramView.jdField_a_of_type_JavaLangObject instanceof awqq))
      {
        paramView = (awqq)paramView.jdField_a_of_type_JavaLangObject;
        if (!bdnn.a(paramView.jdField_d_of_type_JavaLangString))
        {
          localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
          ((Intent)localObject1).putExtra("portraitOnly", true);
          if (!bdnn.a(paramView.jdField_d_of_type_JavaLangString)) {
            break label388;
          }
          paramView = "";
          label312:
          ((Intent)localObject1).putExtra("url", paramView);
        }
      }
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject1);
        label331:
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050CC", "0X80050CC", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        return;
        label388:
        paramView = paramView.jdField_d_of_type_JavaLangString;
        break label312;
        if ((paramView.jdField_a_of_type_JavaLangObject instanceof Object[]))
        {
          paramView = (Object[])paramView.jdField_a_of_type_JavaLangObject;
          a(((Boolean)paramView[0]).booleanValue(), (String)paramView[1]);
        }
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050CA", "0X80050CA ", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        return;
        if ((paramView.jdField_a_of_type_JavaLangObject instanceof awqq))
        {
          paramView = (awqq)paramView.jdField_a_of_type_JavaLangObject;
          if (!bdnn.a(paramView.jdField_d_of_type_JavaLangString)) {
            a(paramView.jdField_d_of_type_JavaLangString);
          }
        }
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050CB", "0X80050CB ", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        return;
        Object localObject2;
        if ((paramView.jdField_a_of_type_JavaLangObject instanceof awqq))
        {
          localObject1 = (awqq)paramView.jdField_a_of_type_JavaLangObject;
          if (!bdnn.a(((awqq)localObject1).jdField_d_of_type_JavaLangString))
          {
            localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
            ((Intent)localObject2).putExtra("url", ((awqq)localObject1).jdField_d_of_type_JavaLangString);
            ((Intent)localObject2).putExtra("hide_operation_bar", true);
            ((Intent)localObject2).putExtra("hide_more_button", true);
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject2);
          }
        }
        if (28 != paramView.jdField_a_of_type_Int) {
          continue;
        }
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050CD", "0X80050CD", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        return;
        if (!(paramView.jdField_a_of_type_JavaLangObject instanceof awqq)) {
          continue;
        }
        paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, ShowExternalTroopListActivity.class);
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {}
        for (boolean bool = true;; bool = false)
        {
          paramView.putExtra("isHost", bool);
          paramView.putExtra("dest_uin_str", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(paramView);
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2) {
            break;
          }
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050CF", "0X80050CF", 0, 0, this.jdField_f_of_type_JavaLangString, "1", "", "");
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 3) {
          continue;
        }
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050CF", "0X80050CF", 0, 0, this.jdField_f_of_type_JavaLangString, "0", "", "");
        return;
        if (!(paramView.jdField_a_of_type_JavaLangObject instanceof awqq)) {
          continue;
        }
        paramView = (awqq)paramView.jdField_a_of_type_JavaLangObject;
        localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", paramView.jdField_d_of_type_JavaLangString + "&_webviewtype=1");
        ((Intent)localObject1).putExtra("hide_operation_bar", true);
        ((Intent)localObject1).putExtra("hide_more_button", true);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject1);
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8005102", "0X8005102", 0, 0, "", "", "", "");
        return;
        label1145:
        label1150:
        String str1;
        if (this.w)
        {
          paramView = "clk_followed";
          azqs.b(null, "dc00899", "grp_lbs", "", "data_card", paramView, 0, 0, "", "", "", "");
          ((auul)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(106)).d.put(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, Integer.valueOf(1));
          paramView = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
          bool = NearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.j);
          if (!bool) {
            break label1207;
          }
          paramView = "1";
          if (!bool) {
            break label1228;
          }
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
          str1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin;
          if (!this.w) {
            break label1241;
          }
        }
        label1207:
        label1228:
        label1241:
        for (localObject1 = "2";; localObject1 = "1")
        {
          alxp.a((QQAppInterface)localObject2, str1, paramView, (String)localObject1, 1, new avmp(this));
          return;
          paramView = "clk_follow";
          break;
          if (this.jdField_o_of_type_Boolean)
          {
            paramView = "6";
            break label1145;
          }
          paramView = "2";
          break label1145;
          if (this.jdField_o_of_type_Boolean) {
            break label1150;
          }
          break label1150;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin)))
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname;
          ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 0, paramView, (String)localObject1, null, true, null, true, true, null, "from_internal");
          return;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("Q.nearby_people_card.", 2, "mCard == null , or mCard.uin is Empty, " + this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Boolean);
        return;
        if ((this.jdField_q_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Boolean))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.nearby.tribeAppDownload", 2, "sendMsgBtnClick, isSendMsgBtnDownloadAppOpen=" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isSendMsgBtnDownloadAppOpen + ", sendMsgBtnDownloadAppTips:" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.sendMsgBtnDownloadAppTips + ", tribeAppDownloadPageUrl=" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tribeAppDownloadPageUrl);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isSendMsgBtnDownloadAppOpen) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.sendMsgBtnDownloadAppTips)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tribeAppDownloadPageUrl))) {
            auul.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.sendMsgBtnDownloadAppTips, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tribeAppDownloadPageUrl, 1);
          }
          for (;;)
          {
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "msg_fail", 0, 0, "", "", "", "");
            return;
            if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
              QQToast.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.jdField_b_of_type_JavaLangString, 0).b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getTitleBarHeight());
            }
          }
        }
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "msg_suc", 0, 0, "", "", "", "");
        this.jdField_d_of_type_Boolean = true;
        l();
        azqs.b(null, "dc00899", "grp_lbs", "", "data_card", "clk_msg", 0, 0, "", "", "", "");
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
        int i1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin != null)) {}
        for (paramView = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin;; paramView = "")
        {
          azqs.b((QQAppInterface)localObject1, "CliOper", "", "", "0X8004826", "0X8004826", i1, 0, paramView, "", "", "");
          if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 75) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 76)) {
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004944", "0X8004944", 0, 0, "", "", "", "");
          }
          NearbyPeopleProfileActivity.m = 0;
          if (!ProfileActivity.c(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int)) {
            break;
          }
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800523D", "0X800523D", 0, 0, "", "", "", "");
          return;
        }
        if (!ProfileActivity.d(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int)) {
          continue;
        }
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8005CAA", "0X8005CAA", 0, 0, "", "", "", "");
        return;
        d(false);
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app == null) {
          continue;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.iIsGodFlag == 1) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 0))
        {
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800528A", "0X800528A", 0, 0, "", "", "", "");
          return;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.iIsGodFlag != 1) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 1)) {
          continue;
        }
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800528B", "0X800528B", 0, 0, "", "", "", "");
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_o_of_type_Boolean)
        {
          apib.c("nearbyprofilecard", new Object[] { "have click sayhello, wating for resp" });
          return;
        }
        paramView = (auxh)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a(60);
        if (paramView == null) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_o_of_type_Boolean = true;
        if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 17) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 18) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 19))
        {
          i1 = 8;
          label2128:
          i2 = i1;
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.iIsGodFlag == 1) {
            if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 0) {
              break label2215;
            }
          }
        }
        label2215:
        for (int i2 = 1;; i2 = 2)
        {
          i2 = i1 | i2;
          paramView.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin), i2, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b);
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_AndroidOsHandler == null) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(204, 1000L);
          return;
          i1 = 4;
          break label2128;
        }
        if (!(paramView.jdField_a_of_type_JavaLangObject instanceof awqq)) {
          continue;
        }
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80055CA", "0X80055CA", 0, 0, "", "", "", "");
        paramView = (awqq)paramView.jdField_a_of_type_JavaLangObject;
        localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", paramView.jdField_d_of_type_JavaLangString);
        ((Intent)localObject1).putExtra("hide_operation_bar", true);
        ((Intent)localObject1).putExtra("hide_more_button", true);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject1);
        return;
        if (!(paramView.jdField_a_of_type_JavaLangObject instanceof awqq)) {
          continue;
        }
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8005D14", "0X8005D14", 0, 0, "", "", "", "");
        paramView = (awqq)paramView.jdField_a_of_type_JavaLangObject;
        localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", paramView.jdField_d_of_type_JavaLangString);
        ((Intent)localObject1).putExtra("hide_operation_bar", true);
        ((Intent)localObject1).putExtra("hide_more_button", true);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject1);
        return;
        if (!(paramView.jdField_a_of_type_JavaLangObject instanceof awqq)) {
          continue;
        }
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "0X8006E05", "0X8006E05", 1, 0, new String[0]);
        paramView = (awqq)paramView.jdField_a_of_type_JavaLangObject;
        localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", paramView.jdField_d_of_type_JavaLangString);
        ((Intent)localObject1).putExtra("hide_operation_bar", true);
        ((Intent)localObject1).putExtra("hide_more_button", true);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject1);
        return;
        if ((this.jdField_a_of_type_Avpv == null) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null)) {
          continue;
        }
        if (!bdin.d(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity))
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 2131692398, 0).b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDimensionPixelSize(2131298914));
          return;
        }
        if (bdiv.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, "com.guagua.qiqi"))
        {
          this.jdField_a_of_type_Avpv.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uRoomid);
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "click_bootstrap", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, "", "yes", "android");
          return;
        }
        if (this.jdField_a_of_type_Int == 1)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton != null) {
            this.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setText(2131699686);
          }
          this.jdField_a_of_type_Avpv.a(3);
          this.jdField_a_of_type_Int = 2;
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_pause", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, "", "yes", "android");
          return;
        }
        if (bdin.h(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity))
        {
          if (this.jdField_m_of_type_Boolean)
          {
            bdgm.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 230, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131699250), this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131699249), 0, 2131699687, new avmq(this), null).show();
            this.jdField_m_of_type_Boolean = false;
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_trigger", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, "", "yes", "android");
          }
          for (;;)
          {
            this.jdField_a_of_type_Avpv.a(2);
            if ((this.jdField_a_of_type_Int != 2) && (this.jdField_a_of_type_Int != 0)) {
              break;
            }
            this.jdField_a_of_type_Int = 1;
            return;
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_goon", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, "", "yes", "android");
          }
        }
        if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 0))
        {
          bdgm.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 230, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131699250), this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131699248), this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener).show();
          this.jdField_a_of_type_Int = 1;
          return;
        }
        this.jdField_a_of_type_Avpv.a(2);
        return;
        if (paramView == this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView)
        {
          if (2 == this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int)
          {
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "clk_list", 0, 0, "", "", "", "");
            if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
            {
              paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, VisitorsActivity.class);
              if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null)
              {
                i1 = 0;
                localObject1 = new Bundle();
                ((Bundle)localObject1).putLong("toUin", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin()).longValue());
                ((Bundle)localObject1).putLong("totalVoters", i1);
                ((Bundle)localObject1).putBoolean("isStartedByProfileCard", true);
                ((Bundle)localObject1).putBoolean("votersOnly", true);
                if (i1 <= 0) {
                  break label3432;
                }
              }
              label3432:
              for (bool = true;; bool = false)
              {
                ((Bundle)localObject1).putBoolean("hasVoters", bool);
                ((Bundle)localObject1).putBoolean("extra_show_rank", true);
                ((Bundle)localObject1).putInt("frome_where", 4);
                paramView.putExtras((Bundle)localObject1);
                this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(paramView);
                auwd.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app);
                if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null)
                {
                  this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.likeCountInc = 0;
                  h();
                  this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a(new NearbyProfileDisplayTribePanel.20(this));
                }
                if (this.jdField_a_of_type_Apit != null) {
                  this.jdField_a_of_type_Apit.jdField_b_of_type_Boolean = true;
                }
                if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("IS_NEARBY_REDDOT_INCOME", false)) {
                  azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8005249", "0X8005249", 0, 0, "", "", "", "");
                }
                azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800657A", "0X800657A", 2, 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
                localObject1 = "2";
                paramView = (View)localObject1;
                if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.a != null)
                {
                  paramView = (View)localObject1;
                  if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.a.getVisibility() == 0) {
                    paramView = "1";
                  }
                }
                azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00898", "", "", "0X8007610", "0X8007610", 2, 0, paramView, "", "", "");
                return;
                i1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.likeCount;
                break;
              }
            }
            localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
            if (d() == 10002) {}
            for (paramView = "6";; paramView = "1")
            {
              ((Intent)localObject1).putExtra("url", this.jdField_e_of_type_JavaLangString + "&SOURCETYPE=" + paramView + "&SIGN=" + a() + "&UIN=" + this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getAppInterface().getCurrentAccountUin());
              this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject1);
              break;
            }
          }
          if (3 != this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int) {
            continue;
          }
          this.jdField_b_of_type_Boolean = true;
          localObject1 = new HashMap();
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin();
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null)
          {
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131693646));
            ((HashMap)localObject1).put("param_FailCode", "-210");
            azri.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getApp()).a((String)localObject2, "profileCardSendFavorite", false, 0L, 0L, (HashMap)localObject1, "", false);
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.i("NearbyProfileDisplayTribePanel", 2, "mCard is null,vote failed !");
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.i("NearbyProfileDisplayTribePanel", 2, "Click Vote View, mCard.bAvailVoteCnt = " + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bAvailVoteCnt + ",mCard.bHaveVotedCnt = " + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bHaveVotedCnt + ",mCard.strVoteLimitedNotice = " + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.strVoteLimitedNotice);
          }
          label3757:
          label3779:
          int i3;
          label3884:
          label4028:
          String str2;
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bAvailVoteCnt <= 0)
          {
            i1 = 1;
            if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bHaveVotedCnt > 0) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bAvailVoteCnt > 0)) {
              break label4254;
            }
            i2 = 1;
            if (QLog.isColorLevel()) {
              QLog.d("NearbyLikeLimitManager", 2, "Profile->onClickVote, uin=" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin + ", isFriend=" + this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Boolean + ", bAvailVoteCnt=" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bAvailVoteCnt + ", bHaveVotedCnt=" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bHaveVotedCnt);
            }
            if (!NearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.j)) {
              break label4259;
            }
            i3 = 510;
            if ((i1 != 0) || (i2 != 0)) {
              break label4435;
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Auxh == null) || (!bdin.d(BaseApplication.getContext()))) {
              break label4280;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Boolean) {
              break label4267;
            }
            ((auvr)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(207)).a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, new avms(this), i3 + "");
            label3986:
            str1 = "" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin;
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 3) {
              break label4412;
            }
            paramView = "2";
            str2 = i3 + "";
            if (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Boolean) {
              break label4419;
            }
            localObject1 = "1";
            label4065:
            if (!this.u) {
              break label4427;
            }
          }
          label4254:
          label4259:
          label4267:
          label4280:
          label4412:
          label4419:
          label4427:
          for (localObject2 = "2";; localObject2 = "1")
          {
            azqs.b(null, "dc00899", "grp_lbs", str1, "data_card", "like_head", 0, 0, paramView, str2, (String)localObject1, (String)localObject2);
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004825", "0X8004825", c(), 0, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, "", "", "");
            if (ProfileActivity.c(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int)) {
              azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8005241", "0X8005241", 0, 0, "", "", "", "");
            }
            if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.iIsGodFlag != 1) {
              break;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 0) {
              break label4775;
            }
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800528C", "0X800528C", 1, 0, "", "", "", "");
            return;
            i1 = 0;
            break label3757;
            i2 = 0;
            break label3779;
            i3 = 509;
            break label3884;
            c(true);
            this.u = true;
            break label3986;
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Auxh != null)
            {
              ((HashMap)localObject1).put("param_FailCode", "-203");
              azri.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getApp()).a((String)localObject2, "profileCardSendFavorite", true, 0L, 0L, (HashMap)localObject1, "", false);
              this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131721507));
              break label3986;
            }
            ((HashMap)localObject1).put("param_FailCode", "-204");
            azri.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getApp()).a((String)localObject2, "profileCardSendFavorite", false, 0L, 0L, (HashMap)localObject1, "", false);
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131693646));
            break label3986;
            paramView = "1";
            break label4028;
            localObject1 = "2";
            break label4065;
          }
          label4435:
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 0)
          {
            paramView = alud.a(2131707746);
            label4452:
            if (!this.jdField_s_of_type_Boolean)
            {
              if (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Boolean) {
                break label4646;
              }
              paramView = bdgm.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 230, null, alud.a(2131707762), "", alud.a(2131707706), new avmt(this), null);
              paramView.show();
              this.jdField_s_of_type_Boolean = true;
              paramView.setOnDismissListener(new avmw(this));
            }
            azqs.b(null, "dc00899", "grp_lbs", "", "data_like", "exp_toast", 0, 0, "", "", "", "");
            if (i2 == 0) {
              break label4721;
            }
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8006579", "0X8006579", 2, 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int)), "", "", "");
          }
          for (;;)
          {
            label4504:
            azri.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getApp()).a((String)localObject2, "profileCardSendFavorite", false, 0L, 0L, (HashMap)localObject1, "", false);
            break;
            paramView = alud.a(2131707664);
            break label4452;
            label4646:
            paramView = bdgm.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 230, null, alud.a(2131707649) + paramView + alud.a(2131707736), alud.a(2131707698), alud.a(2131707722), new avmu(this), new avmv(this));
            break label4504;
            label4721:
            if (i1 != 0) {
              azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8006578", "0X8006578", 2, 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int)), "", "", "");
            }
          }
          label4775:
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 1) {
            continue;
          }
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800528D", "0X800528D", 1, 0, "", "", "", "");
          return;
        }
        if (paramView == this.jdField_a_of_type_ComTencentWidgetCustomImgView)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2)
          {
            paramView = (Boolean)paramView.getTag();
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a(100L);
            if ((paramView != null) && (!paramView.booleanValue())) {
              this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_AndroidOsHandler.postDelayed(new NearbyProfileDisplayTribePanel.26(this), 300L);
            }
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050C9", "0X80050C9", 0, 0, "", "", "", "");
          }
          while (ProfileActivity.c(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int))
          {
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8005240", "0X8005240", 0, 0, "", "", "", "");
            return;
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 3)
            {
              localObject1 = new PicInfo();
              ((PicInfo)localObject1).jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a(32, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin), 200);
              if (QLog.isColorLevel()) {
                QLog.e("Q.nearby_people_card.", 2, "on mode guest small head clicked: uin is: " + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin + " local path is: " + ((PicInfo)localObject1).jdField_c_of_type_JavaLangString);
              }
              paramView = zjc.a(paramView);
              this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a((PicInfo)localObject1, paramView);
            }
          }
        }
        if (paramView == this.jdField_g_of_type_AndroidWidgetRelativeLayout)
        {
          this.jdField_i_of_type_Boolean = true;
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 3)
          {
            paramView = auwx.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            paramView = "https://buluo.qq.com/mobile/my_heart.html?from=zlk" + "&strangerUin=" + paramView;
            this.jdField_a_of_type_Boolean = true;
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 3) {
              break label5355;
            }
            localObject1 = "2";
            label5180:
            azqs.b(null, "dc00899", "grp_lbs", "", "rank_data", "clk_rank", 0, 0, (String)localObject1, "", "", "");
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 3) {
              break label5363;
            }
          }
          label5355:
          label5363:
          for (localObject1 = "2";; localObject1 = "1")
          {
            azqs.b(null, "dc00899", "grp_lbs", "", "data_card", "clk_rank", 0, 0, (String)localObject1, "", "", "");
            localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
            ((Intent)localObject1).putExtra("url", paramView);
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject1);
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2) {
              break label5371;
            }
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80052AC", "0X80052AC", 0, 0, "", "", "", "");
            return;
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2) {
              this.jdField_a_of_type_Boolean = true;
            }
            paramView = "https://buluo.qq.com/mobile/my_heart.html?from=zlk";
            break;
            localObject1 = "1";
            break label5180;
          }
          label5371:
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 3) {
            continue;
          }
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80052AD", "0X80052AD", 0, 0, "", "", "", "");
          return;
        }
        if (paramView == this.jdField_f_of_type_AndroidWidgetImageView)
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin();
          if ((!Friends.isValidUin(paramView)) || (!Friends.isValidUin(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin))) {
            continue;
          }
          bool = paramView.equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
          if (bool)
          {
            i1 = 0;
            if (!bool) {
              break label5553;
            }
          }
          for (;;)
          {
            paramView = String.format("https://ti.qq.com/paihangbanggl/index.html?_wv=1027&isguest=%d&uin=%s", new Object[] { Integer.valueOf(i1), paramView });
            localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
            ((Intent)localObject1).putExtra("portraitOnly", true);
            ((Intent)localObject1).putExtra("url", paramView);
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject1);
            return;
            i1 = 1;
            break;
            label5553:
            paramView = "";
          }
        }
        if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
        {
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "clk_edit", 0, 0, "", "", "", "");
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_i_of_type_Int == 0)
          {
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b();
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a(300L);
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004B38", "0X8004B38", 0, 0, "", "", "", "");
          return;
        }
        if ((paramView == this.jdField_g_of_type_AndroidWidgetLinearLayout) || (paramView != this.jdField_h_of_type_AndroidWidgetLinearLayout)) {
          continue;
        }
        return;
      }
      catch (SecurityException paramView)
      {
        break label331;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avmf
 * JD-Core Version:    0.7.0.1
 */