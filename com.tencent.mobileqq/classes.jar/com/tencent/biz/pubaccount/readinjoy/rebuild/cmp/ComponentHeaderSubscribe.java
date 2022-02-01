package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import anzj;
import bcni;
import bhkv;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.FixSizeImageView;
import ocd;
import org.json.JSONException;
import org.json.JSONObject;
import oyu;
import ozs;
import ppu;
import qno;
import qpz;
import sel;
import tencent.im.oidb.articlesummary.articlesummary.SubscribeInfo;
import ubg;

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
    if (this.jdField_a_of_type_Qno.a.c() == 3) {
      try
      {
        long l = Long.parseLong(this.jdField_a_of_type_Qno.a.a().mSubscribeID);
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
    Object localObject = this.jdField_a_of_type_Qno.a;
    if (((ppu)localObject).c() == 3)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (!((ppu)localObject).a().mSubscribeInfoObj.bytes_test.has()) {}
    }
    label193:
    for (;;)
    {
      try
      {
        localObject = ((ppu)localObject).a().mSubscribeInfoObj.bytes_test.get().toStringUtf8();
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
        ((TextView)this.jdField_a_of_type_AndroidViewView).setText(anzj.a(2131701183));
        return;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      ((TextView)this.jdField_a_of_type_AndroidViewView).setText(anzj.a(2131701201));
      return;
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(ozs.e(this.jdField_a_of_type_Qno.a.a().mSubscribeName));
  }
  
  private void f()
  {
    String str = oyu.k + bhkv.encodeToString(String.valueOf(a()).getBytes(), 2);
    ozs.a(getContext(), str);
    g();
  }
  
  private void g()
  {
    try
    {
      JSONObject localJSONObject = ozs.a();
      localJSONObject.put("feeds_source", ozs.d(this.jdField_a_of_type_Qno.a.a()));
      localJSONObject.put("kandian_mode", ozs.e());
      String str2 = ozs.e(this.jdField_a_of_type_Qno.a.a());
      if (ubg.a(this.jdField_a_of_type_Qno.a.e())) {}
      for (String str1 = "0X8009357";; str1 = "0X800744D")
      {
        ocd.a(null, "CliOper", "", "", str1, str1, 0, 0, str2, "", "", localJSONObject.toString(), false);
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
    return LayoutInflater.from(paramContext).inflate(2131560141, this, true);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)findViewById(2131376117));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376133));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131378226);
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    if ((paramObject instanceof ppu)) {
      a((ppu)paramObject);
    }
  }
  
  public void a(ppu paramppu)
  {
    if ((paramppu.a()) && (paramppu.c() == 3)) {}
    for (int i = 0;; i = 8)
    {
      setVisibility(i);
      if ((paramppu.a()) && (paramppu.c() == 3))
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
      if (!ozs.a()) {
        break label52;
      }
      this.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageDrawable(bcni.a(this.jdField_a_of_type_Aoof, String.valueOf(l), 1));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setOnClickListener(new qpz(this));
      return;
      label52:
      this.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageBitmap(this.jdField_a_of_type_Sel.a(l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderSubscribe
 * JD-Core Version:    0.7.0.1
 */