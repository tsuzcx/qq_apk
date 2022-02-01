package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ScrollView;
import antf;
import bhbx;
import bhmq;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import oyj;
import qai;
import qcd;
import qcx;
import qfg;
import svq;

public class ReadInJoyDailyShareFragment
  extends PublicBaseFragment
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  ProteusItemView jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemProteusItemView;
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  private String jdField_a_of_type_JavaLangString;
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private qai jdField_a_of_type_Qai;
  private String b;
  
  private Bitmap a(View paramView)
  {
    if ((paramView.getWidth() == 0) || (paramView.getHeight() == 0))
    {
      QLog.e("ReadInJoyDailyShareFragment", 1, "can not createBitmap");
      return null;
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawColor(-1);
    paramView.draw(localCanvas);
    return localBitmap;
  }
  
  private static String a(Date paramDate)
  {
    return new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(paramDate);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_OrgJsonJSONObject == null) {}
    label92:
    for (;;)
    {
      return;
      Object localObject = this.jdField_a_of_type_OrgJsonJSONObject.optString("qr_code_url");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
      for (localObject = bhbx.a((String)localObject, getActivity().getResources(), 540, 0, false);; localObject = null)
      {
        if (localObject == null) {
          break label92;
        }
        ViewBase localViewBase = (ViewBase)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemProteusItemView.a().getViewIdMapping().get("id_kandian_share_qr_code");
        if (!(localViewBase instanceof qcx)) {
          break;
        }
        ((ImageView)localViewBase.getNativeView()).setImageBitmap((Bitmap)localObject);
        return;
      }
    }
  }
  
  private boolean a(Bitmap paramBitmap, String paramString)
  {
    if (paramBitmap == null) {
      return false;
    }
    try
    {
      bhmq.a(paramBitmap, new File(paramString));
      return true;
    }
    catch (IOException paramBitmap)
    {
      QLog.e("ReadInJoyDailyShareFragment", 1, paramBitmap, new Object[0]);
    }
    return false;
  }
  
  private void b()
  {
    ViewBase localViewBase = (ViewBase)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemProteusItemView.a().getViewIdMapping().get("id_share_choice");
    if ((localViewBase instanceof qcd)) {
      ((qcd)localViewBase).a(new ReadInJoyDailyShareFragment.1(this, localViewBase));
    }
  }
  
  private void c()
  {
    if (TextUtils.isEmpty(this.b))
    {
      View localView = ((ViewBase)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemProteusItemView.a().getViewIdMapping().get("id_check_container")).getNativeView();
      if (localView != null)
      {
        this.jdField_a_of_type_JavaLangString = antf.bg;
        this.b = (this.jdField_a_of_type_JavaLangString + "kandiandaily-" + a(Calendar.getInstance().getTime()) + ".png");
        svq.a(new File(this.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_AndroidGraphicsBitmap = a(localView);
        a(this.jdField_a_of_type_AndroidGraphicsBitmap, this.b);
      }
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.getWindow().setBackgroundDrawable(new ColorDrawable(0));
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getActivity() != null) {
      paramBundle = getActivity().getIntent();
    }
    for (;;)
    {
      if (paramBundle != null) {
        paramBundle = paramBundle.getStringExtra("share_info_intent");
      }
      try
      {
        this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject(paramBundle);
        QLog.d("ReadInJoyDailyShareFragment", 1, "shareinfo is " + this.jdField_a_of_type_OrgJsonJSONObject.toString());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new qfg();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(getActivity());
        oyj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "default_feeds");
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setCurActivity(getActivity());
        this.jdField_a_of_type_Qai = new qai();
        this.jdField_a_of_type_Qai.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext);
        return;
        paramBundle = null;
      }
      catch (JSONException paramBundle)
      {
        for (;;)
        {
          QLog.e("ReadInJoyDailyShareFragment", 1, paramBundle, new Object[0]);
        }
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560151, paramViewGroup, false);
    paramViewGroup = (ScrollView)paramLayoutInflater.findViewById(2131377513);
    if ((paramViewGroup != null) && (this.jdField_a_of_type_Qai != null) && (this.jdField_a_of_type_OrgJsonJSONObject != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemProteusItemView = this.jdField_a_of_type_Qai.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, this.jdField_a_of_type_OrgJsonJSONObject);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemProteusItemView != null) {
        paramViewGroup.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemProteusItemView, -1, -1);
      }
    }
    else
    {
      a();
      b();
    }
    for (;;)
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      getActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyDailyShareFragment
 * JD-Core Version:    0.7.0.1
 */