package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import ajya;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import awwa;
import bbco;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.FixSizeImageView;
import nol;
import omj;
import onh;
import org.json.JSONException;
import org.json.JSONObject;
import pau;
import puy;
import pxj;
import ram;
import shu;
import tencent.im.oidb.articlesummary.articlesummary.SubscribeInfo;

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
    if (this.jdField_a_of_type_Puy.a.c() == 3) {
      try
      {
        long l = Long.parseLong(this.jdField_a_of_type_Puy.a.a().mSubscribeID);
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
    Object localObject = this.jdField_a_of_type_Puy.a;
    if (((pau)localObject).c() == 3)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (!((pau)localObject).a().mSubscribeInfoObj.bytes_test.has()) {}
    }
    label193:
    for (;;)
    {
      try
      {
        localObject = ((pau)localObject).a().mSubscribeInfoObj.bytes_test.get().toStringUtf8();
        if (((String)localObject).length() <= 4) {
          break label193;
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
        ((TextView)this.jdField_a_of_type_AndroidViewView).setText(ajya.a(2131702272));
        return;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      ((TextView)this.jdField_a_of_type_AndroidViewView).setText(ajya.a(2131702290));
      return;
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(onh.d(this.jdField_a_of_type_Puy.a.a().mSubscribeName));
  }
  
  private void f()
  {
    String str = omj.k + bbco.encodeToString(String.valueOf(a()).getBytes(), 2);
    onh.a(getContext(), str);
    g();
  }
  
  private void g()
  {
    try
    {
      JSONObject localJSONObject = onh.a();
      localJSONObject.put("feeds_source", onh.c(this.jdField_a_of_type_Puy.a.a()));
      localJSONObject.put("kandian_mode", onh.e());
      String str2 = onh.d(this.jdField_a_of_type_Puy.a.a());
      if (shu.a(this.jdField_a_of_type_Puy.a.e())) {}
      for (String str1 = "0X8009357";; str1 = "0X800744D")
      {
        nol.a(null, "CliOper", "", "", str1, str1, 0, 0, str2, "", "", localJSONObject.toString(), false);
        return;
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131559888, this, true);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)findViewById(2131374733));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374749));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131376694);
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    if ((paramObject instanceof pau)) {
      a((pau)paramObject);
    }
  }
  
  public void a(pau parampau)
  {
    if ((parampau.a()) && (parampau.c() == 3)) {}
    for (int i = 0;; i = 8)
    {
      setVisibility(i);
      if ((parampau.a()) && (parampau.c() == 3))
      {
        setImage();
        e();
        d();
      }
      return;
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
      if (!onh.a()) {
        break label52;
      }
      this.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageDrawable(awwa.a(this.jdField_a_of_type_Baxy, String.valueOf(l), 1));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setOnClickListener(new pxj(this));
      return;
      label52:
      this.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageBitmap(this.jdField_a_of_type_Ram.a(l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderSubscribe
 * JD-Core Version:    0.7.0.1
 */