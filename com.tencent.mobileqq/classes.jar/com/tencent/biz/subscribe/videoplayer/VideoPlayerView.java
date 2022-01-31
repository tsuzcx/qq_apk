package com.tencent.biz.subscribe.videoplayer;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StVideo;
import alud;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.TextView;
import aofm;
import bdnn;
import bnle;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.event.CommentListShowStateEvent;
import com.tencent.biz.subscribe.event.FollowUpdateEvent;
import com.tencent.biz.subscribe.event.SharePanelShowStateEvent;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import com.tencent.biz.subscribe.fragments.SubscribeVideoDetailFragment;
import com.tencent.biz.subscribe.widget.VideoNextFeedsView;
import com.tencent.biz.subscribe.widget.textview.FollowTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.NetworkManager.NetStatusListener;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenManager;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnSeekCompleteListener;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import rdm;
import vwa;
import vwb;
import vwc;
import vwd;
import vwe;
import vwf;
import vxe;
import ybm;
import ybn;
import yiw;
import yiy;
import ymv;
import ymw;
import ymx;
import ymz;
import yna;
import ynb;
import ync;
import ynd;
import yne;
import ynf;
import yng;
import ynh;
import yni;
import ynj;
import ynk;
import ynl;
import ynm;
import ynn;
import yno;
import ynp;
import ynq;
import yyw;
import zaj;

public class VideoPlayerView
  extends FrameLayout
  implements NetworkManager.NetStatusListener, TVK_IMediaPlayer.OnSeekCompleteListener, vwb, vwc, vwd, vwe, vwf, yiy
{
  private static float jdField_a_of_type_Float = 1.0F;
  private static boolean n;
  private final int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long;
  private CertifiedAccountMeta.StFeed jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
  private final Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private SparseBooleanArray jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
  protected View a;
  protected ImageView a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  protected ProgressBar a;
  public SeekBar a;
  protected TextView a;
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private SubscribeVideoDetailFragment jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment;
  private VideoNextFeedsView jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView;
  private FollowTextView jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView;
  private SquareImageView jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
  private IVideoOuterStatusListener jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoOuterStatusListener;
  private SystemBarCompact jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<WeakReference<View>> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<String, Boolean> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Timer jdField_a_of_type_JavaUtilTimer;
  private ConcurrentHashMap<WeakReference<View>, Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private vwf jdField_a_of_type_Vwf;
  private vxe jdField_a_of_type_Vxe;
  private final ymv jdField_a_of_type_Ymv;
  private ymw jdField_a_of_type_Ymw;
  private ynq jdField_a_of_type_Ynq;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt;
  private final int jdField_b_of_type_Int = 2;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  protected ImageView b;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  public TextView b;
  private FollowTextView jdField_b_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView;
  private SquareImageView jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int[] jdField_b_of_type_ArrayOfInt = bnle.a(getContext());
  private final int jdField_c_of_type_Int = 3;
  private long jdField_c_of_type_Long;
  private View jdField_c_of_type_AndroidViewView;
  protected ImageView c;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  private View jdField_d_of_type_AndroidViewView;
  protected ImageView d;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private volatile boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private long jdField_e_of_type_Long;
  private View jdField_e_of_type_AndroidViewView;
  public ImageView e;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int = 1;
  private long jdField_f_of_type_Long;
  private View jdField_f_of_type_AndroidViewView;
  private boolean jdField_f_of_type_Boolean = true;
  private int jdField_g_of_type_Int;
  private View jdField_g_of_type_AndroidViewView;
  private boolean jdField_g_of_type_Boolean = true;
  private View jdField_h_of_type_AndroidViewView;
  private boolean jdField_h_of_type_Boolean;
  private View jdField_i_of_type_AndroidViewView;
  private boolean jdField_i_of_type_Boolean;
  private View jdField_j_of_type_AndroidViewView;
  private boolean jdField_j_of_type_Boolean;
  private View jdField_k_of_type_AndroidViewView;
  private boolean jdField_k_of_type_Boolean;
  private View jdField_l_of_type_AndroidViewView;
  private boolean jdField_l_of_type_Boolean;
  private boolean m;
  private boolean o;
  private boolean p;
  private boolean q;
  private boolean r;
  private boolean s;
  private boolean t;
  
  public VideoPlayerView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoPlayerView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VideoPlayerView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a(getContext());
    if (a() != null) {
      addView(a().a(), new FrameLayout.LayoutParams(-1, -1));
    }
    m();
    j();
    this.jdField_a_of_type_Ymv = new ymv();
  }
  
  private void A()
  {
    if ((this.jdField_c_of_type_AndroidWidgetTextView != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))) {
      if (((Activity)this.jdField_a_of_type_AndroidContentContext).getRequestedOrientation() != 0) {
        break label42;
      }
    }
    label42:
    for (int i1 = 25;; i1 = 12)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setMaxEms(i1);
      return;
    }
  }
  
  private void B()
  {
    int i2 = 0;
    label114:
    View localView;
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null)
    {
      if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.followState.get() == 0) && (this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get()) == null)) {
        break label231;
      }
      i1 = 1;
      if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView != null)
      {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setOnlyFollowMode(true);
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setFeedData(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setExtraTypeInfo(a());
      }
      if ((i1 != 0) || (this.r) || (!f())) {
        break label236;
      }
      i1 = 1;
      if (this.jdField_e_of_type_AndroidViewView != null)
      {
        if (i1 != 0)
        {
          this.r = true;
          if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) {
            zaj.b(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_video", "half_exp", 0, 0, new String[] { "", "", this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.get(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.title.get() });
          }
        }
        localView = this.jdField_e_of_type_AndroidViewView;
        if (i1 == 0) {
          break label241;
        }
      }
    }
    label231:
    label236:
    label241:
    for (int i1 = i2;; i1 = 8)
    {
      localView.setVisibility(i1);
      a().sendEmptyMessageDelayed(3, 5000L);
      return;
      i1 = 0;
      break;
      i1 = 0;
      break label114;
    }
  }
  
  private void C()
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838738);
    }
    if (this.jdField_e_of_type_AndroidViewView != null) {
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  private void D()
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      ((Activity)this.jdField_a_of_type_AndroidContentContext).setRequestedOrientation(1);
      if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
        this.jdField_c_of_type_AndroidWidgetTextView.setMaxEms(12);
      }
    }
    b(this.jdField_a_of_type_ArrayOfInt);
    a(0);
    e(false);
    C();
    if (this.jdField_f_of_type_Int == 10) {
      v();
    }
    aofm.a(BaseApplicationImpl.getContext(), 2, true);
  }
  
  private String a(String paramString1, String paramString2)
  {
    String str = paramString2;
    if ("auto".equals(paramString2)) {
      str = "hd";
    }
    paramString1 = new File(ybn.d + "st" + String.valueOf(20161223) + "_" + paramString1 + "." + str);
    if ((paramString1.exists()) && (paramString1.isDirectory()))
    {
      paramString1 = paramString1.listFiles();
      int i2 = paramString1.length;
      int i1 = 0;
      while (i1 < i2)
      {
        paramString2 = paramString1[i1];
        if ((paramString2.getName().endsWith("tmp")) || (paramString2.getName().endsWith("mp4"))) {
          return paramString2.getAbsolutePath();
        }
        i1 += 1;
      }
    }
    return "";
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((View)localWeakReference.get()).setVisibility(paramInt);
        }
      }
    }
  }
  
  private void a(WeakReference<View> paramWeakReference, int paramInt1, int paramInt2)
  {
    a(paramWeakReference, paramInt1, paramInt2, false);
  }
  
  private void a(WeakReference<View> paramWeakReference, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramWeakReference.get() == null) {
      return;
    }
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramWeakReference.get(), "alpha", new float[] { paramInt1, paramInt2 });
    localObjectAnimator.setDuration(0L);
    localObjectAnimator.addListener(new yne(this, paramWeakReference, paramInt2, paramBoolean, paramInt1));
    localObjectAnimator.start();
  }
  
  private boolean a(String paramString)
  {
    try
    {
      String[] arrayOfString = ((String)yyw.a().a("KEY_HIT_FOR_VID_URLS", "http://qzvv.video.qq.com/qzone|")).split("\\|");
      int i2 = arrayOfString.length;
      int i1 = 0;
      while (i1 < i2)
      {
        boolean bool = paramString.startsWith(arrayOfString[i1]);
        if (bool) {
          return true;
        }
        i1 += 1;
      }
      return false;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  private void b(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
  }
  
  private void b(boolean paramBoolean)
  {
    String str;
    if (this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment != null)
    {
      localObject = this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.a();
      this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.c((CertifiedAccountMeta.StFeed)localObject);
      str = ((CertifiedAccountMeta.StFeed)localObject).poster.id.get();
      if (!paramBoolean) {
        break label80;
      }
    }
    label80:
    for (Object localObject = "next_play";; localObject = "next_clk")
    {
      zaj.b(str, "auth_video", (String)localObject, 0, 0, new String[0]);
      if (this.jdField_e_of_type_AndroidWidgetImageView != null)
      {
        this.jdField_e_of_type_AndroidWidgetImageView.setBackgroundResource(0);
        this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      return;
    }
  }
  
  private void b(int[] paramArrayOfInt)
  {
    getLayoutParams().width = paramArrayOfInt[0];
    getLayoutParams().height = paramArrayOfInt[1];
    setLayoutParams(getLayoutParams());
  }
  
  private void c(boolean paramBoolean)
  {
    int i2 = 8;
    Object localObject;
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetProgressBar;
      if (paramBoolean)
      {
        i1 = 0;
        ((ProgressBar)localObject).setVisibility(i1);
      }
    }
    else if (this.jdField_b_of_type_AndroidWidgetImageView != null)
    {
      localObject = this.jdField_b_of_type_AndroidWidgetImageView;
      if (!paramBoolean) {
        break label60;
      }
    }
    label60:
    for (int i1 = i2;; i1 = 0)
    {
      ((ImageView)localObject).setVisibility(i1);
      return;
      i1 = 8;
      break;
    }
  }
  
  private void d(boolean paramBoolean)
  {
    if (!bnle.b()) {}
    do
    {
      do
      {
        return;
        if ((!paramBoolean) || (this.q)) {
          break;
        }
        if (this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment != null) {
          this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.a(true, this.jdField_g_of_type_Int);
        }
      } while (this.jdField_b_of_type_AndroidViewView == null);
      this.jdField_b_of_type_AndroidViewView.setPadding(0, this.jdField_g_of_type_Int, 0, 0);
      return;
      if (this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment != null) {
        this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.a(false, this.jdField_g_of_type_Int);
      }
    } while (this.jdField_b_of_type_AndroidViewView == null);
    this.jdField_b_of_type_AndroidViewView.setPadding(0, 0, 0, 0);
  }
  
  private void e(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    View localView;
    if ((this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment != null) && (this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getActivity() != null))
    {
      localView = this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getActivity().getWindow().getDecorView();
      if (!this.jdField_a_of_type_Boolean) {
        break label126;
      }
      if (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null) {
        this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarVisible(2, 0);
      }
      this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getActivity().getWindow().setFlags(1024, 1024);
      bnle.c(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getActivity());
      rdm.a(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getActivity());
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView != null) {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.setUIState(paramBoolean, this.q);
      }
      d(this.jdField_a_of_type_Boolean);
      return;
      label126:
      if (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null) {
        this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarVisible(0, 10);
      }
      this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getActivity().getWindow().clearFlags(1024);
      bnle.b(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getActivity());
      localView.setSystemUiVisibility(localView.getSystemUiVisibility() & 0xFFFFFFFD);
    }
  }
  
  private void j()
  {
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(new ymx(this));
    this.jdField_b_of_type_AndroidViewView.setOnTouchListener(new yni(this));
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new ynk(this));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setFollowStateChangeListener(new ynl(this));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new ynm(this));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new ynn(this));
    this.jdField_g_of_type_AndroidViewView.setOnClickListener(new yno(this));
    this.jdField_h_of_type_AndroidViewView.setOnClickListener(new ynp(this));
    yiw.a().a(this);
  }
  
  private void k()
  {
    if ((a() != null) && (this.jdField_b_of_type_AndroidWidgetImageView != null))
    {
      if (a().a()) {
        a();
      }
    }
    else {
      return;
    }
    d();
  }
  
  private void l()
  {
    if (this.jdField_f_of_type_Boolean) {
      s();
    }
    for (;;)
    {
      this.jdField_e_of_type_Boolean = true;
      return;
      t();
    }
  }
  
  private void m()
  {
    this.jdField_j_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131558747, this, false);
    addView(this.jdField_j_of_type_AndroidViewView);
    n();
    u();
    this.jdField_g_of_type_AndroidViewView = this.jdField_j_of_type_AndroidViewView.findViewById(2131369722);
    this.jdField_h_of_type_AndroidViewView = this.jdField_j_of_type_AndroidViewView.findViewById(2131369723);
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_j_of_type_AndroidViewView.findViewById(2131368963));
    this.jdField_e_of_type_AndroidViewView = findViewById(2131366435);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView = ((FollowTextView)this.jdField_j_of_type_AndroidViewView.findViewById(2131378803));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)this.jdField_j_of_type_AndroidViewView.findViewById(2131368861));
    this.jdField_f_of_type_AndroidViewView = this.jdField_j_of_type_AndroidViewView.findViewById(2131380238);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_j_of_type_AndroidViewView.findViewById(2131378843));
    o();
    if (a() != null) {
      a().setXYaxis(2);
    }
    NetworkManager.registNetStatusListener(this);
  }
  
  private void n()
  {
    this.jdField_b_of_type_AndroidViewView = this.jdField_j_of_type_AndroidViewView.findViewById(2131376010);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379084));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379043));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379083));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368793));
    this.jdField_i_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131369624);
    this.jdField_d_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131369736);
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131369747);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368967));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368969));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368966));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_b_of_type_AndroidViewView.findViewById(2131368965));
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_b_of_type_AndroidViewView.findViewById(2131376330));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(1000);
  }
  
  private void o()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(new WeakReference(this.jdField_b_of_type_AndroidViewView), Integer.valueOf(0));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(new WeakReference(this.jdField_d_of_type_AndroidWidgetImageView), Integer.valueOf(0));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(new WeakReference(this.jdField_b_of_type_AndroidWidgetImageView), Integer.valueOf(0));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(new WeakReference(this.jdField_c_of_type_AndroidWidgetImageView), Integer.valueOf(0));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(new WeakReference(this.jdField_a_of_type_AndroidWidgetSeekBar), Integer.valueOf(0));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(new WeakReference(this.jdField_a_of_type_AndroidWidgetImageView), Integer.valueOf(0));
    this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(this.jdField_b_of_type_AndroidViewView.getId(), true);
    this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(this.jdField_g_of_type_AndroidViewView.getId(), true);
    this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(this.jdField_h_of_type_AndroidViewView.getId(), true);
  }
  
  private void p()
  {
    this.jdField_b_of_type_JavaLangString = null;
    this.p = false;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Long = 0L;
    if (this.jdField_a_of_type_JavaUtilTimer != null) {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
    }
    a().removeCallbacksAndMessages(null);
  }
  
  private void q()
  {
    b(1);
    this.r = false;
    if ((this.jdField_b_of_type_AndroidViewView != null) && (!this.jdField_j_of_type_Boolean)) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    if (this.jdField_i_of_type_AndroidViewView != null) {
      this.jdField_i_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_c_of_type_AndroidViewView != null)
    {
      if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838741);
      }
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      c(true);
    }
    if ((this.jdField_e_of_type_AndroidViewView != null) && (this.jdField_e_of_type_AndroidViewView.getVisibility() == 0)) {
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    }
    w();
    a().removeMessages(3);
  }
  
  private void r()
  {
    long l1;
    Object localObject;
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster != null) && (a() != null))
    {
      l1 = System.currentTimeMillis() - this.jdField_b_of_type_Long;
      localObject = new StringBuilder();
      if (l1 < a().b()) {
        break label368;
      }
    }
    label368:
    for (int i1 = 1;; i1 = 0)
    {
      localObject = i1 + "";
      zaj.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_video", "play", 0, 0, new String[] { a().b() + "", l1 + "", localObject, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.id.get() });
      if (this.jdField_e_of_type_Int > 0)
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("time_cost", Long.valueOf(this.jdField_f_of_type_Long));
        ((HashMap)localObject).put("count", Integer.valueOf(this.jdField_e_of_type_Int));
        ((HashMap)localObject).put("url", this.jdField_b_of_type_JavaLangString);
        zaj.a("subscribe_account_video_play_extra_buffer", zaj.b((HashMap)localObject));
      }
      if (a() != null)
      {
        double d2 = a().a();
        double d1 = a().b();
        if ((d2 > 0.0D) && (d1 > 0.0D) && (d2 <= d1))
        {
          d2 /= d1;
          localObject = new HashMap();
          ((HashMap)localObject).put("rate", String.format("%.2f", new Object[] { Double.valueOf(d2 * 100.0D) }));
          ((HashMap)localObject).put("url", this.jdField_b_of_type_JavaLangString);
          ((HashMap)localObject).put("attach_info", String.valueOf(d1));
          zaj.a("subscribe_account_video_play_complete_rate", zaj.b((HashMap)localObject));
        }
      }
      return;
    }
  }
  
  private void s()
  {
    if ((this.jdField_f_of_type_Boolean) && (!this.jdField_g_of_type_Boolean))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext()) {
        a((WeakReference)localIterator.next(), 1, 0);
      }
      this.jdField_f_of_type_Boolean = false;
    }
  }
  
  private void t()
  {
    if (!this.jdField_f_of_type_Boolean)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext()) {
        a((WeakReference)localIterator.next(), 0, 1);
      }
      this.jdField_f_of_type_Boolean = true;
      if ((this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_c_of_type_AndroidViewView.getVisibility() == 8)) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      }
    }
  }
  
  private void u()
  {
    this.jdField_k_of_type_AndroidViewView = this.jdField_j_of_type_AndroidViewView.findViewById(2131366426);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView = ((VideoNextFeedsView)this.jdField_k_of_type_AndroidViewView.findViewById(2131380062));
    this.jdField_l_of_type_AndroidViewView = this.jdField_k_of_type_AndroidViewView.findViewById(2131369724);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_k_of_type_AndroidViewView.findViewById(2131366425));
    this.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)this.jdField_k_of_type_AndroidViewView.findViewById(2131368789));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_k_of_type_AndroidViewView.findViewById(2131369650));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_k_of_type_AndroidViewView.findViewById(2131378805));
    this.jdField_b_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView = ((FollowTextView)this.jdField_k_of_type_AndroidViewView.findViewById(2131366975));
    this.jdField_a_of_type_AndroidViewView = this.jdField_k_of_type_AndroidViewView.findViewById(2131378973);
    ynf localynf = new ynf(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(localynf);
    this.jdField_l_of_type_AndroidViewView.setOnClickListener(localynf);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.setOnClickListener(new yng(this));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.setOnCounterListener(new ynh(this));
  }
  
  private void v()
  {
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_k_of_type_AndroidViewView != null) {
      this.jdField_k_of_type_AndroidViewView.setVisibility(0);
    }
    if ((this.jdField_e_of_type_AndroidViewView != null) && (this.jdField_e_of_type_AndroidViewView.getVisibility() == 0)) {
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    }
    Object localObject;
    int i1;
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView != null)
    {
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.getLayoutParams();
      if (f())
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(12);
        ((RelativeLayout.LayoutParams)localObject).addRule(13, 0);
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    else
    {
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null)
      {
        localObject = this.jdField_b_of_type_AndroidWidgetLinearLayout;
        if (!f()) {
          break label377;
        }
        i1 = 0;
        label124:
        ((LinearLayout)localObject).setVisibility(i1);
      }
      if ((!f()) || (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null)) {
        break label414;
      }
      if (this.jdField_e_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.get());
      }
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView != null) {
        ybm.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.icon.get(), this.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView);
      }
      if (this.jdField_b_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView != null)
      {
        this.jdField_b_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setOnlyFollowMode(true);
        this.jdField_b_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setFeedData(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
        this.jdField_b_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setExtraTypeInfo(a());
        this.jdField_b_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setFollowStateChangeListener(new ynj(this));
      }
      localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
      {
        if ((!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) || (((Activity)this.jdField_a_of_type_AndroidContentContext).getRequestedOrientation() != 0)) {
          break label383;
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(2, this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.getId());
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
        ((LinearLayout.LayoutParams)this.jdField_b_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.getLayoutParams()).rightMargin = ImmersiveUtils.a(12.0F);
        this.jdField_b_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.requestLayout();
      }
      if (this.jdField_l_of_type_AndroidViewView != null) {
        this.jdField_l_of_type_AndroidViewView.setVisibility(8);
      }
    }
    label377:
    label383:
    while (this.jdField_l_of_type_AndroidViewView == null) {
      for (;;)
      {
        return;
        ((RelativeLayout.LayoutParams)localObject).addRule(13);
        ((RelativeLayout.LayoutParams)localObject).addRule(12, 0);
        break;
        i1 = 8;
        break label124;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
        ((LinearLayout.LayoutParams)this.jdField_b_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.getLayoutParams()).rightMargin = 0;
        ((RelativeLayout.LayoutParams)localObject).addRule(2, 0);
      }
    }
    label414:
    this.jdField_l_of_type_AndroidViewView.setVisibility(0);
  }
  
  private void w()
  {
    if ((this.jdField_k_of_type_AndroidViewView != null) && (this.jdField_k_of_type_AndroidViewView.getVisibility() == 0)) {
      this.jdField_k_of_type_AndroidViewView.setVisibility(8);
    }
    if ((this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView != null) && (this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.getVisibility() == 0)) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.b();
    }
  }
  
  private void x()
  {
    if (a() != null) {
      if (a().getViewWidth() <= a().getViewHeight()) {
        break label36;
      }
    }
    label36:
    for (boolean bool = true;; bool = false)
    {
      this.q = bool;
      return;
    }
  }
  
  private void y()
  {
    x();
    int i1 = this.jdField_b_of_type_ArrayOfInt[0];
    if (getLayoutParams().width != -1) {
      i1 = getLayoutParams().width;
    }
    this.jdField_a_of_type_ArrayOfInt = new int[] { i1, getLayoutParams().height };
    if (this.q)
    {
      if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
        ((Activity)this.jdField_a_of_type_AndroidContentContext).setRequestedOrientation(0);
      }
      b(new int[] { this.jdField_b_of_type_ArrayOfInt[1], this.jdField_b_of_type_ArrayOfInt[0] });
    }
    for (;;)
    {
      a(8);
      e(true);
      z();
      aofm.a(BaseApplicationImpl.getContext(), 2, false);
      return;
      b(new int[] { this.jdField_b_of_type_ArrayOfInt[0], this.jdField_b_of_type_ArrayOfInt[1] });
    }
  }
  
  private void z()
  {
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null)
    {
      if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      A();
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838736);
    }
  }
  
  public Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new ynd(this));
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public ExtraTypeInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  }
  
  public IVideoViewBase a()
  {
    if ((a() != null) && ((a().a() instanceof IVideoViewBase))) {
      return (IVideoViewBase)a().a();
    }
    return null;
  }
  
  public vxe a()
  {
    if (this.jdField_a_of_type_Vxe == null)
    {
      if (!TVK_SDKMgr.isInstalled(getContext())) {
        break label113;
      }
      zaj.a("subscribe_tvk_install_event_name", zaj.a(0L, 0L));
      this.jdField_a_of_type_Vxe = new vxe(getContext(), String.valueOf(System.identityHashCode(this)));
      this.jdField_a_of_type_Vxe.a(this);
      this.jdField_a_of_type_Vxe.a(this);
      this.jdField_a_of_type_Vxe.a(this);
      this.jdField_a_of_type_Vxe.a(this);
      this.jdField_a_of_type_Vxe.a(this);
      this.jdField_a_of_type_Vxe.a(this);
      this.jdField_a_of_type_Vxe.a("bus_type_subscribe");
    }
    for (;;)
    {
      return this.jdField_a_of_type_Vxe;
      label113:
      zaj.a("subscribe_tvk_install_event_name", zaj.a(-1L, 0L));
      QLog.w("VideoPlayerView", 1, "tvk is not installed");
    }
  }
  
  public void a()
  {
    if (a() != null)
    {
      b(7);
      if (a().a())
      {
        a().c();
        this.jdField_k_of_type_Boolean = true;
        this.jdField_c_of_type_Long = System.currentTimeMillis();
      }
      if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838741);
      }
    }
  }
  
  public void a(long paramLong)
  {
    long l1 = 0L;
    if (a() != null)
    {
      long l2 = a().b();
      if ((paramLong <= l2) || (l2 == 0L)) {
        break label141;
      }
      QLog.d("VideoPlayerView", 1, "seek over position=" + paramLong + "duration=" + l2);
      paramLong = l2;
    }
    label141:
    for (;;)
    {
      if (paramLong < 0L)
      {
        QLog.d("VideoPlayerView", 1, "seek invalid position=" + paramLong + "duration=" + a().b());
        paramLong = l1;
      }
      for (;;)
      {
        a().a(paramLong);
        this.p = true;
        return;
      }
    }
  }
  
  public void a(Context paramContext)
  {
    if (!this.jdField_d_of_type_Boolean)
    {
      TVK_SDKMgr.initSdk(paramContext, "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
      this.jdField_d_of_type_Boolean = true;
    }
    if (TVK_SDKMgr.isInstalled(paramContext)) {
      a();
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(paramView));
  }
  
  public void a(String paramString, File paramFile, int paramInt, JSONObject paramJSONObject) {}
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    zaj.a("subscribe_account_video_download", zaj.a(zaj.a(paramInt, 0L, this.jdField_b_of_type_JavaLangString, 0L)));
  }
  
  public void a(String paramString1, String paramString2, File paramFile)
  {
    zaj.a("subscribe_account_video_download", zaj.a(zaj.a(0L, 0L, this.jdField_b_of_type_JavaLangString, 0L)));
  }
  
  public void a(vwa paramvwa)
  {
    zaj.a("subscribe_account_video_play", zaj.a(zaj.a(0L, 0L, this.jdField_b_of_type_JavaLangString, 0L)));
    zaj.a("subscribe_account_video_play_first_buffer", zaj.a(zaj.a(0L, System.currentTimeMillis() - this.jdField_a_of_type_Long, this.jdField_b_of_type_JavaLangString, 0L)));
    b(10);
    this.jdField_g_of_type_Boolean = false;
    x();
    A();
    a().setXYaxis(0);
    int i1;
    if (this.jdField_e_of_type_AndroidViewView != null)
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_e_of_type_AndroidViewView.getLayoutParams();
      if (this.q)
      {
        i1 = 21;
        localLayoutParams.gravity = i1;
        int i2 = ImmersiveUtils.a(25.0F);
        if (!this.q) {
          break label419;
        }
        i1 = 0;
        label125:
        localLayoutParams.setMargins(0, 0, i2, i1);
        this.jdField_e_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      }
    }
    else
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoOuterStatusListener != null) && (b()) && (a() != null))
      {
        if (!this.m) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoOuterStatusListener.onOrientationChange(this.q);
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoOuterStatusListener.onVideoSize(a().getViewWidth(), a().getViewHeight());
      }
      if (this.jdField_c_of_type_AndroidViewView != null)
      {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        c(false);
      }
      if (this.jdField_i_of_type_AndroidViewView != null) {
        this.jdField_i_of_type_AndroidViewView.setVisibility(0);
      }
      long l1 = paramvwa.b() / 1000L;
      if (this.jdField_a_of_type_AndroidWidgetSeekBar != null) {
        this.jdField_a_of_type_AndroidWidgetSeekBar.setMax((int)paramvwa.b());
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText("/" + String.format("%02d:%02d", new Object[] { Integer.valueOf((int)l1 / 60), Integer.valueOf((int)l1 % 60) }));
      }
      h();
      if (((!this.jdField_c_of_type_Boolean) || (!NetworkUtils.isWifiConnected(getContext()))) && (!n)) {
        break label429;
      }
      if (!this.jdField_k_of_type_Boolean)
      {
        d();
        this.jdField_d_of_type_Long = System.currentTimeMillis();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Vwf != null) {
        this.jdField_a_of_type_Vwf.a(paramvwa);
      }
      s();
      return;
      i1 = 85;
      break;
      label419:
      i1 = ImmersiveUtils.a(82.0F);
      break label125;
      label429:
      if (this.jdField_h_of_type_Boolean) {
        this.jdField_f_of_type_AndroidViewView.setVisibility(0);
      } else if (this.jdField_c_of_type_AndroidViewView != null) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ImageView localImageView;
    if (this.jdField_c_of_type_AndroidWidgetImageView != null)
    {
      localImageView = this.jdField_c_of_type_AndroidWidgetImageView;
      if (!paramBoolean) {
        break label26;
      }
    }
    label26:
    for (int i1 = 2130838743;; i1 = 2130838742)
    {
      localImageView.setImageResource(i1);
      return;
    }
  }
  
  public void a(int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    if (this.jdField_c_of_type_AndroidWidgetTextView != null)
    {
      paramArrayOfInt = this.jdField_c_of_type_AndroidWidgetTextView;
      if (this.jdField_a_of_type_ArrayOfInt[0] <= this.jdField_a_of_type_ArrayOfInt[1]) {
        break label41;
      }
    }
    label41:
    for (int i1 = 25;; i1 = 12)
    {
      paramArrayOfInt.setMaxEms(i1);
      return;
    }
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Vxe != null) && (this.jdField_a_of_type_Vxe.a() != null))
    {
      if (f()) {
        D();
      }
      ThreadManager.getUIHandler().postDelayed(new VideoPlayerView.9(this), 500L);
      return true;
    }
    QLog.d("VideoPlayerView", 4, "enterFloat to early, player is not init");
    return false;
  }
  
  public boolean a(vwa paramvwa, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    b(9);
    QLog.e("VideoPlayerView", 1, "what:" + paramInt2 + ",model:" + paramInt1 + ",extra:" + paramString);
    c(false);
    zaj.a("subscribe_account_video_play", zaj.a(zaj.a(paramInt2, 0L, this.jdField_b_of_type_JavaLangString, 0L)));
    if (paramInt2 == 102) {
      return false;
    }
    if (!this.jdField_j_of_type_Boolean) {
      QQToast.a(getContext(), 1, alud.a(2131716739), 0).a();
    }
    return false;
  }
  
  public boolean a(vwa paramvwa, int paramInt, Object paramObject)
  {
    if (paramInt == 2)
    {
      b(4);
      this.jdField_e_of_type_Long = System.currentTimeMillis();
      this.jdField_g_of_type_Boolean = true;
      c(true);
      t();
    }
    while (paramInt != 3) {
      return false;
    }
    b(5);
    this.jdField_g_of_type_Boolean = false;
    if (!this.p)
    {
      this.jdField_e_of_type_Int += 1;
      this.jdField_f_of_type_Long += System.currentTimeMillis() - this.jdField_e_of_type_Long;
    }
    c(false);
    s();
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoOuterStatusListener = FloatingScreenManager.getInstance().setFloatingVideoListener(new ymz(this));
    FloatingScreenManager.getInstance().setFullScreenViewClickListener(new yna(this));
    FloatingScreenManager.getInstance().setWindowClickListener(0, new ynb(this));
  }
  
  public void b(View paramView)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(new WeakReference(paramView), Integer.valueOf(paramView.getVisibility()));
  }
  
  public void b(vwa paramvwa)
  {
    b(10);
    if (a() != null)
    {
      v();
      t();
      this.jdField_g_of_type_Boolean = true;
    }
    if (!this.s) {
      if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView != null)
      {
        if (!b()) {
          break label88;
        }
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.a();
      }
    }
    for (;;)
    {
      if (this.jdField_c_of_type_AndroidViewView != null) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoOuterStatusListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoOuterStatusListener.onVideoComplete(false);
      }
      return;
      label88:
      if ((this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.a()) && (this.jdField_e_of_type_AndroidWidgetImageView != null))
      {
        this.jdField_e_of_type_AndroidWidgetImageView.setBackgroundResource(2131165318);
        this.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(null);
        this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
        if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null)
        {
          zaj.b(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_video", "finish_exp", 0, 0, new String[] { "", "", this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.get(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.title.get() });
          continue;
          q();
          f();
        }
      }
    }
  }
  
  public boolean b()
  {
    return this.jdField_l_of_type_Boolean;
  }
  
  public void c()
  {
    if (a() != null)
    {
      a().f();
      this.jdField_k_of_type_Boolean = false;
      a().g();
    }
  }
  
  public boolean c()
  {
    return (a() != null) && (a().a());
  }
  
  public void d()
  {
    if (a() != null)
    {
      b(5);
      if (this.jdField_a_of_type_Ymv != null) {
        this.jdField_a_of_type_Ymv.a(a().a(), new ync(this));
      }
      if ((this.jdField_k_of_type_Boolean) && (this.jdField_c_of_type_Long > 0L))
      {
        this.jdField_b_of_type_Long -= System.currentTimeMillis() - this.jdField_c_of_type_Long;
        this.jdField_c_of_type_Long = 0L;
      }
      this.jdField_k_of_type_Boolean = false;
      a().b();
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoOuterStatusListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoOuterStatusListener.onVideoStart((int)this.jdField_a_of_type_Vxe.b());
      }
      if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838740);
      }
    }
  }
  
  public boolean d()
  {
    return this.q;
  }
  
  public void e()
  {
    r();
    if (a() != null)
    {
      b(8);
      a().f();
    }
  }
  
  public boolean e()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      D();
      return true;
    }
    return false;
  }
  
  public void f()
  {
    if (a() != null)
    {
      a().f();
      this.jdField_k_of_type_Boolean = false;
      a().g();
    }
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void g()
  {
    r();
    if (a() != null) {
      a().e();
    }
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    if (this.jdField_a_of_type_Ymv != null) {
      this.jdField_a_of_type_Ymv.a();
    }
    yiw.a().b(this);
    this.jdField_k_of_type_Boolean = false;
    a().removeCallbacksAndMessages(null);
    NetworkManager.unregistNetStatusListener(this);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(FollowUpdateEvent.class);
    localArrayList.add(CommentListShowStateEvent.class);
    localArrayList.add(SharePanelShowStateEvent.class);
    return localArrayList;
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null) {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
    }
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_JavaUtilTimer.schedule(new VideoPlayerView.14(this), 0L, 33L);
  }
  
  public void i()
  {
    if ((this.jdField_a_of_type_Vxe != null) && (!this.jdField_a_of_type_Vxe.a())) {
      d();
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.jdField_i_of_type_Boolean = false;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_i_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.b();
    }
    a().removeCallbacksAndMessages(null);
  }
  
  public void onNetworkChanged(String paramString1, String paramString2)
  {
    if (!"wifi".equals(paramString2)) {
      a().post(new VideoPlayerView.21(this));
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof FollowUpdateEvent)) {
      if (((FollowUpdateEvent)paramSimpleBaseEvent).followStatus == 0) {
        if (this.jdField_a_of_type_JavaUtilHashMap == null) {}
      }
    }
    do
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove(((FollowUpdateEvent)paramSimpleBaseEvent).useId);
      for (;;)
      {
        if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) {
          this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.followState.set(((FollowUpdateEvent)paramSimpleBaseEvent).followStatus);
        }
        return;
        if (this.jdField_a_of_type_JavaUtilHashMap != null) {
          this.jdField_a_of_type_JavaUtilHashMap.put(((FollowUpdateEvent)paramSimpleBaseEvent).useId, Boolean.valueOf(true));
        }
      }
      if ((paramSimpleBaseEvent instanceof CommentListShowStateEvent))
      {
        this.s = ((CommentListShowStateEvent)paramSimpleBaseEvent).shown;
        return;
      }
    } while (!(paramSimpleBaseEvent instanceof SharePanelShowStateEvent));
    this.s = ((SharePanelShowStateEvent)paramSimpleBaseEvent).shown;
  }
  
  public void onSeekComplete(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    this.p = false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((f()) && (this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment != null) && (this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getActivity() != null)) {
      rdm.a(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getActivity());
    }
  }
  
  public void setCleanMode(boolean paramBoolean)
  {
    this.jdField_j_of_type_Boolean = paramBoolean;
    View localView;
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      localView = this.jdField_b_of_type_AndroidViewView;
      if (!paramBoolean) {
        break label30;
      }
    }
    label30:
    for (int i1 = 8;; i1 = 0)
    {
      localView.setVisibility(i1);
      return;
    }
  }
  
  public void setContinueFeeds(List<CertifiedAccountMeta.StFeed> paramList)
  {
    if ((paramList != null) && (this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView != null)) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.setData(paramList);
    }
  }
  
  public void setDarkFrameCheckListener(ymw paramymw)
  {
    this.jdField_a_of_type_Ymw = paramymw;
  }
  
  public void setExtraTypeInfo(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = paramExtraTypeInfo;
  }
  
  public void setHostFragment(SubscribeVideoDetailFragment paramSubscribeVideoDetailFragment)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment = paramSubscribeVideoDetailFragment;
    if (this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getActivity() != null)
    {
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = ((PublicFragmentActivity)this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getActivity()).mSystemBarComp;
      this.jdField_g_of_type_Int = bnle.b(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getActivity());
    }
  }
  
  public void setLoopBack(boolean paramBoolean)
  {
    if (a() != null) {
      a().a(paramBoolean);
    }
  }
  
  public void setNeedWifiTips(boolean paramBoolean)
  {
    this.jdField_h_of_type_Boolean = paramBoolean;
  }
  
  public void setNextVideoClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_d_of_type_AndroidWidgetImageView != null) {
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setOnPrepareListener(vwf paramvwf)
  {
    this.jdField_a_of_type_Vwf = paramvwf;
  }
  
  public void setOnProgressListener(ynq paramynq)
  {
    this.jdField_a_of_type_Ynq = paramynq;
  }
  
  public void setOutPutMute(boolean paramBoolean)
  {
    if (a() != null) {
      a().b(paramBoolean);
    }
  }
  
  public void setPreviewVideoClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setRevertProgress(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setVideoFeeds(CertifiedAccountMeta.StFeed paramStFeed)
  {
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = paramStFeed;
    setVideoPath(paramStFeed.video.fileId.get(), null, paramStFeed.video.playUrl.get(), paramStFeed.video.fileSize.get(), paramStFeed.video.duration.get(), 0);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView != null) {
      ybm.a(paramStFeed.poster.icon.get(), this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView);
    }
    if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.title.get());
    }
  }
  
  public void setVideoPath(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    p();
    q();
    zaj.a();
    Object localObject = "auto";
    if ((!bdnn.a(paramString3)) && (a(paramString3)))
    {
      Uri localUri = Uri.parse(paramString3);
      paramString3 = paramString1;
      if (localUri != null)
      {
        str = localUri.getQueryParameter("playerformat");
        localObject = str;
        paramString3 = paramString1;
        if (bdnn.a(paramString1))
        {
          paramString3 = localUri.getQueryParameter("vid");
          localObject = str;
        }
      }
      String str = null;
      paramString1 = paramString3;
      paramString3 = str;
    }
    for (;;)
    {
      if (paramString3 != null)
      {
        this.jdField_b_of_type_JavaLangString = paramString3;
        if (!bdnn.a(paramString2)) {
          break label208;
        }
        paramString2 = a(paramString1, (String)localObject);
      }
      label208:
      for (;;)
      {
        t();
        this.jdField_g_of_type_Boolean = true;
        if (a() != null)
        {
          a().a(paramString1, paramString2, paramString3, (String)localObject, paramInt1, paramInt2, paramInt3);
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          zaj.a("subscribe_account_video_start_play", zaj.a(zaj.a(0L, 0L, this.jdField_b_of_type_JavaLangString, 0L)));
          zaj.a("subscribe_account_video_start_download", zaj.a(zaj.a(0L, 0L, this.jdField_b_of_type_JavaLangString, 0L)));
        }
        this.jdField_b_of_type_Long = System.currentTimeMillis();
        return;
        this.jdField_b_of_type_JavaLangString = paramString1;
        break;
      }
      localObject = "auto";
    }
  }
  
  public void setVideoViewCover(String paramString)
  {
    if (this.jdField_e_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_JavaLangString = paramString;
    }
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = getResources().getDrawable(2130841612);
      localURLDrawableOptions.mFailedDrawable = getResources().getDrawable(2130841612);
      paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      if (paramString != null) {
        this.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void setWifiAutoPlay(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.VideoPlayerView
 * JD-Core Version:    0.7.0.1
 */