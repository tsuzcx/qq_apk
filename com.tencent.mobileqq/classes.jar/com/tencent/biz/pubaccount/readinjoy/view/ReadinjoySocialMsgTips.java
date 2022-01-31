package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import mim;

public class ReadinjoySocialMsgTips
  implements FaceDecoder.DecodeTaskCompletionListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private KandianOx210MsgInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  
  ReadinjoySocialMsgTips(Activity paramActivity, View paramView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramActivity;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(paramActivity.getApplicationContext(), (QQAppInterface)ReadInJoyUtils.a());
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    d();
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362701));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363039));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new mim(this));
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo != null))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      PublicAccountReportUtils.a(null, "", "0X800824A", "0X800824A", 0, 0, "", "", "", ReadInJoyUtils.d(), false);
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(KandianOx210MsgInfo paramKandianOx210MsgInfo)
  {
    if (paramKandianOx210MsgInfo == null)
    {
      QLog.d("ReadinjoySocialMsgTips", 2, "210 msgInfo is null !");
      return;
    }
    QLog.d("ReadinjoySocialMsgTips", 2, "set msg info , count : " + paramKandianOx210MsgInfo.a + ", uin : " + paramKandianOx210MsgInfo.e + ", seq : " + paramKandianOx210MsgInfo.b);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo = paramKandianOx210MsgInfo;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.e == -1L) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidWidgetImageView.getResources().getDrawable(2130840796));
    }
    while (paramKandianOx210MsgInfo.a < 100)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramKandianOx210MsgInfo.a + "条新消息");
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a((QQAppInterface)ReadInJoyUtils.a());
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.e), 1));
      }
      else
      {
        QLog.d("ReadinjoySocialMsgTips", 2, "faceDecoder is null, set default image drawable!");
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(ImageUtil.b());
      }
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText("99+条新消息");
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidContentContext = null;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = null;
    }
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = null;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo != null) && (TextUtils.equals(paramString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.e + ""))) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoySocialMsgTips
 * JD-Core Version:    0.7.0.1
 */