package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.FixSizeImageView;
import lvw;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.SubscribeInfo;

public class ComponentHeaderSubscribe
  extends ComponentHeaderBase
{
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FixSizeImageView jdField_a_of_type_ComTencentWidgetFixSizeImageView;
  
  public ComponentHeaderSubscribe(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentHeaderSubscribe(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentHeaderSubscribe(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private long a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.c() == 3) {
      try
      {
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mSubscribeID);
        return l;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localNumberFormatException.printStackTrace();
      }
    }
    return 0L;
  }
  
  private void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a;
    if (((IReadInJoyModel)localObject).c() == 3)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (!((IReadInJoyModel)localObject).a().mSubscribeInfoObj.bytes_test.has()) {}
    }
    label187:
    for (;;)
    {
      try
      {
        localObject = ((IReadInJoyModel)localObject).a().mSubscribeInfoObj.bytes_test.get().toStringUtf8();
        if (((String)localObject).length() <= 4) {
          break label187;
        }
        localObject = ((String)localObject).substring(0, 4);
        ((TextView)this.jdField_a_of_type_AndroidViewView).setText((CharSequence)localObject);
        if ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(((String)localObject).trim())))
        {
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          return;
        }
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        return;
      }
      catch (Exception localException)
      {
        QLog.w("ComponentHeaderSubscribe", 1, "read field error", localException);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        ((TextView)this.jdField_a_of_type_AndroidViewView).setText("已订阅");
        return;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      ((TextView)this.jdField_a_of_type_AndroidViewView).setText("已订阅");
      return;
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(ReadInJoyUtils.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a().mSubscribeName));
  }
  
  private void f()
  {
    String str = ReadInJoyConstants.i + Base64Util.encodeToString(String.valueOf(a()).getBytes(), 2);
    ReadInJoyUtils.a(getContext(), str);
    g();
  }
  
  private void g()
  {
    try
    {
      JSONObject localJSONObject = ReadInJoyUtils.a();
      localJSONObject.put("feeds_source", ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a()));
      localJSONObject.put("kandian_mode", ReadInJoyUtils.e());
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X800744D", "0X800744D", 0, 0, ReadInJoyUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a()), "", "", localJSONObject.toString(), false);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2130969595, this, true);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)findViewById(2131366860));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366865));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131367056);
  }
  
  public void a(IReadInJoyModel paramIReadInJoyModel)
  {
    if ((paramIReadInJoyModel.a()) && (paramIReadInJoyModel.c() == 3)) {}
    for (int i = 0;; i = 8)
    {
      setVisibility(i);
      if ((paramIReadInJoyModel.a()) && (paramIReadInJoyModel.c() == 3))
      {
        setImage();
        e();
        d();
      }
      return;
    }
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    if ((paramObject instanceof IReadInJoyModel)) {
      a((IReadInJoyModel)paramObject);
    }
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.setVisibility(8);
  }
  
  public void setImage()
  {
    long l = a();
    if (l != 0L)
    {
      if (!ReadInJoyUtils.a()) {
        break label52;
      }
      this.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageDrawable(SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, String.valueOf(l), 1));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setOnClickListener(new lvw(this));
      return;
      label52:
      this.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageBitmap(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a(l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderSubscribe
 * JD-Core Version:    0.7.0.1
 */