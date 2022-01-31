package com.tencent.mobileqq.activity.qwallet.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.qwallet.FrameAnimHelper;
import com.tencent.mobileqq.activity.qwallet.PreloadImgManager;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import com.tencent.mobileqq.activity.qwallet.redpacket.ThemeRedPkgConfig;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletRedPkgUtils;
import com.tencent.mobileqq.activity.qwallet.widget.RollNumberView;
import com.tencent.mobileqq.activity.qwallet.widget.RollNumberView.OnRollListener;
import com.tencent.mobileqq.util.HbThemeConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xjr;
import xjs;
import xju;
import xjv;
import xjx;

public class ThemeHbFragment
  extends BaseHbFragment
  implements View.OnClickListener, Animation.AnimationListener, FragmentInterface, RollNumberView.OnRollListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private View jdField_a_of_type_AndroidViewView;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FrameAnimHelper jdField_a_of_type_ComTencentMobileqqActivityQwalletFrameAnimHelper;
  private ThemeRedPkgConfig jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketThemeRedPkgConfig;
  private RollNumberView jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetRollNumberView;
  public String a;
  public JSONArray a;
  private xjx jdField_a_of_type_Xjx = new xjx(this);
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private JSONArray jdField_b_of_type_OrgJsonJSONArray;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString = "";
  private JSONArray jdField_c_of_type_OrgJsonJSONArray;
  private int jdField_d_of_type_Int;
  private View jdField_d_of_type_AndroidViewView;
  private String jdField_d_of_type_JavaLangString = "";
  private JSONArray jdField_d_of_type_OrgJsonJSONArray;
  private String e;
  private String f = "1";
  private String g;
  
  public ThemeHbFragment()
  {
    this.jdField_a_of_type_JavaLangString = "1";
  }
  
  private int a(double paramDouble)
  {
    if (paramDouble >= 0.0D) {
      try
      {
        if (("64".equals(this.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.g)))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetRollNumberView.reset(paramDouble);
          String str = SendHbLogic.a(this.e, this.g);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_d_of_type_JavaLangString);
          this.jdField_a_of_type_AndroidWidgetButton.setText(String.format(getString(2131431538), new Object[] { this.g, str }));
          this.e = str;
          return 0;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetRollNumberView.reset(paramDouble);
        return 0;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return -1;
  }
  
  private Bundle a()
  {
    Bundle localBundle = getArguments();
    this.jdField_c_of_type_JavaLangString = localBundle.getString("channel");
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.d("红包类型错误！");
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.finish();
      return localBundle;
    }
    this.jdField_c_of_type_Int = Integer.valueOf(this.jdField_c_of_type_JavaLangString).intValue();
    return localBundle;
  }
  
  private void a()
  {
    this.jdField_a_of_type_Xjx.postDelayed(new xjr(this), 10L);
  }
  
  private void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.g = paramBundle.getString("group_count");
    this.jdField_a_of_type_Boolean = paramBundle.getBoolean("isGroupThemeHb");
    try
    {
      a(Integer.valueOf(paramBundle.getString("theme_type")).intValue());
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_c_of_type_AndroidWidgetTextView != null))
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(String.format(getString(2131431537), new Object[] { this.jdField_a_of_type_JavaLangString }));
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
      }
    }
  }
  
  private void a(String paramString)
  {
    b(paramString);
    if (("64".equals(this.jdField_c_of_type_JavaLangString)) || ((this.jdField_c_of_type_Int & 0x40) > 0) || (this.jdField_c_of_type_Int == 16384))
    {
      paramString = a(-11001, "", "");
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.setResult(-1, paramString);
    }
    if (isAdded())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.a(-1);
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.finish();
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.overridePendingTransition(0, 0);
    }
  }
  
  private void b()
  {
    int j = new Random(System.currentTimeMillis()).nextInt(this.jdField_d_of_type_OrgJsonJSONArray.length());
    int i = j;
    if (j == this.jdField_d_of_type_Int) {
      i = j + 1;
    }
    this.jdField_d_of_type_Int = i;
    if (this.jdField_d_of_type_Int >= this.jdField_d_of_type_OrgJsonJSONArray.length()) {}
    for (i = 0;; i = this.jdField_d_of_type_Int)
    {
      this.jdField_d_of_type_Int = i;
      try
      {
        String str = this.jdField_d_of_type_OrgJsonJSONArray.optString(this.jdField_d_of_type_Int);
        this.e = str;
        float f1 = Float.parseFloat(str);
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetRollNumberView.reset(f1);
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetRollNumberView.roll();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void b(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramBundle = HbThemeConfigManager.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity);
    if (paramBundle == null) {}
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject("{\"hb_face_desc\":\" 让对方做表情领红包\",\"hb_face_imgurl\":\"\",\"hb_face_money_array\":[\"0.18\",\"1.18\",\"2.18\",\"6.18\",\"8.18\",\"18.00\"]}");
        paramBundle = localJSONObject;
        if (paramBundle != null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.d("配置异常！");
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.finish();
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramBundle.optString("hb_face_desc"));
    Object localObject = paramBundle.optString("hb_face_imgurl");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = PreloadImgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
    }
    this.jdField_d_of_type_OrgJsonJSONArray = paramBundle.optJSONArray("hb_face_money_array");
    b();
  }
  
  private void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.a(paramString, 2);
    }
  }
  
  private void d()
  {
    int j = 0;
    if ((this.jdField_a_of_type_AndroidViewView == null) || (!isAdded())) {
      return;
    }
    ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367829);
    if (localImageView != null)
    {
      if (QWalletRedPkgUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity))
      {
        i = 8;
        localImageView.setVisibility(i);
        localImageView.setOnClickListener(this);
      }
    }
    else
    {
      localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364003);
      if (localImageView != null) {
        if (!QWalletRedPkgUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity)) {
          break label321;
        }
      }
    }
    label321:
    for (int i = j;; i = 8)
    {
      localImageView.setVisibility(i);
      localImageView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetRollNumberView = ((RollNumberView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367930));
      this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity, 2131034291);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367928));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367869));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131367934));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131367925));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131367868));
      this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131367931);
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131367929);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131367924);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367927));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367926));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367980));
      return;
      i = 0;
      break;
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetRollNumberView.setLisener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    if ("64".equals(this.jdField_c_of_type_JavaLangString)) {
      this.f = "1";
    }
    if (isAdded()) {
      ((InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getWindowToken(), 0);
    }
  }
  
  private void f()
  {
    if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (!isAdded()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ThemeHbFragment", 2, "theme config bak img error...");
      }
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = PreloadImgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("ThemeHbFragment", 2, "setImageBgProcess mHbBitmap = " + this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ThemeHbFragment", 2, "setImageBgProcess not exist, start download...");
    }
    PreloadImgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString, new xjs(this));
  }
  
  private void g()
  {
    if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (!isAdded()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ThemeHbFragment", 2, "setAnimFrameBgProcess theme config bak img error...");
      }
      return;
    }
    String str = PreloadImgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("ThemeHbFragment", 2, "setAnimFrameBgProcess zipName = " + str);
    }
    if ((!TextUtils.isEmpty(str)) && (new File(str).exists()) && (this.jdField_a_of_type_AndroidWidgetLinearLayout != null))
    {
      int i = (int)this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.getResources().getDimension(2131560172);
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFrameAnimHelper = new FrameAnimHelper(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity, this.jdField_a_of_type_AndroidWidgetLinearLayout, i, true, new xju(this));
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFrameAnimHelper.a(str, false);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ThemeHbFragment", 2, "setAnimFrameBgProcess not exist, start download...");
    }
    PreloadImgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString, ".zip", new xjv(this));
  }
  
  private void h()
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 2000L) {
      return;
    }
    this.jdField_a_of_type_Long = l;
    Object localObject2 = "";
    String str;
    for (Object localObject1 = localObject2;; str = "theme.pack.go") {
      try
      {
        if (this.jdField_c_of_type_OrgJsonJSONArray != null)
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_Int < this.jdField_c_of_type_OrgJsonJSONArray.length())
          {
            localObject1 = localObject2;
            if (this.jdField_a_of_type_Int >= 0) {
              localObject1 = this.jdField_c_of_type_OrgJsonJSONArray.optString(this.jdField_a_of_type_Int);
            }
          }
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = getResources().getString(2131431277);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.jdField_d_of_type_JavaLangString = this.e;
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.e = this.jdField_a_of_type_JavaLangString;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.a();
        ((Map)localObject1).put("total_num", this.jdField_a_of_type_JavaLangString);
        ((Map)localObject1).put("total_amount", SendHbLogic.a(this.e));
        ((Map)localObject1).put("wishing", localObject2);
        ((Map)localObject1).put("resource_type", this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketThemeRedPkgConfig.jdField_b_of_type_Int + "");
        ((Map)localObject1).put("channel", this.jdField_c_of_type_JavaLangString);
        ((Map)localObject1).put("type", this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketThemeRedPkgConfig.jdField_a_of_type_Int + "");
        ((Map)localObject1).put("bus_type", this.f);
        if (this.jdField_a_of_type_Boolean)
        {
          ((Map)localObject1).put("groupid", this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.jdField_b_of_type_JavaLangString);
          ((Map)localObject1).put("theme_type", this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.jdField_c_of_type_JavaLangString);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentSendHbLogic.a((Map)localObject1);
        if (this.jdField_c_of_type_Int == 16384)
        {
          localObject1 = "bqredpacket.order.send";
          b((String)localObject1);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
  }
  
  private void i()
  {
    QLog.i("ThemeHbFragment", 2, "clickFaceAction...");
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.b(this.e);
  }
  
  private void j()
  {
    Object localObject;
    if (this.jdField_a_of_type_Boolean) {
      if ((this.jdField_a_of_type_OrgJsonJSONArray != null) && (this.jdField_b_of_type_OrgJsonJSONArray != null)) {
        localObject = new Random();
      }
    }
    for (;;)
    {
      int i;
      try
      {
        if (this.jdField_b_of_type_Int <= 0) {
          break label441;
        }
        i = a(((Random)localObject).nextInt(this.jdField_b_of_type_Int));
        localException1.printStackTrace();
      }
      catch (Exception localException1)
      {
        try
        {
          this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_OrgJsonJSONArray.optString(i, "1");
          localObject = this.jdField_b_of_type_OrgJsonJSONArray.optString(i, "0.1");
          this.e = SendHbLogic.a(this.jdField_a_of_type_JavaLangString, (String)localObject);
          this.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_OrgJsonJSONArray.optString(i, getString(2131431445));
          j = i;
          if (a(new BigDecimal((String)localObject).doubleValue()) == 0)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetRollNumberView.roll();
            this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_d_of_type_JavaLangString);
            if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
              this.jdField_c_of_type_AndroidWidgetTextView.setText(String.format(getString(2131431537), new Object[] { this.jdField_a_of_type_JavaLangString }));
            }
            this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131431279) + " " + this.e + " 元");
            j = i;
          }
          if ((this.jdField_a_of_type_ArrayOfInt != null) && (this.jdField_a_of_type_ArrayOfInt.length > j)) {
            this.jdField_a_of_type_ArrayOfInt[j] = 1;
          }
          this.jdField_a_of_type_Int = j;
          return;
        }
        catch (Exception localException3)
        {
          int j;
          break label269;
        }
        localException1 = localException1;
        i = 0;
      }
      label269:
      j = i;
      continue;
      if ((this.jdField_c_of_type_OrgJsonJSONArray != null) && (this.jdField_b_of_type_OrgJsonJSONArray != null))
      {
        i = this.jdField_c_of_type_OrgJsonJSONArray.length();
        if (i > 0)
        {
          j = this.jdField_b_of_type_OrgJsonJSONArray.length();
          if ((j > 0) && (j == i))
          {
            i = a(new Random().nextInt(j));
            try
            {
              this.e = this.jdField_b_of_type_OrgJsonJSONArray.optString(i);
              double d1 = new BigDecimal(this.e).doubleValue();
              this.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_OrgJsonJSONArray.optString(i);
              if (a(d1) == 0) {
                this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetRollNumberView.roll();
              }
              if ((this.jdField_a_of_type_ArrayOfInt != null) && (this.jdField_a_of_type_ArrayOfInt.length > i)) {
                this.jdField_a_of_type_ArrayOfInt[i] = 1;
              }
              this.jdField_a_of_type_Int = i;
              return;
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                localException2.printStackTrace();
              }
            }
            label441:
            i = 0;
          }
        }
      }
    }
  }
  
  public int a(int paramInt)
  {
    if ((this.jdField_a_of_type_ArrayOfInt == null) || (this.jdField_a_of_type_ArrayOfInt.length <= paramInt) || (paramInt < 0))
    {
      i = 0;
      return i;
    }
    int k = this.jdField_a_of_type_ArrayOfInt.length;
    int i = 0;
    label33:
    int j;
    if (i < k)
    {
      j = (paramInt + i) % k;
      if (this.jdField_a_of_type_ArrayOfInt[j] != 0) {}
    }
    for (;;)
    {
      if (i == k)
      {
        j = 0;
        for (;;)
        {
          i = paramInt;
          if (j >= k) {
            break;
          }
          this.jdField_a_of_type_ArrayOfInt[j] = 0;
          j += 1;
        }
        i += 1;
        break label33;
      }
      return j;
      j = 0;
    }
  }
  
  public Intent a(int paramInt, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    if (paramInt == 0) {
      localIntent.putExtra("data", paramString2);
    }
    for (;;)
    {
      localIntent.putExtra("result", paramInt);
      return localIntent;
      localIntent.putExtra("retmsg", paramString1);
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ThemeHbFragment", 2, "parseThemeConfig themeId = " + paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketThemeRedPkgConfig = ((RedPacketManager)RedPacketManager.getInstance()).getThemeRedPkgConfById(paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketThemeRedPkgConfig == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.d(getString(2131431539));
    }
    int i;
    label266:
    label337:
    label342:
    do
    {
      do
      {
        return;
        this.jdField_c_of_type_OrgJsonJSONArray = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketThemeRedPkgConfig.jdField_a_of_type_OrgJsonJSONArray;
        this.jdField_b_of_type_OrgJsonJSONArray = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketThemeRedPkgConfig.jdField_b_of_type_OrgJsonJSONArray;
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketThemeRedPkgConfig.jdField_b_of_type_JavaLangString;
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_c_of_type_OrgJsonJSONArray = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketThemeRedPkgConfig.jdField_c_of_type_OrgJsonJSONArray;
          this.jdField_b_of_type_OrgJsonJSONArray = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketThemeRedPkgConfig.jdField_d_of_type_OrgJsonJSONArray;
          this.jdField_a_of_type_OrgJsonJSONArray = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketThemeRedPkgConfig.e;
          if (this.jdField_a_of_type_OrgJsonJSONArray == null) {
            this.jdField_a_of_type_OrgJsonJSONArray = new JSONArray();
          }
        }
        if (this.jdField_b_of_type_OrgJsonJSONArray == null) {
          this.jdField_b_of_type_OrgJsonJSONArray = new JSONArray();
        }
        if (this.jdField_c_of_type_OrgJsonJSONArray == null) {
          this.jdField_c_of_type_OrgJsonJSONArray = new JSONArray();
        }
        if (1 != this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketThemeRedPkgConfig.jdField_b_of_type_Int) {
          break;
        }
        g();
        if (!this.jdField_a_of_type_Boolean) {
          break label342;
        }
      } while ((this.jdField_a_of_type_OrgJsonJSONArray == null) || (this.jdField_b_of_type_OrgJsonJSONArray == null));
      i = this.jdField_a_of_type_OrgJsonJSONArray.length();
      paramInt = this.jdField_b_of_type_OrgJsonJSONArray.length();
      int j = this.jdField_c_of_type_OrgJsonJSONArray.length();
      if (j > paramInt)
      {
        paramInt = j;
        this.jdField_b_of_type_Int = paramInt;
        if (this.jdField_b_of_type_Int <= i) {
          break label337;
        }
      }
      for (paramInt = this.jdField_b_of_type_Int;; paramInt = i)
      {
        this.jdField_b_of_type_Int = paramInt;
        this.jdField_a_of_type_ArrayOfInt = new int[this.jdField_b_of_type_Int];
        return;
        this.jdField_b_of_type_JavaLangString += ".png";
        f();
        break;
        break label266;
      }
      if (this.jdField_b_of_type_OrgJsonJSONArray == null)
      {
        QLog.i("ThemeHbFragment", 2, "mArrMoney error, null checked...");
        return;
      }
      i = this.jdField_b_of_type_OrgJsonJSONArray.length();
      paramInt = this.jdField_c_of_type_OrgJsonJSONArray.length();
      Object localObject = getString(2131431445);
      if (i > paramInt) {
        while (paramInt < i)
        {
          this.jdField_c_of_type_OrgJsonJSONArray.put(localObject);
          paramInt += 1;
        }
      }
      if (i < paramInt)
      {
        localObject = new JSONArray();
        paramInt = 0;
        while (paramInt < i)
        {
          ((JSONArray)localObject).put(this.jdField_c_of_type_OrgJsonJSONArray.get(paramInt));
          paramInt += 1;
        }
        this.jdField_c_of_type_OrgJsonJSONArray = ((JSONArray)localObject);
      }
    } while (i <= 0);
    this.jdField_a_of_type_ArrayOfInt = new int[i];
  }
  
  public void c()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void complete()
  {
    if ((this.jdField_a_of_type_Int >= 0) && (this.jdField_a_of_type_Xjx != null))
    {
      Message localMessage = this.jdField_a_of_type_Xjx.obtainMessage();
      localMessage.what = 100;
      this.jdField_a_of_type_Xjx.sendMessage(localMessage);
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    j();
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    this.jdField_d_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    QLog.i("ThemeHbFragment", 2, "onAnimationStart...");
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131367931: 
      if (this.jdField_c_of_type_Int == 16384)
      {
        b("bqredpacket.order.randomamount");
        b();
        return;
      }
      b("theme.pack.change");
      j();
      return;
    case 2131367934: 
      if (this.jdField_c_of_type_Int == 16384)
      {
        i();
        return;
      }
      h();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFrameAnimHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFrameAnimHelper.a();
    }
    if (this.jdField_c_of_type_Int == 16384) {}
    for (paramView = "bqredpacket.order.close";; paramView = "theme.pack.back")
    {
      a(paramView);
      return;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramViewGroup = a();
    if (this.jdField_c_of_type_Int == 16384) {
      b("bqredpacket.order.expose");
    }
    int i;
    if (this.jdField_c_of_type_Int == 16384)
    {
      i = 2130969775;
      this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(i, null);
      d();
      if (this.jdField_c_of_type_Int != 16384) {
        break label96;
      }
      b(paramViewGroup);
    }
    for (;;)
    {
      a();
      e();
      return this.jdField_a_of_type_AndroidViewView;
      i = 2130969789;
      break;
      label96:
      a(paramViewGroup);
    }
  }
  
  public void onDestroyView()
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    super.onDestroyView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.ThemeHbFragment
 * JD-Core Version:    0.7.0.1
 */