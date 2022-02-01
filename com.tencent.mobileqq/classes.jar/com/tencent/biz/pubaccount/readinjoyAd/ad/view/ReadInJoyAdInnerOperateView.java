package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusInnerData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusInnerData.InnerFormItem;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdInnerUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import java.lang.ref.WeakReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class ReadInJoyAdInnerOperateView
  extends ViewBase
  implements View.OnClickListener, View.OnFocusChangeListener
{
  private View jdField_a_of_type_AndroidViewView;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ProteusInnerData jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusInnerData;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference = null;
  boolean jdField_a_of_type_Boolean = false;
  private String b;
  private String c;
  
  public ReadInJoyAdInnerOperateView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramVafContext.getContext());
    a();
  }
  
  private void a()
  {
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((localWeakReference != null) && (localWeakReference.get() != null))
    {
      this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getSystemService("layout_inflater")).inflate(2131560063, null);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131366337));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379895));
      this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this);
      this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusInnerData.a != null)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusInnerData.a.b)) {
        this.jdField_a_of_type_AndroidWidgetEditText.setHint(ReadInJoyAdInnerUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusInnerData.a.b, 32));
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusInnerData.a.c)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ReadInJoyAdInnerUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusInnerData.a.c, 8));
      }
    }
    boolean bool = TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusInnerData.M);
    Object localObject2 = null;
    if (!bool) {
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusInnerData.M;
    } else {
      localObject1 = null;
    }
    this.jdField_a_of_type_JavaLangString = ((String)localObject1);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusInnerData.O)) {
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusInnerData.O;
    } else {
      localObject1 = null;
    }
    this.c = ((String)localObject1);
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusInnerData.P)) {
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusInnerData.P;
    }
    this.b = ((String)localObject1);
  }
  
  public int getComMeasuredHeight()
  {
    return this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.jdField_a_of_type_AndroidViewView.getMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131379895) {
      return;
    }
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
    ProteusInnerData localProteusInnerData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusInnerData;
    if (localProteusInnerData == null) {
      return;
    }
    boolean bool;
    if ((localProteusInnerData.a != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusInnerData.a.jdField_a_of_type_JavaUtilRegexPattern != null)) {
      bool = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusInnerData.a.jdField_a_of_type_JavaUtilRegexPattern.matcher(str).matches();
    } else {
      bool = true;
    }
    if (bool)
    {
      QQToast.a(paramView.getContext(), -1, HardCodeUtil.a(2131712849), 0).b(((BaseActivity)paramView.getContext()).getTitleBarHeight());
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusInnerData.a == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusInnerData.a.jdField_a_of_type_OrgJsonJSONObject == null)) {
        break label183;
      }
    }
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusInnerData.a.jdField_a_of_type_OrgJsonJSONObject.put("value", str);
      return;
    }
    catch (Exception paramView) {}
    str = HardCodeUtil.a(2131712874);
    QQToast.a(paramView.getContext(), 1, str, 0).b(((BaseActivity)paramView.getContext()).getTitleBarHeight());
    label183:
    return;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_AndroidViewView.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewView.measure(paramInt1, paramInt2);
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramView = this.jdField_a_of_type_JavaLangRefWeakReference;
      if ((paramView != null) && (paramView.get() != null) && ((this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof Activity))) {
        ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getWindow().getAttributes().softInputMode = 4;
      }
    }
    if ((!this.jdField_a_of_type_Boolean) && (paramBoolean))
    {
      this.jdField_a_of_type_Boolean = true;
      ReadInJoyAdInnerUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusInnerData, 39);
    }
  }
  
  protected boolean setAttribute(int paramInt, Object paramObject)
  {
    if ((paramInt == 1042) && (paramObject != null) && ((paramObject instanceof ProteusInnerData)))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusInnerData = ((ProteusInnerData)paramObject);
      b();
    }
    return super.setAttribute(paramInt, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdInnerOperateView
 * JD-Core Version:    0.7.0.1
 */