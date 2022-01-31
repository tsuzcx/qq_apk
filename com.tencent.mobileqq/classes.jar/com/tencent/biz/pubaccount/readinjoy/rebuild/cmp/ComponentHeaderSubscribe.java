package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import ajjy;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import avwf;
import baaw;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.FixSizeImageView;
import ndn;
import obb;
import obz;
import opw;
import org.json.JSONException;
import org.json.JSONObject;
import pjg;
import plr;
import qoe;
import rvf;
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
    if (this.jdField_a_of_type_Pjg.a.c() == 3) {
      try
      {
        long l = Long.parseLong(this.jdField_a_of_type_Pjg.a.a().mSubscribeID);
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
    Object localObject = this.jdField_a_of_type_Pjg.a;
    if (((opw)localObject).c() == 3)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (!((opw)localObject).a().mSubscribeInfoObj.bytes_test.has()) {}
    }
    label193:
    for (;;)
    {
      try
      {
        localObject = ((opw)localObject).a().mSubscribeInfoObj.bytes_test.get().toStringUtf8();
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
        ((TextView)this.jdField_a_of_type_AndroidViewView).setText(ajjy.a(2131636477));
        return;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      ((TextView)this.jdField_a_of_type_AndroidViewView).setText(ajjy.a(2131636495));
      return;
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(obz.d(this.jdField_a_of_type_Pjg.a.a().mSubscribeName));
  }
  
  private void f()
  {
    String str = obb.k + baaw.encodeToString(String.valueOf(a()).getBytes(), 2);
    obz.a(getContext(), str);
    g();
  }
  
  private void g()
  {
    try
    {
      JSONObject localJSONObject = obz.a();
      localJSONObject.put("feeds_source", obz.c(this.jdField_a_of_type_Pjg.a.a()));
      localJSONObject.put("kandian_mode", obz.e());
      String str2 = obz.d(this.jdField_a_of_type_Pjg.a.a());
      if (rvf.a(this.jdField_a_of_type_Pjg.a.e())) {}
      for (String str1 = "0X8009357";; str1 = "0X800744D")
      {
        ndn.a(null, "CliOper", "", "", str1, str1, 0, 0, str2, "", "", localJSONObject.toString(), false);
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
    return LayoutInflater.from(paramContext).inflate(2131494317, this, true);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)findViewById(2131308990));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131309006));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131310885);
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    if ((paramObject instanceof opw)) {
      a((opw)paramObject);
    }
  }
  
  public void a(opw paramopw)
  {
    if ((paramopw.a()) && (paramopw.c() == 3)) {}
    for (int i = 0;; i = 8)
    {
      setVisibility(i);
      if ((paramopw.a()) && (paramopw.c() == 3))
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
      if (!obz.a()) {
        break label52;
      }
      this.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageDrawable(avwf.a(this.jdField_a_of_type_Azwg, String.valueOf(l), 1));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setOnClickListener(new plr(this));
      return;
      label52:
      this.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageBitmap(this.jdField_a_of_type_Qoe.a(l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderSubscribe
 * JD-Core Version:    0.7.0.1
 */