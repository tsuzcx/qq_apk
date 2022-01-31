package com.tencent.mobileqq.armap.map;

import abnf;
import abnh;
import abnk;
import abnl;
import abnm;
import abno;
import abnq;
import abnr;
import abns;
import abnt;
import abnu;
import abnv;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.qq.im.poi.LbsPackInfo;
import com.qq.im.poi.LbsPackManager;
import com.qq.im.poi.LbsPackObserver;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.armap.ARMapManager;
import com.tencent.mobileqq.armap.ArMapInterface;
import com.tencent.mobileqq.armap.ArMapObserver;
import com.tencent.mobileqq.armap.ItemInfo;
import com.tencent.mobileqq.armap.NonMainAppHeadLoader;
import com.tencent.mobileqq.armap.NonMainAppHeadLoader.FaceObserver;
import com.tencent.mobileqq.armap.POIInfo;
import com.tencent.mobileqq.armap.POITaskInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.map.MapView;
import com.tencent.tencentmap.mapsdk.map.MapView.LayoutParams;
import com.tencent.tencentmap.mapsdk.map.Projection;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ARGridMapViewDialog
  extends Dialog
{
  private static int jdField_d_of_type_Int;
  private static int e = 1;
  private static int f = 2;
  private static int g = 4;
  int jdField_a_of_type_Int;
  public Activity a;
  public Context a;
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  public ProgressBar a;
  public RelativeLayout a;
  LbsPackObserver jdField_a_of_type_ComQqImPoiLbsPackObserver = new abno(this);
  LatLng jdField_a_of_type_ComTencentMapsdkRasterModelLatLng;
  public ArMapInterface a;
  private ArMapObserver jdField_a_of_type_ComTencentMobileqqArmapArMapObserver = new abnf(this);
  NonMainAppHeadLoader.FaceObserver jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader$FaceObserver = new abnm(this);
  MapView jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView;
  public Object a;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  public boolean a;
  int jdField_b_of_type_Int;
  View jdField_b_of_type_AndroidViewView;
  public RelativeLayout b;
  boolean jdField_b_of_type_Boolean;
  public int c;
  View jdField_c_of_type_AndroidViewView;
  RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  View jdField_d_of_type_AndroidViewView;
  
  public ARGridMapViewDialog(Activity paramActivity, ArMapInterface paramArMapInterface, MapView paramMapView, int paramInt1, int paramInt2, int paramInt3, Object paramObject, boolean paramBoolean)
  {
    super(paramActivity, 2131624516);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidContentContext = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface = paramArMapInterface;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView = paramMapView;
    this.jdField_b_of_type_Boolean = paramBoolean;
    d();
    e();
  }
  
  private void a(int paramInt)
  {
    if (POITaskInfo.jdField_d_of_type_Int == paramInt)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130842287);
      return;
    }
    if ((POITaskInfo.g == paramInt) || (paramInt == POITaskInfo.k))
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130842289);
      return;
    }
    if (POITaskInfo.f == paramInt)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130842286);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130842288);
  }
  
  private void a(int paramInt1, int paramInt2, String paramString)
  {
    paramString = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369649);
    ImageView localImageView = (ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369648);
    if (paramInt1 == POITaskInfo.j)
    {
      localImageView.setImageResource(2130842345);
      Drawable localDrawable = a("/17_armap_detailbg@2x.png");
      if (localDrawable != null) {
        this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(localDrawable);
      }
      paramString.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131493360));
      if ((paramInt2 != f) && (paramInt2 != e)) {
        break label204;
      }
      if (paramInt1 != POITaskInfo.f) {
        break label165;
      }
      paramString.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131438791));
      label113:
      localImageView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      return;
      localImageView.setImageResource(2130842305);
      break;
      label165:
      if (paramInt1 == POITaskInfo.j)
      {
        paramString.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131438793));
        break label113;
      }
      paramString.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131438786));
      break label113;
      label204:
      paramString.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131438787));
      localImageView.setVisibility(8);
    }
  }
  
  private void a(long paramLong1, int paramInt1, int paramInt2, long paramLong2, int paramInt3, String paramString1, String paramString2, String paramString3, int paramInt4, POIInfo paramPOIInfo)
  {
    Object localObject2 = "" + paramLong2;
    Object localObject3 = "" + paramLong1;
    Object localObject1;
    if (paramInt1 == 0) {
      localObject1 = "1";
    }
    for (;;)
    {
      ReportController.b(null, "dc01440", "", "", "0X80079C8", "0X80079C8", 0, 0, (String)localObject2, (String)localObject3, "", (String)localObject1);
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_ComTencentMapsdkRasterModelLatLng = new LatLng(paramPOIInfo.jdField_b_of_type_Double / 1000000.0D, paramPOIInfo.jdField_a_of_type_Double / 1000000.0D);
      TextView localTextView1 = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131369802);
      TextView localTextView2 = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131369803);
      localObject1 = (ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131369804);
      localObject2 = (ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131369600);
      localObject3 = this.jdField_a_of_type_AndroidContentContext.getResources();
      if (!TextUtils.isEmpty(paramString1)) {
        localTextView1.setText(paramString1);
      }
      if (!TextUtils.isEmpty(paramString2)) {
        localTextView2.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131438792, new Object[] { paramString2 }));
      }
      if (!TextUtils.isEmpty(paramString3))
      {
        paramString2 = URLDrawable.URLDrawableOptions.obtain();
        paramString2.mRequestHeight = AIOUtils.a(130.0F, (Resources)localObject3);
        paramString2.mRequestWidth = AIOUtils.a(160.0F, (Resources)localObject3);
        paramString2.mLoadingDrawable = ((Resources)localObject3).getDrawable(2130846489);
        paramString2.mFailedDrawable = ((Resources)localObject3).getDrawable(2130846489);
        ((ImageView)localObject1).setImageDrawable(URLDrawable.getDrawable(paramString3, paramString2));
      }
      ((ImageView)localObject2).setOnClickListener(new abnh(this, paramLong1));
      if (paramInt1 != jdField_d_of_type_Int) {
        break label382;
      }
      if (paramInt4 != 0) {
        break;
      }
      b(paramPOIInfo, paramInt3);
      return;
      if (paramInt1 == 1) {
        localObject1 = "2";
      } else if (paramInt1 == 2) {
        localObject1 = "3";
      } else {
        localObject1 = "";
      }
    }
    a(paramPOIInfo, paramInt3);
    return;
    label382:
    a(paramInt2, paramInt1, paramString1);
  }
  
  private void a(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt4, int paramInt5, POIInfo paramPOIInfo)
  {
    if (this.jdField_c_of_type_Int == 0) {
      ReportController.b(null, "dc01440", "", "", "0X80079C8", "0X80079C8", 0, 0, "" + paramLong2, "" + paramLong1, "", "");
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    ImageView localImageView3 = (ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131369596);
    TextView localTextView2 = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131369597);
    TextView localTextView3 = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131369598);
    ImageView localImageView2 = (ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131369599);
    TextView localTextView1 = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131369601);
    ImageView localImageView1 = (ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131369600);
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.jdField_a_of_type_ComTencentMapsdkRasterModelLatLng = new LatLng(paramPOIInfo.jdField_b_of_type_Double / 1000000.0D, paramPOIInfo.jdField_a_of_type_Double / 1000000.0D);
    if (!TextUtils.isEmpty(paramString1))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      int i = AIOUtils.a(31.0F, localResources);
      localURLDrawableOptions.mRequestHeight = i;
      localURLDrawableOptions.mRequestWidth = i;
      localURLDrawableOptions.mLoadingDrawable = localResources.getDrawable(2130846489);
      localURLDrawableOptions.mFailedDrawable = localResources.getDrawable(2130846489);
      localImageView3.setImageDrawable(URLDrawable.getDrawable(paramString1, localURLDrawableOptions));
      localImageView3.setOnClickListener(new abnu(this, paramString3));
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localTextView2.setText(paramString2);
    }
    if (paramInt2 == 0) {
      if (paramInt1 == POITaskInfo.f)
      {
        localTextView3.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131438785));
        if (!TextUtils.isEmpty(paramString4))
        {
          paramString1 = URLDrawable.URLDrawableOptions.obtain();
          paramString1.mRequestHeight = AIOUtils.a(140.0F, localResources);
          paramString1.mRequestWidth = AIOUtils.a(170.0F, localResources);
          paramString1.mLoadingDrawable = localResources.getDrawable(2130846489);
          paramString1.mFailedDrawable = localResources.getDrawable(2130846489);
          localImageView2.setImageDrawable(URLDrawable.getDrawable(paramString4, paramString1));
        }
        if (paramInt1 != POITaskInfo.f) {
          break label594;
        }
        paramString1 = NumberFormat.getNumberInstance();
        localTextView1.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131438790, new Object[] { paramString1.format(paramInt4) }));
        label458:
        localImageView1.setOnClickListener(new abnv(this, paramLong1));
        if (paramInt2 != jdField_d_of_type_Int) {
          break label615;
        }
        if (paramInt5 != 0) {
          break label604;
        }
        b(paramPOIInfo, paramInt3);
      }
    }
    for (;;)
    {
      if (paramInt1 == 10)
      {
        paramString1 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369643);
        if (paramString1 != null) {
          paramString1.setText(2131438779);
        }
      }
      return;
      localTextView3.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131438782));
      break;
      if ((paramInt2 == 1) || (paramInt2 == 2))
      {
        localTextView3.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131438783));
        break;
      }
      localTextView3.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131438784));
      break;
      label594:
      localTextView1.setText(paramString5);
      break label458;
      label604:
      a(paramPOIInfo, paramInt3);
      continue;
      label615:
      a(paramInt1, paramInt2, "");
    }
  }
  
  private void a(POIInfo paramPOIInfo, int paramInt)
  {
    Object localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369644);
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369645);
    Button localButton = (Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131369646);
    if (paramInt < 1000)
    {
      ((TextView)localObject).setText(this.jdField_a_of_type_AndroidContentContext.getString(2131438772, new Object[] { String.valueOf(paramInt) }));
      StringBuilder localStringBuilder = new StringBuilder().append(paramPOIInfo.jdField_a_of_type_JavaLangString).append("|");
      if (!TextUtils.isEmpty(paramPOIInfo.jdField_b_of_type_JavaLangString)) {
        break label264;
      }
      localObject = "";
      label114:
      localObject = (String)localObject;
      if (TextUtils.isEmpty(paramPOIInfo.jdField_a_of_type_JavaLangString)) {
        break label273;
      }
      localObject = new SpannableString((CharSequence)localObject);
      ((SpannableString)localObject).setSpan(new StyleSpan(1), 0, paramPOIInfo.jdField_a_of_type_JavaLangString.length(), 17);
      localTextView.setText((CharSequence)localObject);
    }
    for (;;)
    {
      localButton.setOnClickListener(new abnk(this, paramPOIInfo, paramInt));
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
      float f1 = paramInt / 1000.0F;
      ((TextView)localObject).setText(this.jdField_a_of_type_AndroidContentContext.getString(2131438771, new Object[] { String.valueOf(f1) }));
      break;
      label264:
      localObject = paramPOIInfo.jdField_b_of_type_JavaLangString;
      break label114;
      label273:
      localTextView.setText((CharSequence)localObject);
    }
  }
  
  private void a(POIInfo paramPOIInfo, int paramInt1, List paramList, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    Object localObject3 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369643);
    Object localObject1 = (ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131369596);
    TextView localTextView = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131369597);
    LbsPackInfo localLbsPackInfo = (LbsPackInfo)paramList.get(0);
    this.jdField_a_of_type_JavaLangString = String.valueOf(localLbsPackInfo.jdField_a_of_type_Long);
    ((ImageView)localObject1).setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface.a.a(this.jdField_a_of_type_JavaLangString, true));
    LbsPackManager localLbsPackManager = (LbsPackManager)this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface.getManager(214);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    Object localObject2 = localLbsPackInfo.c;
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject2 = localLbsPackManager.b(String.valueOf(localLbsPackInfo.jdField_a_of_type_Long));
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = localLbsPackInfo.jdField_a_of_type_Long + "";
      }
    }
    for (;;)
    {
      if (paramInt2 > 1)
      {
        paramList = paramList.iterator();
        for (;;)
        {
          if (paramList.hasNext())
          {
            localObject3 = (LbsPackInfo)paramList.next();
            if (!String.valueOf(((LbsPackInfo)localObject3).jdField_a_of_type_Long).equals(String.valueOf(localLbsPackInfo.jdField_a_of_type_Long)))
            {
              localObject2 = ((LbsPackInfo)localObject3).c;
              paramList = (List)localObject2;
              if (TextUtils.isEmpty((CharSequence)localObject2))
              {
                localObject2 = localLbsPackManager.b(String.valueOf(((LbsPackInfo)localObject3).jdField_a_of_type_Long));
                paramList = (List)localObject2;
                if (TextUtils.isEmpty((CharSequence)localObject2)) {
                  paramList = ((LbsPackInfo)localObject3).jdField_a_of_type_Long + "";
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        if (!TextUtils.isEmpty(paramList)) {
          ((StringBuilder)localObject2).append(",").append(paramList).append("等人");
        }
        localTextView.setText(((StringBuilder)localObject2).toString());
        for (;;)
        {
          if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
            localLbsPackManager.a(this.jdField_a_of_type_JavaUtilArrayList);
          }
          if (paramInt3 != 1) {
            break;
          }
          a(paramPOIInfo, paramInt1);
          return;
          localTextView.setText((CharSequence)localObject1);
          if (paramList.size() > 0) {
            if (TextUtils.equals(String.valueOf(((LbsPackInfo)paramList.get(0)).jdField_a_of_type_Long), this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface.getCurrentAccountUin())) {
              ((TextView)localObject3).setText(2131438780);
            } else {
              ((TextView)localObject3).setText(2131438778);
            }
          }
        }
        b(paramPOIInfo, paramInt1);
        return;
        continue;
        paramList = "";
      }
    }
  }
  
  private void b(POIInfo paramPOIInfo, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView == null) || (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView.getParent() != null)) {
      return;
    }
    Object localObject1 = new RelativeLayout.LayoutParams(-1, AIOUtils.a(210.0F, this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView.getResources()));
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131369638);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView, (ViewGroup.LayoutParams)localObject1);
    this.jdField_d_of_type_AndroidViewView = getLayoutInflater().inflate(2130970242, null);
    localObject1 = (TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131369729);
    Object localObject2 = (TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131369730);
    if (paramInt < 1000)
    {
      ((TextView)localObject1).setText(this.jdField_a_of_type_AndroidContentContext.getString(2131438772, new Object[] { String.valueOf(paramInt) }));
      label141:
      StringBuilder localStringBuilder = new StringBuilder().append(paramPOIInfo.jdField_a_of_type_JavaLangString).append("|");
      if (!TextUtils.isEmpty(paramPOIInfo.jdField_b_of_type_JavaLangString)) {
        break label505;
      }
      localObject1 = "";
      label177:
      localObject1 = (String)localObject1;
      if (TextUtils.isEmpty(paramPOIInfo.jdField_a_of_type_JavaLangString)) {
        break label514;
      }
      localObject1 = new SpannableString((CharSequence)localObject1);
      ((SpannableString)localObject1).setSpan(new StyleSpan(1), 0, paramPOIInfo.jdField_a_of_type_JavaLangString.length(), 17);
      ((TextView)localObject2).setText((CharSequence)localObject1);
    }
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView.getMap();
      ((TencentMap)localObject1).setZoom(16);
      paramPOIInfo = new LatLng(paramPOIInfo.jdField_b_of_type_Double / 1000000.0D, paramPOIInfo.jdField_a_of_type_Double / 1000000.0D);
      ((TencentMap)localObject1).setCenter(paramPOIInfo);
      paramPOIInfo = new MapView.LayoutParams(-2, -2, paramPOIInfo, 81);
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView.addView(this.jdField_d_of_type_AndroidViewView, paramPOIInfo);
      if (this.jdField_b_of_type_Boolean)
      {
        paramPOIInfo = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView.getProjection();
        if (paramPOIInfo != null)
        {
          localObject2 = paramPOIInfo.toScreenLocation(((TencentMap)localObject1).getMapCenter());
          ((Point)localObject2).offset(0, AIOUtils.a(60.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) * -1);
          ((TencentMap)localObject1).setCenter(paramPOIInfo.fromScreenLocation((Point)localObject2));
        }
      }
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView.onResume();
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      if ((this.jdField_a_of_type_JavaLangObject == null) || (!(this.jdField_a_of_type_JavaLangObject instanceof ARGridMapViewDialog.POIExtarData)) || (((ARGridMapViewDialog.POIExtarData)this.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Int != 10)) {
        break;
      }
      ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131369728)).setText(2131438779);
      return;
      float f1 = paramInt / 1000.0F;
      ((TextView)localObject1).setText(this.jdField_a_of_type_AndroidContentContext.getString(2131438771, new Object[] { String.valueOf(f1) }));
      break label141;
      label505:
      localObject1 = paramPOIInfo.jdField_b_of_type_JavaLangString;
      break label177;
      label514:
      ((TextView)localObject2).setText((CharSequence)localObject1);
    }
  }
  
  private void d()
  {
    setContentView(2130970239);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131363852));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131369718));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131369641);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131369647);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131369651);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131369650));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131364003));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131363581));
    Object localObject1;
    Object localObject2;
    if ((this.jdField_c_of_type_Int == 0) || (this.jdField_c_of_type_Int == 1) || (this.jdField_c_of_type_Int == 2))
    {
      localObject1 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970223, null);
      localObject2 = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    }
    for (;;)
    {
      if (this.jdField_c_of_type_Int != 2) {
        this.jdField_a_of_type_AndroidWidgetProgressBar.postDelayed(new abnq(this), 1500L);
      }
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new abnr(this));
      localObject1 = getWindow();
      localObject2 = ((Window)localObject1).getAttributes();
      ((WindowManager.LayoutParams)localObject2).width = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
      ((WindowManager.LayoutParams)localObject2).height = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().heightPixels;
      ((Window)localObject1).setAttributes((WindowManager.LayoutParams)localObject2);
      return;
      if (this.jdField_c_of_type_Int == 3)
      {
        localObject1 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970253, null);
        localObject2 = new RelativeLayout.LayoutParams(-1, -1);
        Drawable localDrawable = a("/17_armap_cardbg@2x.png");
        if (localDrawable != null) {
          ((View)localObject1).setBackgroundDrawable(localDrawable);
        }
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      }
    }
  }
  
  private void e()
  {
    Object localObject1;
    if ((this.jdField_c_of_type_Int == 0) || (this.jdField_c_of_type_Int == 3))
    {
      localObject1 = (ARGridMapViewDialog.POIExtarData)this.jdField_a_of_type_JavaLangObject;
      if (this.jdField_c_of_type_Int == 0) {
        a(((ARGridMapViewDialog.POIExtarData)localObject1).jdField_a_of_type_Int);
      }
      ThreadManager.postImmediately(new abns(this, (ARGridMapViewDialog.POIExtarData)localObject1), null, true);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARMapBaseDialog", 2, "initData busiType:" + this.jdField_c_of_type_Int + ",extraData:" + this.jdField_a_of_type_JavaLangObject);
      }
      return;
      Object localObject2;
      Object localObject3;
      if (this.jdField_c_of_type_Int == 1)
      {
        localObject1 = (ARGridMapViewDialog.OpenBoxExtraData)this.jdField_a_of_type_JavaLangObject;
        a(((ARGridMapViewDialog.OpenBoxExtraData)localObject1).jdField_a_of_type_Int);
        if ((((ARGridMapViewDialog.OpenBoxExtraData)localObject1).jdField_a_of_type_ComTencentMobileqqArmapItemInfo != null) && (((ARGridMapViewDialog.OpenBoxExtraData)localObject1).jdField_a_of_type_ComTencentMobileqqArmapItemInfo.jdField_a_of_type_ComTencentMobileqqArmapPOIInfo != null))
        {
          localObject2 = ((ARGridMapViewDialog.OpenBoxExtraData)localObject1).jdField_a_of_type_ComTencentMobileqqArmapItemInfo;
          localObject3 = ((ARGridMapViewDialog.OpenBoxExtraData)localObject1).jdField_a_of_type_ComTencentMobileqqArmapItemInfo.jdField_a_of_type_ComTencentMobileqqArmapPOIInfo;
          a(((POIInfo)localObject3).jdField_a_of_type_Long, ((ARGridMapViewDialog.OpenBoxExtraData)localObject1).jdField_a_of_type_Int, -1L, f, 0, ((ItemInfo)localObject2).jdField_b_of_type_JavaLangString, ((ItemInfo)localObject2).h, ((ARGridMapViewDialog.OpenBoxExtraData)localObject1).jdField_a_of_type_JavaLangString, ((POIInfo)localObject3).d, ((ItemInfo)localObject2).jdField_a_of_type_JavaLangString, ((ItemInfo)localObject2).e, 1, (POIInfo)localObject3);
        }
      }
      else if (this.jdField_c_of_type_Int == 2)
      {
        localObject1 = (ARGridMapViewDialog.LbsRedBagExtraData)this.jdField_a_of_type_JavaLangObject;
        a(((ARGridMapViewDialog.LbsRedBagExtraData)localObject1).jdField_a_of_type_Int);
        localObject2 = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131369598);
        localObject3 = (ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131369599);
        TextView localTextView = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131369601);
        ImageView localImageView = (ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131369600);
        ((TextView)localObject2).setVisibility(8);
        localImageView.setVisibility(8);
        ((ImageView)localObject3).setImageResource(2130842682);
        localTextView.setText(2131438797);
        this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface.a.a(this.jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader$FaceObserver);
        this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface.registObserver(this.jdField_a_of_type_ComQqImPoiLbsPackObserver);
        ThreadManager.postImmediately(new abnt(this, (ARGridMapViewDialog.LbsRedBagExtraData)localObject1), null, true);
      }
    }
  }
  
  public Drawable a(String paramString)
  {
    Object localObject = (ARMapManager)this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface.getManager(209);
    if (localObject != null)
    {
      localObject = ((ARMapManager)localObject).d();
      return Drawable.createFromPath((String)localObject + paramString);
    }
    return null;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView != null) && (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView.getParent() != null) && (this.jdField_d_of_type_AndroidViewView != null) && (this.jdField_a_of_type_ComTencentMapsdkRasterModelLatLng != null))
    {
      TencentMap localTencentMap = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView.getMap();
      localTencentMap.setCenter(this.jdField_a_of_type_ComTencentMapsdkRasterModelLatLng);
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView.removeView(this.jdField_d_of_type_AndroidViewView);
      Object localObject = new MapView.LayoutParams(-2, -2, this.jdField_a_of_type_ComTencentMapsdkRasterModelLatLng, 81);
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView.addView(this.jdField_d_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
      localObject = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView.getProjection();
      if (localObject != null)
      {
        Point localPoint = ((Projection)localObject).toScreenLocation(localTencentMap.getMapCenter());
        localPoint.offset(0, AIOUtils.a(60.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) * -1);
        localTencentMap.setCenter(((Projection)localObject).fromScreenLocation(localPoint));
      }
    }
  }
  
  public void b()
  {
    show();
    int j = getWindow().getAttributes().width;
    int i = getWindow().getAttributes().height;
    j = (j - AIOUtils.a(300.0F, this.jdField_a_of_type_AndroidContentContext.getResources())) / 2;
    i = (i - AIOUtils.a(400.0F, this.jdField_a_of_type_AndroidContentContext.getResources())) / 2;
    AnimationSet localAnimationSet = new AnimationSet(false);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 0, this.jdField_a_of_type_Int - j, 0, this.jdField_b_of_type_Int - i);
    localScaleAnimation.setInterpolator(new AccelerateInterpolator(1.5F));
    localScaleAnimation.setDuration(350L);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(localAnimationSet);
  }
  
  public void c()
  {
    int j = getWindow().getAttributes().width;
    int i = getWindow().getAttributes().height;
    j = (j - AIOUtils.a(320.0F, this.jdField_a_of_type_AndroidContentContext.getResources())) / 2;
    i = (i - AIOUtils.a(420.0F, this.jdField_a_of_type_AndroidContentContext.getResources())) / 2;
    AnimationSet localAnimationSet = new AnimationSet(false);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 0, this.jdField_a_of_type_Int - j, 0, this.jdField_b_of_type_Int - i);
    localScaleAnimation.setInterpolator(new AccelerateInterpolator());
    localScaleAnimation.setDuration(350L);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(localAnimationSet);
    localAnimationSet.setAnimationListener(new abnl(this));
  }
  
  protected void onStop()
  {
    super.onStop();
    if ((this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView != null) && (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView.getParent() != null))
    {
      if (this.jdField_d_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView.removeView(this.jdField_d_of_type_AndroidViewView);
      }
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView);
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapView.onPause();
    }
    this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface.a.b(this.jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader$FaceObserver);
    this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface.unRegistObserver(this.jdField_a_of_type_ComQqImPoiLbsPackObserver);
    this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqArmapArMapObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.map.ARGridMapViewDialog
 * JD-Core Version:    0.7.0.1
 */