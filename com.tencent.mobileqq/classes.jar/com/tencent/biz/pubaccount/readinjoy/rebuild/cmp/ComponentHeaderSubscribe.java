package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import anvx;
import bcnc;
import bhcu;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.FixSizeImageView;
import olh;
import org.json.JSONException;
import org.json.JSONObject;
import pjj;
import pkh;
import pnn;
import pqf;
import pqu;
import pqw;
import prg;
import qfw;
import rfw;
import rih;
import szd;
import tencent.im.oidb.articlesummary.articlesummary.SubscribeInfo;
import uvs;

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
    if (this.jdField_a_of_type_Rfw.a.c() == 3) {
      try
      {
        long l = Long.parseLong(this.jdField_a_of_type_Rfw.a.a().mSubscribeID);
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
    Object localObject = this.jdField_a_of_type_Rfw.a;
    if (((qfw)localObject).c() == 3)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (!((qfw)localObject).a().mSubscribeInfoObj.bytes_test.has()) {}
    }
    label193:
    for (;;)
    {
      try
      {
        localObject = ((qfw)localObject).a().mSubscribeInfoObj.bytes_test.get().toStringUtf8();
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
        ((TextView)this.jdField_a_of_type_AndroidViewView).setText(anvx.a(2131701769));
        return;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      ((TextView)this.jdField_a_of_type_AndroidViewView).setText(anvx.a(2131701787));
      return;
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(prg.a(this.jdField_a_of_type_Rfw.a.a().mSubscribeName));
  }
  
  private void f()
  {
    String str = pjj.k + bhcu.encodeToString(String.valueOf(a()).getBytes(), 2);
    pkh.a(getContext(), str);
    g();
  }
  
  private void g()
  {
    try
    {
      JSONObject localJSONObject = pqf.a();
      localJSONObject.put("feeds_source", pqw.b(this.jdField_a_of_type_Rfw.a.a()));
      localJSONObject.put("kandian_mode", pqu.a());
      String str2 = pqw.c(this.jdField_a_of_type_Rfw.a.a());
      if (uvs.a(this.jdField_a_of_type_Rfw.a.e())) {}
      for (String str1 = "0X8009357";; str1 = "0X800744D")
      {
        olh.a(null, "CliOper", "", "", str1, str1, 0, 0, str2, "", "", localJSONObject.toString(), false);
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
    return LayoutInflater.from(paramContext).inflate(2131560195, this, true);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)findViewById(2131376128));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376144));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131378284);
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    if ((paramObject instanceof qfw)) {
      a((qfw)paramObject);
    }
  }
  
  public void a(qfw paramqfw)
  {
    if ((paramqfw.a()) && (paramqfw.c() == 3)) {}
    for (int i = 0;; i = 8)
    {
      setVisibility(i);
      if ((paramqfw.a()) && (paramqfw.c() == 3))
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
      if (!pnn.a()) {
        break label52;
      }
      this.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageDrawable(bcnc.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder, String.valueOf(l), 1));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setOnClickListener(new rih(this));
      return;
      label52:
      this.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageBitmap(this.jdField_a_of_type_Szd.a(l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderSubscribe
 * JD-Core Version:    0.7.0.1
 */