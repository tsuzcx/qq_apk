package com.tencent.mobileqq.activity.qwallet.fragment;

import Wallet.SkinInfo;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.redpacket.IRedPacket;
import com.tencent.mobileqq.activity.qwallet.redpacket.IRedPacket.OnGetSkinListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketInfoBase;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import com.tencent.mobileqq.activity.qwallet.widget.QwScrollView;
import com.tencent.mobileqq.activity.qwallet.widget.QwScrollView.OnQwScrollListener;
import com.tencent.mobileqq.activity.qwallet.widget.ViewTransformer;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.HorizontalListView;
import cooperation.qwallet.plugin.QwAdapter;
import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import wzo;
import wzp;
import wzq;
import wzr;
import wzs;
import wzt;
import wzu;
import wzv;
import wzw;
import wzx;
import wzy;
import wzz;
import xaa;
import xad;
import xae;
import xaf;
import xag;
import xah;
import xai;

public class CommonHbFragment
  extends BaseHbFragment
  implements ViewPager.OnPageChangeListener, View.OnClickListener, FragmentInterface
{
  private static final List jdField_c_of_type_JavaUtilList = new ArrayList(Arrays.asList(new String[] { "1", "1024", "32" }));
  private static final List jdField_d_of_type_JavaUtilList = new ArrayList(Arrays.asList(new String[] { "4", "5", "7" }));
  private static final List jdField_e_of_type_JavaUtilList = new ArrayList(Arrays.asList(new String[] { "2", "3", "6", "" }));
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(-528142);
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private PagerAdapter jdField_a_of_type_AndroidSupportV4ViewPagerAdapter = new wzv(this);
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  protected TextWatcher a;
  private View jdField_a_of_type_AndroidViewView;
  private AdapterView.OnItemClickListener jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = new xaa(this);
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private IRedPacket.OnGetSkinListener jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketIRedPacket$OnGetSkinListener = new xad(this);
  private QwScrollView.OnQwScrollListener jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetQwScrollView$OnQwScrollListener = new xah(this);
  private IndividualRedPacketManager jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager;
  private QwAdapter jdField_a_of_type_CooperationQwalletPluginQwAdapter;
  private String jdField_a_of_type_JavaLangString;
  private List jdField_a_of_type_JavaUtilList;
  private BusinessObserver jdField_a_of_type_MqqObserverBusinessObserver = new wzz(this);
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  public boolean a;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private EditText jdField_b_of_type_AndroidWidgetEditText;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private List jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 5;
  private long jdField_c_of_type_Long;
  private View jdField_c_of_type_AndroidViewView;
  private Button jdField_c_of_type_AndroidWidgetButton;
  private EditText jdField_c_of_type_AndroidWidgetEditText;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private View jdField_d_of_type_AndroidViewView;
  private Button jdField_d_of_type_AndroidWidgetButton;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString;
  private int jdField_f_of_type_Int;
  private String jdField_f_of_type_JavaLangString;
  private List jdField_f_of_type_JavaUtilList = new ArrayList();
  private int jdField_g_of_type_Int = -1;
  private String jdField_g_of_type_JavaLangString;
  private String h;
  private String i;
  private String j;
  private String k;
  private String l;
  private String m;
  private String n;
  private String o;
  private String p;
  private String q;
  private String r;
  private String s = "";
  
  public CommonHbFragment()
  {
    this.jdField_a_of_type_AndroidTextTextWatcher = new wzo(this);
  }
  
  public static int a(String paramString)
  {
    int i1 = 0;
    if (!TextUtils.isEmpty(paramString)) {
      i1 = paramString.replaceAll("[\\u4e00-\\u9fa5]", "aa").length() - paramString.length();
    }
    return i1;
  }
  
  public static String a(String paramString)
  {
    String str = "";
    if (!TextUtils.isEmpty(paramString)) {
      str = paramString.replaceAll("[\\u4e00-\\u9fa5,，。、 ]", "");
    }
    return str;
  }
  
  private String a(ArrayList paramArrayList)
  {
    if (paramArrayList == null) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int i2 = paramArrayList.size();
    int i1 = 0;
    for (;;)
    {
      if (i1 >= i2) {
        break label74;
      }
      try
      {
        localStringBuffer.append((String)paramArrayList.get(i1));
        if (i1 != i2 - 1) {
          localStringBuffer.append("|");
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
      i1 += 1;
    }
    label74:
    return localStringBuffer.toString();
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {}
    RelativeLayout localRelativeLayout;
    do
    {
      return;
      ViewTransformer localViewTransformer = (ViewTransformer)paramView.findViewById(2131367959);
      EditText localEditText = (EditText)paramView.findViewById(2131367918);
      localViewTransformer.setTag("");
      Button localButton1 = (Button)paramView.findViewById(2131367958);
      localRelativeLayout = (RelativeLayout)paramView.findViewById(2131367979);
      TextView localTextView = (TextView)paramView.findViewById(2131365631);
      Button localButton2 = (Button)paramView.findViewById(2131367958);
      localTextView.setText("当前所有成员可抢，");
      localButton2.setText("改为指定人领取");
      localButton2.setVisibility(0);
      localViewTransformer.setLisenter(new wzs(this, localEditText, localRelativeLayout));
      if (localButton1 != null) {
        localButton1.setOnClickListener(new wzt(this, localViewTransformer, localTextView, localButton2));
      }
    } while (localRelativeLayout == null);
    localRelativeLayout.setOnClickListener(new wzu(this, paramView));
  }
  
  private void a(View paramView, int paramInt)
  {
    Object localObject;
    if (!jdField_e_of_type_JavaUtilList.contains(this.k))
    {
      localObject = new ArrayList();
      ((List)localObject).add(Integer.valueOf(2131367959));
      ((List)localObject).add(Integer.valueOf(2131365631));
      a(paramView, (List)localObject, 8);
      localObject = paramView.findViewById(2131367959);
      ((View)localObject).setVisibility(8);
      ((EditText)((View)localObject).findViewById(2131364166)).setText("1");
      localObject = (TextView)paramView.findViewById(2131367983);
      if (localObject != null) {
        ((TextView)localObject).setText("金额");
      }
      localObject = (EditText)paramView.findViewById(2131367918);
      ((EditText)localObject).addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      if (paramInt == 2) {
        ((EditText)localObject).setOnEditorActionListener(new wzq(this));
      }
      localObject = (EditText)paramView.findViewById(2131367956);
      if (paramInt != 2) {
        break label380;
      }
      ((EditText)localObject).addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
        ((EditText)localObject).setHint("如  “" + this.jdField_e_of_type_JavaLangString + "”");
      }
    }
    for (;;)
    {
      ((Button)paramView.findViewById(2131364058)).setOnClickListener(this);
      if ((("2".equals(this.k)) || ("3".equals(this.k))) && ((paramInt == 0) || (paramInt == 1))) {
        a(paramView);
      }
      if ("4096".equals(this.jdField_a_of_type_JavaLangString))
      {
        localObject = (TextView)paramView.findViewById(2131365631);
        if (localObject != null) {
          ((TextView)localObject).setText("小伙伴领取的金额随机");
        }
        paramView = (Button)paramView.findViewById(2131367958);
        if (paramView != null) {
          paramView.setVisibility(8);
        }
      }
      return;
      localObject = (EditText)paramView.findViewById(2131364166);
      if (!TextUtils.isEmpty(this.j)) {
        ((EditText)localObject).setHint("本群共" + this.j + "人");
      }
      ((EditText)localObject).addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      break;
      label380:
      ((EditText)localObject).setOnEditorActionListener(new wzr(this));
    }
  }
  
  private void a(View paramView, ImageView paramImageView)
  {
    if ((paramView == null) || (paramImageView == null)) {}
    Object localObject1;
    int i3;
    int i2;
    do
    {
      for (;;)
      {
        return;
        try
        {
          localObject1 = new URL("protocol_vas_extension_image", "REDPACKET_SEND_PIC", this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.j + this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.jdField_b_of_type_JavaLangString);
          Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          localObject1 = URLDrawable.getDrawable((URL)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
          if (((URLDrawable)localObject1).getStatus() != 1) {
            ((URLDrawable)localObject1).restartDownload();
          }
          localObject2 = paramView.getViewTreeObserver();
          if (localObject2 != null)
          {
            i3 = paramView.getHeight();
            i2 = (int)(i3 * 3.076923076923077D + 0.5D);
            if ((i2 == 0) || (i3 == 0))
            {
              ((ViewTreeObserver)localObject2).addOnGlobalLayoutListener(new wzw(this, paramView, paramImageView, (URLDrawable)localObject1));
              return;
            }
          }
        }
        catch (Exception paramView)
        {
          paramView.printStackTrace();
          return;
        }
      }
    } while ((i2 <= 0) || (i3 <= 0));
    int i1 = i2;
    if (i2 > this.jdField_e_of_type_Int) {
      i1 = this.jdField_e_of_type_Int;
    }
    paramView = new FrameLayout.LayoutParams(i1, i3);
    paramView.gravity = 5;
    paramImageView.setLayoutParams(paramView);
    paramImageView.setImageDrawable((Drawable)localObject1);
    paramImageView.postInvalidate();
  }
  
  private void a(View paramView, String paramString1, String paramString2)
  {
    if ((paramView == null) || (TextUtils.isEmpty(paramString1))) {}
    LinearLayout localLinearLayout;
    do
    {
      return;
      localLinearLayout = (LinearLayout)paramView.findViewById(2131367953);
      localLinearLayout.setVisibility(0);
      ((TextView)paramView.findViewById(2131367954)).setText(paramString1);
    } while (TextUtils.isEmpty(paramString2));
    localLinearLayout.setOnClickListener(new xag(this, paramString2));
  }
  
  private static void a(View paramView, List paramList, int paramInt)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      View localView = paramView.findViewById(((Integer)paramList.next()).intValue());
      if (localView != null) {
        localView.setVisibility(paramInt);
      }
    }
  }
  
  private void a(String paramString, View paramView1, View paramView2, View paramView3)
  {
    if ((paramView1 == null) || (paramView2 == null) || (paramView3 == null)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (TextUtils.isEmpty(paramString));
        if ("0".equals(paramString))
        {
          paramView1.setVisibility(0);
          return;
        }
      } while (!"1".equals(paramString));
      paramView1.setVisibility(8);
      paramString = (LinearLayout.LayoutParams)paramView2.getLayoutParams();
    } while (paramString == null);
    paramString.setMargins(0, 0, 0, (int)(this.jdField_a_of_type_Float * 33.0F));
    paramView2.setLayoutParams(paramString);
    paramView3.setVisibility(8);
    paramView2.setVisibility(4);
    paramView2.requestLayout();
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.a(this.jdField_d_of_type_Int, paramString1, paramString2, 2);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    boolean bool2 = true;
    if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_b_of_type_AndroidViewView == null)) {
      return;
    }
    boolean bool3 = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.a().contains(this.jdField_a_of_type_JavaLangString);
    boolean bool1;
    if ((paramBoolean) && (bool3))
    {
      bool1 = true;
      a(bool1, this.jdField_a_of_type_AndroidViewView);
      if ((!paramBoolean) || (!bool3)) {
        break label81;
      }
    }
    label81:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      a(paramBoolean, this.jdField_b_of_type_AndroidViewView);
      return;
      bool1 = false;
      break;
    }
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager != null) {}
    for (boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a();; bool = false)
    {
      if (("4096".equals(this.jdField_a_of_type_JavaLangString)) || ("512".equals(this.jdField_a_of_type_JavaLangString)) || ("2048".equals(this.jdField_a_of_type_JavaLangString))) {
        bool = false;
      }
      return bool;
    }
  }
  
  private boolean a(View paramView)
  {
    if (paramView != null) {}
    for (;;)
    {
      try
      {
        paramView = (String)((ViewTransformer)paramView.findViewById(2131367959)).getTag();
        if (!TextUtils.isEmpty(paramView))
        {
          bool = "check".equals(paramView);
          if (bool)
          {
            bool = true;
            return bool;
          }
        }
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return false;
      }
      boolean bool = false;
    }
  }
  
  private int b()
  {
    int i1 = HbSkinInfo.a(this.jdField_a_of_type_CooperationQwalletPluginQwAdapter.getList());
    if (this.jdField_g_of_type_Int != i1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CommonHbFragment", 2, "set select skin id : " + i1 + " serverSkinId = " + this.jdField_g_of_type_Int);
      }
      RedPacketManager.getInstance().setSelectedSkin(i1, this.jdField_a_of_type_MqqObserverBusinessObserver);
    }
    return i1;
  }
  
  private void b(int paramInt)
  {
    View localView1 = this.jdField_b_of_type_AndroidViewView.findViewById(2131367949);
    View localView2 = this.jdField_a_of_type_AndroidViewView.findViewById(2131367949);
    localView1.setVisibility(paramInt);
    localView2.setVisibility(paramInt);
  }
  
  private void b(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = this.s;
    }
    paramString = this.jdField_b_of_type_JavaUtilList.iterator();
    while (paramString.hasNext()) {
      ((TextView)paramString.next()).setHint(str);
    }
  }
  
  private void b(List paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SkinInfo localSkinInfo = ((HbSkinInfo)paramList.next()).jdField_a_of_type_WalletSkinInfo;
      RedPacketInfoBase localRedPacketInfoBase = new RedPacketInfoBase();
      localRedPacketInfoBase.skinType = 1;
      localRedPacketInfoBase.skinId = localSkinInfo.skin_id;
      localRedPacketInfoBase.isCache = HbSkinInfo.jdField_a_of_type_Boolean;
      RedPacketManager.getInstance().getSkin(localRedPacketInfoBase, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketIRedPacket$OnGetSkinListener);
    }
  }
  
  private boolean b()
  {
    if (this.jdField_b_of_type_AndroidWidgetEditText == null) {}
    for (;;)
    {
      return true;
      String str = this.jdField_b_of_type_AndroidWidgetEditText.getText().toString();
      if (TextUtils.isEmpty(str)) {
        return false;
      }
      try
      {
        if (Integer.parseInt(str) < 1)
        {
          str = getString(2131431335);
          if (str != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.c(str);
          }
          return false;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localNumberFormatException.printStackTrace();
      }
    }
    return false;
  }
  
  private void c(String paramString)
  {
    ThreadManager.post(new xai(this, paramString), 5, null, true);
  }
  
  private boolean c()
  {
    int i1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().length();
    String str1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if ((i1 == 0) || (str1.startsWith(".")) || (str1.endsWith("."))) {
      this.jdField_d_of_type_JavaLangString = "";
    }
    for (;;)
    {
      return false;
      if (TextUtils.isEmpty(str1))
      {
        this.jdField_d_of_type_JavaLangString = "";
        return false;
      }
      if (str1.indexOf('.') == 0)
      {
        this.jdField_d_of_type_JavaLangString = "";
        return false;
      }
      if ((str1.indexOf('.') > 0) && (str1.indexOf('.') < str1.length() - 3))
      {
        str1 = getString(2131431343);
        if (str1 != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.c(str1);
        }
        this.jdField_d_of_type_JavaLangString = "";
        return false;
      }
      try
      {
        if (Double.valueOf(str1).doubleValue() <= 0.0D)
        {
          this.jdField_d_of_type_JavaLangString = "";
          return false;
        }
        if ("2".equals(this.jdField_f_of_type_JavaLangString)) {
          str1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
        }
        while (Double.valueOf(str1).doubleValue() >= 0.01D)
        {
          return true;
          if (this.jdField_b_of_type_AndroidWidgetEditText == null)
          {
            str1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
          }
          else
          {
            str1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
            String str2 = this.jdField_b_of_type_AndroidWidgetEditText.getText().toString();
            SendHbLogic localSendHbLogic = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentSendHbLogic;
            this.jdField_d_of_type_JavaLangString = SendHbLogic.a(str1, str2);
            str1 = this.jdField_d_of_type_JavaLangString;
          }
        }
        return false;
      }
      catch (Exception localException) {}
    }
  }
  
  private void d()
  {
    this.jdField_d_of_type_AndroidViewView.post(new xae(this));
    this.jdField_d_of_type_AndroidViewView.postDelayed(new xaf(this), 50L);
  }
  
  private void e()
  {
    Object localObject1 = new ArrayList();
    ((List)localObject1).add(HbSkinInfo.a(this.s));
    this.jdField_a_of_type_CooperationQwalletPluginQwAdapter = new QwAdapter(getActivity(), (List)localObject1, 2130969774, new CommonHbFragment.HbSkinHolder(this));
    if ((!jdField_c_of_type_JavaUtilList.contains(this.jdField_a_of_type_JavaLangString)) || (RedPacketManager.getInstance().isRiskSwitchOpen()))
    {
      b(8);
      return;
    }
    Object localObject2 = (LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131367950);
    localObject1 = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131367950);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, AIOUtils.a(226.0F, ((LinearLayout)localObject1).getResources()));
    HorizontalListView localHorizontalListView = new HorizontalListView(getActivity());
    localHorizontalListView.setDividerWidth(AIOUtils.a(12, getActivity().getResources()));
    ((LinearLayout)localObject2).addView(localHorizontalListView, localLayoutParams);
    localHorizontalListView.setAdapter(this.jdField_a_of_type_CooperationQwalletPluginQwAdapter);
    localHorizontalListView.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
    localObject2 = new HorizontalListView(getActivity());
    ((HorizontalListView)localObject2).setDividerWidth(AIOUtils.a(12, getActivity().getResources()));
    ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams);
    ((HorizontalListView)localObject2).setAdapter(this.jdField_a_of_type_CooperationQwalletPluginQwAdapter);
    ((HorizontalListView)localObject2).setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
    this.jdField_a_of_type_CooperationQwalletPluginQwAdapter.notifyDataSetChanged();
    RedPacketManager.getInstance().registRedPacketSkinListObserver(this.jdField_a_of_type_MqqObserverBusinessObserver);
    RedPacketManager.getInstance().requestRedPacketSkinList();
  }
  
  private void f()
  {
    boolean bool = true;
    Bundle localBundle = getArguments();
    this.jdField_a_of_type_JavaLangString = localBundle.getString("channel");
    this.jdField_b_of_type_JavaLangString = localBundle.getString("redgift_type");
    this.jdField_c_of_type_JavaLangString = localBundle.getString("redgift_subtype");
    this.jdField_e_of_type_JavaLangString = localBundle.getString("placeholder");
    this.j = localBundle.getString("people_num");
    this.k = localBundle.getString("recv_type");
    this.jdField_f_of_type_JavaLangString = localBundle.getString("bus_type");
    this.jdField_g_of_type_JavaLangString = localBundle.getString("recv_uin");
    for (;;)
    {
      try
      {
        String str = localBundle.getString("config");
        if (!TextUtils.isEmpty(str))
        {
          this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject(str);
          if ((this.jdField_a_of_type_OrgJsonJSONObject != null) && (("2".equals(this.k)) || ("3".equals(this.k)) || ("1".equals(this.k)) || (TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString))))
          {
            if (this.jdField_a_of_type_OrgJsonJSONObject.optInt("switch") != 1) {
              continue;
            }
            this.jdField_d_of_type_Boolean = bool;
            this.jdField_f_of_type_Int = this.jdField_a_of_type_OrgJsonJSONObject.optInt("voicefirst");
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      this.h = localBundle.getString("feedsid");
      this.r = localBundle.getString("wish_switch");
      this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager = ((IndividualRedPacketManager)getActivity().getAppRuntime().getManager(130));
      this.jdField_a_of_type_Long = (DeviceInfoUtil.f() * 1024L * 1024L);
      this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
      return;
      bool = false;
    }
  }
  
  private void g()
  {
    if (!this.jdField_d_of_type_Boolean)
    {
      h();
      return;
    }
    i();
  }
  
  private void h()
  {
    this.jdField_c_of_type_AndroidWidgetTextView.setText("小伙伴需录入语音抢红包");
    this.jdField_b_of_type_AndroidWidgetTextView.setText("改为文字口令");
    Drawable localDrawable = getResources().getDrawable(2130841116);
    localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
    this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, localDrawable, null);
    this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.a(5.0F, getResources()));
    if ((this.jdField_a_of_type_OrgJsonJSONObject != null) && (this.jdField_a_of_type_OrgJsonJSONObject.has("tips"))) {
      this.jdField_c_of_type_AndroidWidgetEditText.setHint(this.jdField_a_of_type_OrgJsonJSONObject.optString("tips"));
    }
    this.jdField_d_of_type_Boolean = true;
  }
  
  private void i()
  {
    this.jdField_c_of_type_AndroidWidgetTextView.setText("小伙伴需回复口令抢红包");
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setText("改为语音口令");
    Drawable localDrawable = getResources().getDrawable(2130841117);
    localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
    this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, localDrawable, null);
    this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.a(5.0F, getResources()));
    this.jdField_d_of_type_Boolean = false;
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_AndroidTextTextWatcher == null)) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (View)localIterator.next();
      if (localObject != null)
      {
        EditText localEditText = (EditText)((View)localObject).findViewById(2131367918);
        if (localEditText != null) {
          localEditText.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
        }
        localEditText = (EditText)((View)localObject).findViewById(2131367956);
        if (localEditText != null) {
          localEditText.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
        }
        localObject = (EditText)((View)localObject).findViewById(2131364166);
        if (localObject != null) {
          ((EditText)localObject).removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
        }
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList = null;
  }
  
  public int a()
  {
    int i1 = -1;
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null) {
      i1 = this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem();
    }
    return i1;
  }
  
  public long a(String paramString)
  {
    try
    {
      long l1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(paramString).getTime();
      return l1;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0L;
  }
  
  public String a()
  {
    if ((this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null) && ((this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem() == 2) || ((("1".equals(this.k)) || ("7".equals(this.k))) && (this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem() == 1))))
    {
      if (("5".equals(this.jdField_a_of_type_JavaLangString)) || ("16".equals(this.jdField_a_of_type_JavaLangString))) {
        return "48";
      }
      if (this.jdField_d_of_type_Boolean) {
        return "65536";
      }
      return "32";
    }
    if ((a()) && (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.a().contains(this.jdField_a_of_type_JavaLangString))) {
      return "8";
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  protected void a()
  {
    if (!isAdded()) {}
    for (;;)
    {
      return;
      this.s = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.getResources().getString(2131431248);
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.getCurrentAccountUin();
      this.q = ((String)localObject1);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131363227));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_d_of_type_AndroidViewView.findViewById(2131363410));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      if ("512".equals(this.jdField_a_of_type_JavaLangString))
      {
        if (!this.jdField_c_of_type_Boolean) {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        label124:
        c((String)localObject1);
        localObject1 = (TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131363363);
        if (!"512".equals(this.jdField_a_of_type_JavaLangString)) {
          break label1140;
        }
        ((TextView)localObject1).setText(getString(2131431522));
        label167:
        this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_d_of_type_AndroidViewView.findViewById(2131367799));
        this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
        this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_d_of_type_AndroidViewView.findViewById(2131367800));
        this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
        this.jdField_d_of_type_AndroidWidgetButton = ((Button)this.jdField_d_of_type_AndroidViewView.findViewById(2131367801));
        this.jdField_d_of_type_AndroidWidgetButton.setOnClickListener(this);
        if ("1".equals(this.k)) {
          this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
        }
        if (("6".equals(this.k)) || ("2048".equals(this.jdField_a_of_type_JavaLangString)) || ("512".equals(this.jdField_a_of_type_JavaLangString))) {
          this.jdField_d_of_type_AndroidWidgetButton.setVisibility(8);
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_d_of_type_AndroidViewView.findViewById(2131363362));
        localObject1 = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity);
        this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)localObject1).inflate(2130969804, null);
        this.jdField_b_of_type_AndroidViewView = ((LayoutInflater)localObject1).inflate(2130969791, null);
        this.jdField_c_of_type_AndroidViewView = ((LayoutInflater)localObject1).inflate(2130969788, null);
        this.jdField_b_of_type_JavaUtilList.add((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131367956));
        this.jdField_b_of_type_JavaUtilList.add((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367956));
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
        if (!"4096".equals(this.jdField_a_of_type_JavaLangString)) {
          break label1176;
        }
        if (("1".equals(this.k)) || ("7".equals(this.k)) || ("6".equals(this.k))) {
          break label1150;
        }
        this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_AndroidViewView);
        a(this.jdField_a_of_type_AndroidViewView, 0);
        label500:
        a(this.jdField_a_of_type_JavaUtilList);
        this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_d_of_type_AndroidViewView.findViewById(2131367803));
        this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)this.jdField_d_of_type_AndroidViewView.findViewById(2131367804));
        this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter);
        this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.notifyDataSetChanged();
        this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(this);
      }
      try
      {
        localObject1 = ViewPager.class.getDeclaredField("mScroller");
        ((Field)localObject1).setAccessible(true);
        Object localObject2 = new CommonHbFragment.FixedSpeedScroller(this, this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getContext(), new AccelerateDecelerateInterpolator());
        ((Field)localObject1).set(this.jdField_a_of_type_AndroidSupportV4ViewViewPager, localObject2);
        ((CommonHbFragment.FixedSpeedScroller)localObject2).a(200);
        label625:
        this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_d_of_type_AndroidViewView.findViewById(2131367802));
        localObject1 = new DisplayMetrics();
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
        float f1 = getResources().getDisplayMetrics().density;
        label718:
        int i1;
        if (this.jdField_a_of_type_JavaUtilList.size() == 2)
        {
          this.jdField_b_of_type_Int = ((int)(55.0F * f1));
          if ("2048".equals(this.jdField_a_of_type_JavaLangString))
          {
            this.jdField_c_of_type_Int = 5;
            this.jdField_e_of_type_Int = (((DisplayMetrics)localObject1).widthPixels - this.jdField_b_of_type_Int * 2);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(this.jdField_b_of_type_Int, 0, this.jdField_b_of_type_Int, 0);
            if (this.jdField_a_of_type_JavaUtilList.size() <= 0) {
              break label1365;
            }
            i1 = this.jdField_a_of_type_JavaUtilList.size();
            label772:
            this.jdField_a_of_type_Int = (this.jdField_e_of_type_Int / i1 / 2);
            localObject1 = new LinearLayout.LayoutParams(this.jdField_a_of_type_Int * 2, (int)(f1 * 4.0F));
            this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            new Matrix().postTranslate(this.jdField_a_of_type_Int, 0.0F);
            i1 = (int)((this.jdField_c_of_type_Int * 16 + 10) * this.jdField_a_of_type_Float);
            this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(new LinearLayout.LayoutParams(i1, (int)(4.0F * this.jdField_a_of_type_Float)));
            this.jdField_b_of_type_AndroidWidgetLinearLayout.setGravity(1);
            if (!jdField_d_of_type_JavaUtilList.contains(this.k)) {
              break label1370;
            }
            a(1);
            this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(1);
            ((LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.findViewById(2131367975).getLayoutParams()).setMargins(0, AIOUtils.a(10.0F, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.getResources()), 0, 0);
          }
        }
        while ("4096".equals(this.jdField_a_of_type_JavaLangString))
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_d_of_type_AndroidWidgetButton.setVisibility(8);
          localObject1 = (View)this.jdField_c_of_type_AndroidWidgetButton.getParent();
          localObject2 = (View)((View)localObject1).getParent();
          f1 = getResources().getDisplayMetrics().density;
          ((View)localObject2).getLayoutParams().height = ((int)(20.0F * f1 + 0.5F));
          ((View)localObject2).setBackgroundColor(Color.rgb(247, 240, 242));
          this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
          ((View)localObject1).setVisibility(4);
          localObject1 = (LinearLayout)this.jdField_d_of_type_AndroidViewView.findViewById(2131367802);
          if (localObject1 == null) {
            break;
          }
          ((LinearLayout)localObject1).getChildAt(0).setVisibility(8);
          ((LinearLayout)localObject1).getLayoutParams().height = ((int)(f1 * 0.5F + 0.5F));
          ((LinearLayout)localObject1).setBackgroundColor(getResources().getColor(2131493675));
          return;
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          break label124;
          label1140:
          ((TextView)localObject1).setText(2131431237);
          break label167;
          label1150:
          this.jdField_a_of_type_JavaUtilList.add(this.jdField_b_of_type_AndroidViewView);
          a(this.jdField_b_of_type_AndroidViewView, 1);
          break label500;
          label1176:
          if (jdField_d_of_type_JavaUtilList.contains(this.k))
          {
            this.jdField_a_of_type_JavaUtilList.add(this.jdField_b_of_type_AndroidViewView);
            a(this.jdField_b_of_type_AndroidViewView, 1);
            break label500;
          }
          if (!"1".equals(this.k))
          {
            this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_AndroidViewView);
            a(this.jdField_a_of_type_AndroidViewView, 0);
          }
          this.jdField_a_of_type_JavaUtilList.add(this.jdField_b_of_type_AndroidViewView);
          a(this.jdField_b_of_type_AndroidViewView, 1);
          if (("6".equals(this.k)) || ("512".equals(this.jdField_a_of_type_JavaLangString)) || ("2048".equals(this.jdField_a_of_type_JavaLangString))) {
            break label500;
          }
          this.jdField_a_of_type_JavaUtilList.add(this.jdField_c_of_type_AndroidViewView);
          a(this.jdField_c_of_type_AndroidViewView, 2);
          break label500;
          this.jdField_c_of_type_Int = 4;
          break label718;
          this.jdField_b_of_type_Int = ((int)(15.0F * f1));
          this.jdField_c_of_type_Int = 5;
          break label718;
          label1365:
          i1 = 1;
          break label772;
          label1370:
          if ("1".equals(this.k))
          {
            a(1);
            this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(0);
          }
          else if (("6".equals(this.jdField_a_of_type_JavaLangString)) || ("32".equals(this.jdField_a_of_type_JavaLangString)))
          {
            this.jdField_f_of_type_JavaLangString = "2";
            a(2);
            this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(2);
          }
          else if ("1".equals(this.jdField_f_of_type_JavaLangString))
          {
            a(1);
            this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(1);
          }
          else if ("2".equals(this.jdField_f_of_type_JavaLangString))
          {
            a(0);
            this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(0);
          }
          else
          {
            this.jdField_f_of_type_JavaLangString = "2";
            a(0);
            this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(0);
          }
        }
      }
      catch (Exception localException)
      {
        break label625;
      }
    }
  }
  
  public void a(int paramInt)
  {
    double d1 = 0.01D;
    Object localObject;
    View localView1;
    View localView2;
    String str1;
    double d2;
    if (1 == this.jdField_a_of_type_JavaUtilList.size())
    {
      localObject = (View)this.jdField_a_of_type_JavaUtilList.get(0);
      this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)((View)localObject).findViewById(2131364166));
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)((View)localObject).findViewById(2131367918));
      this.jdField_c_of_type_AndroidWidgetEditText = ((EditText)((View)localObject).findViewById(2131367956));
      localView1 = ((View)localObject).findViewById(2131367986);
      localView2 = ((View)localObject).findViewById(2131367987);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)((View)localObject).findViewById(2131364058));
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
      this.jdField_d_of_type_JavaLangString = "";
      str1 = "1";
      if (!TextUtils.isEmpty(this.o)) {
        str1 = this.o;
      }
      if (TextUtils.isEmpty(this.m)) {
        break label542;
      }
      if (!"1".equals(this.jdField_f_of_type_JavaLangString)) {
        break label549;
      }
      SendHbLogic localSendHbLogic = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentSendHbLogic;
      d2 = SendHbLogic.a(this.m, str1, 2);
      if (d2 >= 0.01D) {
        break label857;
      }
    }
    for (;;)
    {
      try
      {
        str1 = new DecimalFormat("#0.00").format(d1);
        this.jdField_a_of_type_AndroidWidgetEditText.setText(str1);
        if (!TextUtils.isEmpty(this.o)) {
          this.jdField_b_of_type_AndroidWidgetEditText.setText(this.o);
        }
        if ((TextUtils.isEmpty(this.n)) || (paramInt == 2) || (this.jdField_c_of_type_AndroidWidgetEditText == null)) {
          break label558;
        }
        this.jdField_c_of_type_AndroidWidgetEditText.setText(this.n);
        if (paramInt != 0) {
          break label577;
        }
        this.jdField_c_of_type_AndroidWidgetButton.setActivated(true);
        this.jdField_b_of_type_AndroidWidgetButton.setActivated(false);
        this.jdField_d_of_type_AndroidWidgetButton.setActivated(false);
        this.jdField_c_of_type_AndroidWidgetButton.setContentDescription("已选中，拼手气红包");
        this.jdField_b_of_type_AndroidWidgetButton.setContentDescription(getString(2131431239));
        this.jdField_d_of_type_AndroidWidgetButton.setContentDescription(getString(2131431411));
        if (("6".equals(this.jdField_a_of_type_JavaLangString)) || ("32".equals(this.jdField_a_of_type_JavaLangString))) {
          this.jdField_a_of_type_JavaLangString = "1";
        }
        this.jdField_f_of_type_JavaLangString = "2";
        localObject = a();
        if ((paramInt != 2) && ((paramInt != 1) || ((!"1".equals(this.k)) && (!"7".equals(this.k))))) {
          break label852;
        }
        paramInt = 1;
        if ((this.jdField_c_of_type_AndroidWidgetEditText != null) && (paramInt == 0) && ("512".equals(localObject)))
        {
          if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
            this.jdField_c_of_type_AndroidWidgetEditText.setHint(this.jdField_e_of_type_JavaLangString);
          }
          a(this.r, this.jdField_c_of_type_AndroidWidgetEditText, localView1, localView2);
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      if (!"1".equals(this.k))
      {
        localObject = (View)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        break;
      }
      localObject = (View)this.jdField_a_of_type_JavaUtilList.get(paramInt - 1);
      break;
      label542:
      String str2 = "";
      continue;
      label549:
      str2 = this.m;
      continue;
      label558:
      if (this.jdField_c_of_type_AndroidWidgetEditText != null)
      {
        this.jdField_c_of_type_AndroidWidgetEditText.setText("");
        continue;
        label577:
        if (paramInt == 1)
        {
          this.jdField_b_of_type_AndroidWidgetButton.setActivated(true);
          this.jdField_c_of_type_AndroidWidgetButton.setActivated(false);
          this.jdField_d_of_type_AndroidWidgetButton.setActivated(false);
          this.jdField_b_of_type_AndroidWidgetButton.setContentDescription("已选中，普通红包");
          this.jdField_c_of_type_AndroidWidgetButton.setContentDescription(getString(2131431238));
          this.jdField_d_of_type_AndroidWidgetButton.setContentDescription(getString(2131431411));
          if (("6".equals(this.jdField_a_of_type_JavaLangString)) || ("32".equals(this.jdField_a_of_type_JavaLangString))) {
            this.jdField_a_of_type_JavaLangString = "1";
          }
          this.jdField_f_of_type_JavaLangString = "1";
        }
        else if (paramInt == 2)
        {
          this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131367958));
          this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131367957));
          this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131367955));
          this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new wzp(this));
          if (this.jdField_d_of_type_Boolean)
          {
            this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            if (this.jdField_f_of_type_Int != 1) {
              break label845;
            }
            h();
          }
          for (;;)
          {
            this.jdField_d_of_type_AndroidWidgetButton.setActivated(true);
            this.jdField_b_of_type_AndroidWidgetButton.setActivated(false);
            this.jdField_c_of_type_AndroidWidgetButton.setActivated(false);
            this.jdField_d_of_type_AndroidWidgetButton.setContentDescription("已选中，口令红包");
            this.jdField_b_of_type_AndroidWidgetButton.setContentDescription(getString(2131431239));
            this.jdField_c_of_type_AndroidWidgetButton.setContentDescription(getString(2131431238));
            this.jdField_f_of_type_JavaLangString = "2";
            break;
            label845:
            i();
          }
          label852:
          paramInt = 0;
          continue;
          label857:
          d1 = d2;
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    if ((!isAdded()) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.getFilesDir().getPath() + "/QWallet/" + paramString + "/hbThemeConfig.cfg";
    ThreadManager.getFileThreadHandler().post(new wzx(this, paramString));
  }
  
  @TargetApi(11)
  public void a(ArrayList paramArrayList)
  {
    Object localObject1 = null;
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager == null) {}
    int i1;
    Object localObject2;
    LinearLayout localLinearLayout;
    do
    {
      do
      {
        do
        {
          return;
          i1 = this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem();
        } while ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= i1));
        localObject2 = (View)this.jdField_a_of_type_JavaUtilList.get(i1);
      } while (localObject2 == null);
      localLinearLayout = (LinearLayout)((View)localObject2).findViewById(2131367982);
    } while (localLinearLayout == null);
    if ((paramArrayList != null) && (paramArrayList.size() > 1))
    {
      localObject1 = (ArrayList)paramArrayList.get(0);
      paramArrayList = (ArrayList)paramArrayList.get(1);
    }
    for (;;)
    {
      ((View)localObject2).setTag(localObject1);
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        localLinearLayout.removeAllViews();
        int i2 = ((ArrayList)localObject1).size();
        localStringBuffer = new StringBuffer();
        i1 = 0;
        for (;;)
        {
          if (i1 < i2) {
            try
            {
              localObject2 = (String)((ArrayList)localObject1).get(i1);
              ImageView localImageView = new ImageView(getActivity());
              int i3 = (int)(this.jdField_a_of_type_Float * 30.0F);
              int i4 = (int)(2.5D * this.jdField_a_of_type_Float + 0.5D);
              LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i3, i3);
              localLayoutParams.setMargins(i4, 0, i4, 0);
              localImageView.setLayoutParams(localLayoutParams);
              localImageView.setImageDrawable(FaceDrawable.a((QQAppInterface)getActivity().getAppRuntime(), 1, (String)localObject2));
              localLinearLayout.addView(localImageView);
              i1 += 1;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                localException.printStackTrace();
              }
            }
          }
        }
        if ((paramArrayList != null) && (paramArrayList.size() > 0))
        {
          i1 = 0;
          while (i1 < paramArrayList.size())
          {
            if (!TextUtils.isEmpty((CharSequence)paramArrayList.get(i1))) {
              localStringBuffer.append((String)paramArrayList.get(i1));
            }
            localStringBuffer.append(" ,");
            i1 += 1;
          }
        }
        this.jdField_b_of_type_AndroidWidgetEditText.setText(String.valueOf(i2));
        if (TextUtils.isEmpty(localStringBuffer)) {
          break;
        }
        localLinearLayout.setContentDescription("已选择" + i2 + "个," + localStringBuffer.toString());
        return;
      }
      if ((localObject1 == null) || (((ArrayList)localObject1).size() != 0)) {
        break;
      }
      localLinearLayout.removeAllViews();
      localLinearLayout.setContentDescription("请选择领取人");
      paramArrayList = new TextView(getActivity());
      if (Build.VERSION.SDK_INT >= 11) {
        paramArrayList.setRight((int)(this.jdField_a_of_type_Float * 6.0F));
      }
      paramArrayList.setText("请选择领取人");
      paramArrayList.setTextSize(17.0F);
      paramArrayList.setTextColor(getActivity().getResources().getColor(2131493637));
      localLinearLayout.addView(paramArrayList);
      this.jdField_b_of_type_AndroidWidgetEditText.setText("");
      return;
      StringBuffer localStringBuffer = null;
      paramArrayList = (ArrayList)localObject1;
      localObject1 = localStringBuffer;
    }
  }
  
  protected void a(List paramList)
  {
    if (paramList.size() <= 1) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      View localView = (View)paramList.next();
      if ((localView instanceof QwScrollView)) {
        ((QwScrollView)localView).setOnQwScrollListener(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetQwScrollView$OnQwScrollListener);
      }
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBaseHbFragment$HBConfig = new BaseHbFragment.HBConfig(paramJSONObject);
      try
      {
        paramJSONObject = (String)this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBaseHbFragment$HBConfig.a.get("begin_time");
        String str1 = (String)this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBaseHbFragment$HBConfig.a.get("end_time");
        String str2 = (String)this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBaseHbFragment$HBConfig.a.get("wishing");
        if (!TextUtils.isEmpty(str2)) {
          this.s = str2;
        }
        if ((!TextUtils.isEmpty(paramJSONObject)) && (!TextUtils.isEmpty(str1)))
        {
          long l1 = a(paramJSONObject);
          long l2 = a(str1);
          long l3 = System.currentTimeMillis();
          if ((l3 > l1) && (l3 < l2))
          {
            this.jdField_d_of_type_AndroidViewView.post(new wzy(this));
            return;
          }
        }
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
  
  public void a(boolean paramBoolean, View paramView)
  {
    ViewGroup localViewGroup1 = (ViewGroup)paramView.findViewById(2131367976);
    ViewGroup localViewGroup2 = (ViewGroup)paramView.findViewById(2131367985);
    ViewGroup localViewGroup3 = (ViewGroup)paramView.findViewById(2131367974);
    paramView = (ImageView)paramView.findViewById(2131367984);
    if ((localViewGroup1 == null) || (localViewGroup2 == null) || (localViewGroup3 == null) || (paramView == null)) {}
    do
    {
      return;
      if (!paramBoolean) {
        break;
      }
    } while (this.jdField_a_of_type_Long < 10485760L);
    a(localViewGroup2, paramView);
    return;
    paramView.setImageDrawable(null);
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.performClick();
    }
  }
  
  public void c()
  {
    this.jdField_b_of_type_Long = System.currentTimeMillis();
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_b_of_type_AndroidWidgetEditText != null) {
      this.o = this.jdField_b_of_type_AndroidWidgetEditText.getText().toString();
    }
    if (this.jdField_c_of_type_AndroidWidgetEditText != null) {
      this.n = this.jdField_c_of_type_AndroidWidgetEditText.getText().toString();
    }
    this.m = this.p;
    int i1 = paramView.getId();
    if (i1 == 2131363227) {
      if (this.jdField_b_of_type_Boolean)
      {
        a("hongbao.wrap.keyback", "");
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.b(-1, null);
        if (this.jdField_c_of_type_AndroidWidgetEditText != null)
        {
          InputMethodUtil.b(this.jdField_c_of_type_AndroidWidgetEditText);
          this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.finish();
        }
      }
    }
    long l1;
    do
    {
      return;
      a("hongbao.wrap.back", "");
      break;
      if (i1 != 2131364058) {
        break label1123;
      }
      l1 = System.currentTimeMillis();
    } while (this.jdField_b_of_type_Long + 1000L > l1);
    String str = a();
    if ((this.jdField_d_of_type_Boolean) && ("65536".equals(str)))
    {
      if (a(this.n) < 4)
      {
        QQToast.a(getActivity(), 2131431524, 0).a();
        return;
      }
      paramView = a(this.n);
      if (paramView.length() > 0)
      {
        QQToast.a(getActivity(), String.format(getString(2131431523), new Object[] { Character.valueOf(paramView.charAt(0)) }), 0).a();
        return;
      }
    }
    this.jdField_b_of_type_Long = l1;
    paramView = new StringBuffer();
    paramView.append("number#");
    label387:
    Object localObject2;
    if (this.jdField_b_of_type_AndroidWidgetEditText != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.jdField_e_of_type_JavaLangString = this.jdField_b_of_type_AndroidWidgetEditText.getText().toString();
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.jdField_e_of_type_JavaLangString))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.jdField_e_of_type_JavaLangString = "1";
        paramView.append("1");
        paramView.append(",type#");
        if ((!"1".equals(this.k)) && (!"7".equals(this.k)) && (!"4".equals(this.k)) && (!"5".equals(this.k))) {
          break label797;
        }
        paramView.append("person");
        paramView.append(",channel#");
        paramView.append(str);
        paramView.append(",money#");
        if ((this.jdField_b_of_type_AndroidWidgetEditText != null) && (!"2".equals(this.jdField_f_of_type_JavaLangString))) {
          break label831;
        }
        localObject1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentSendHbLogic;
        paramView.append(SendHbLogic.a((String)localObject1));
        label457:
        a("hongbao.wrap.go", paramView.toString());
        paramView = "";
        if (this.jdField_c_of_type_AndroidWidgetEditText != null)
        {
          localObject1 = this.jdField_c_of_type_AndroidWidgetEditText.getText().toString();
          paramView = (View)localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            if (!TextUtils.isEmpty(this.jdField_c_of_type_AndroidWidgetEditText.getHint())) {
              break label852;
            }
            paramView = getResources().getString(2131431248);
          }
        }
        label525:
        if ((this.jdField_b_of_type_AndroidWidgetEditText != null) && (!"2".equals(this.jdField_f_of_type_JavaLangString))) {
          break label868;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
        label561:
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.jdField_d_of_type_JavaLangString)) {
          break label882;
        }
      }
    }
    label797:
    label831:
    label852:
    label868:
    label882:
    for (Object localObject1 = "1";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.jdField_d_of_type_JavaLangString)
    {
      ((SendHbActivity)localObject2).jdField_d_of_type_JavaLangString = ((String)localObject1);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.a();
      ((Map)localObject1).put("type", "1");
      ((Map)localObject1).put("wishing", paramView);
      ((Map)localObject1).put("bus_type", this.jdField_f_of_type_JavaLangString);
      ((Map)localObject1).put("total_num", this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.jdField_e_of_type_JavaLangString);
      ((Map)localObject1).put("total_amount", SendHbLogic.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.jdField_d_of_type_JavaLangString));
      if ((this.jdField_a_of_type_AndroidSupportV4ViewViewPager == null) || (this.jdField_a_of_type_JavaUtilList == null)) {
        break label1514;
      }
      i1 = this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem();
      paramView = (View)this.jdField_a_of_type_JavaUtilList.get(i1);
      if (!a(paramView)) {
        break label1514;
      }
      try
      {
        paramView = (ArrayList)paramView.getTag();
        str = a(paramView);
        if (!TextUtils.isEmpty(str)) {
          break label894;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.c("请选择领取人");
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
      paramView.append(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.jdField_e_of_type_JavaLangString);
      break;
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.jdField_e_of_type_JavaLangString = "1";
      paramView.append("1");
      break;
      if ("2".equals(this.k))
      {
        paramView.append("crowd");
        break label387;
      }
      paramView.append("group");
      break label387;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentSendHbLogic;
      paramView.append(SendHbLogic.a(this.jdField_d_of_type_JavaLangString));
      break label457;
      paramView = this.jdField_c_of_type_AndroidWidgetEditText.getHint().toString();
      break label525;
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.jdField_d_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      break label561;
    }
    label894:
    ((Map)localObject1).put("grab_uin_list", str);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.jdField_e_of_type_JavaLangString = String.valueOf(paramView.size());
    label1109:
    label1123:
    label1514:
    for (paramView = "1024";; paramView = str)
    {
      if ("512".equals(paramView))
      {
        ((Map)localObject1).put("feeds_sid", this.h);
        ((Map)localObject1).put("channel", paramView);
        if ((jdField_c_of_type_JavaUtilList.contains(paramView)) && (!"32".equals(paramView)))
        {
          paramView = new StringBuilder().append("");
          if (!a()) {
            break label1109;
          }
        }
      }
      for (i1 = -2;; i1 = HbSkinInfo.a(this.jdField_a_of_type_CooperationQwalletPluginQwAdapter.getList()))
      {
        ((Map)localObject1).put("skin_id", i1);
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentSendHbLogic.a((Map)localObject1);
        return;
        if (!"4096".equals(paramView)) {
          break;
        }
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.jdField_f_of_type_JavaLangString)) {
          ((Map)localObject1).put("feedsid", this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.jdField_f_of_type_JavaLangString);
        }
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.jdField_g_of_type_JavaLangString)) {
          break;
        }
        ((Map)localObject1).put("poi", this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.jdField_g_of_type_JavaLangString);
        break;
      }
      if (i1 == 2131367800)
      {
        if ((paramView instanceof Button)) {
          this.i = ((Button)paramView).getText().toString();
        }
        if ("1".equals(this.k))
        {
          if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem() == 0) {
            break;
          }
          a(1);
          this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(0, true);
          return;
        }
        if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem() == 1) {
          break;
        }
        a(1);
        this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(1, true);
        return;
      }
      if (i1 == 2131367799)
      {
        if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem() == 0) {
          break;
        }
        if ((paramView instanceof Button)) {
          this.i = ((Button)paramView).getText().toString();
        }
        a(0);
        this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(0, true);
        return;
      }
      if (i1 == 2131367801)
      {
        if ((paramView instanceof Button)) {
          this.i = ((Button)paramView).getText().toString();
        }
        if (("1".equals(this.k)) || ("7".equals(this.k)))
        {
          if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem() == 1) {
            break;
          }
          a(2);
          this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(1, true);
          return;
        }
        if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem() == 2) {
          break;
        }
        a(2);
        this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(2, true);
        return;
      }
      if ((i1 != 2131363410) || (getActivity() == null)) {
        break;
      }
      a("hongbao.wrap.vip", "");
      paramView = new Intent();
      paramView.setClass(getActivity(), QQBrowserActivity.class);
      if ("512".equals(this.jdField_a_of_type_JavaLangString)) {
        paramView.putExtra("url", "https://h5.qzone.qq.com/redpacket/skin/index?_proxy=1&_wv=16777219&feedsid=" + this.h);
      }
      for (;;)
      {
        paramView.putExtra("hide_operation_bar", true);
        paramView.putExtra("hide_more_button", true);
        paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
        startActivity(paramView);
        return;
        paramView.putExtra("url", this.l);
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = paramLayoutInflater.inflate(2130969757, null);
    boolean bool = getActivity().getPackageName().equals("com.tencent.qim");
    this.jdField_c_of_type_Boolean = bool;
    if (bool)
    {
      paramViewGroup = paramLayoutInflater.findViewById(2131363410);
      if (paramViewGroup != null) {
        paramViewGroup.setVisibility(8);
      }
    }
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    b();
    j();
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      this.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    }
    if (this.jdField_b_of_type_AndroidWidgetEditText != null) {
      this.jdField_b_of_type_AndroidWidgetEditText.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    }
    if (this.jdField_c_of_type_AndroidWidgetEditText != null) {
      this.jdField_c_of_type_AndroidWidgetEditText.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidTextTextWatcher = null;
    this.jdField_a_of_type_AndroidOsHandler = null;
    RedPacketManager.getInstance().registRedPacketSkinListObserver(null);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if (paramInt == 1)
    {
      a("hongbao.wrap.identical", "");
      int i1 = this.jdField_a_of_type_Int * 2;
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(this.jdField_d_of_type_Int * i1 + this.jdField_b_of_type_Int, i1 * paramInt, 0.0F, 0.0F);
      this.jdField_d_of_type_Int = paramInt;
      localTranslateAnimation.setFillAfter(true);
      localTranslateAnimation.setDuration(300L);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.startAnimation(localTranslateAnimation);
      if ("1".equals(this.k)) {
        break label207;
      }
      a(paramInt);
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(this.i)) && (this.jdField_c_of_type_Int > 0) && (this.i.length() > 0))
      {
        paramInt = (int)((this.jdField_c_of_type_Int * 16 + 10) * this.jdField_a_of_type_Float);
        this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(new LinearLayout.LayoutParams(paramInt, (int)(4.0F * this.jdField_a_of_type_Float)));
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setGravity(1);
        this.jdField_b_of_type_AndroidWidgetImageView.postInvalidate();
      }
      return;
      if (paramInt == 0)
      {
        a("hongbao.wrap.random", "");
        break;
      }
      if (paramInt != 2) {
        break;
      }
      a("hongbao.wrap.hopngbaokey", "");
      break;
      label207:
      a(paramInt + 1);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    boolean bool = a();
    a(bool);
    if (bool)
    {
      b(null);
      HbSkinInfo.jdField_c_of_type_Int = -1;
      this.jdField_a_of_type_CooperationQwalletPluginQwAdapter.notifyDataSetChanged();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    this.jdField_d_of_type_AndroidViewView = paramView;
    super.onViewCreated(paramView, paramBundle);
    try
    {
      f();
      a();
      e();
      d();
      a(this.q);
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.CommonHbFragment
 * JD-Core Version:    0.7.0.1
 */