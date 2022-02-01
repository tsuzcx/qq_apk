package com.tencent.biz.subscribe.widget.relativevideo;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanShop;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import aack;
import aacl;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.beans.SubscribeDraftBean;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.widget.immersive.ImmersiveUtils;
import zos;
import zqf;
import zqn;
import ztj;
import zwv;

public class SubScribeDraftItemView
  extends BaseWidgetView<SubscribeDraftBean>
{
  private static String jdField_a_of_type_JavaLangString = "SubScribeDraftItemView";
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RoundCornerImageView jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView;
  private AsyncRichTextView jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView;
  private ztj jdField_a_of_type_Ztj;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private int c = ImmersiveUtils.a() / 2;
  
  public SubScribeDraftItemView(@NonNull Context paramContext, ztj paramztj)
  {
    super(paramContext);
    this.jdField_a_of_type_Ztj = paramztj;
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_Ztj != null)
    {
      Object localObject = this.jdField_a_of_type_Ztj.a("share_key_subscribe_opus");
      if ((localObject != null) && ((((zos)localObject).a instanceof zwv)))
      {
        localObject = (zwv)((zos)localObject).a;
        if ((((zwv)localObject).a != null) && (((zwv)localObject).a.user.youZhan.size() > 0)) {
          return ((CertifiedAccountMeta.StYouZanShop)((zwv)localObject).a.user.youZhan.get(0)).type.get() > 1;
        }
      }
    }
    return false;
  }
  
  private String b()
  {
    if (this.jdField_a_of_type_Ztj != null)
    {
      zos localzos = this.jdField_a_of_type_Ztj.a("share_key_subscribe_opus");
      if ((localzos != null) && ((localzos.a instanceof zwv))) {
        return ((zwv)localzos.a).jdField_b_of_type_JavaLangString;
      }
    }
    return "";
  }
  
  public int a()
  {
    return 2131558801;
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView = ((RoundCornerImageView)paramView.findViewById(2131365876));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView = ((AsyncRichTextView)paramView.findViewById(2131365882));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365877));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365880));
    this.jdField_b_of_type_JavaLangString = ((PublicFragmentActivity)paramContext).app.getCurrentUin();
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365883));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365881));
  }
  
  protected void a(SubscribeDraftBean paramSubscribeDraftBean)
  {
    if (paramSubscribeDraftBean == null) {
      return;
    }
    String str2 = paramSubscribeDraftBean.getTitle();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = paramSubscribeDraftBean.getDescirbeSource();
    }
    float f;
    if (TextUtils.isEmpty(str1))
    {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setVisibility(8);
      if (paramSubscribeDraftBean.getWidth() < paramSubscribeDraftBean.getHeight()) {
        break label290;
      }
      f = 0.75F;
      label60:
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.getLayoutParams().height = ((int)(f * this.c));
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.getLayoutParams().width = this.c;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.requestLayout();
      if ((!TextUtils.isEmpty(paramSubscribeDraftBean.getCoverUrl())) && (FileUtil.isFileExists(paramSubscribeDraftBean.getCoverUrl()))) {
        break label297;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setImageResource(2130841669);
      label128:
      this.jdField_a_of_type_AndroidWidgetTextView.setText(zqn.a(paramSubscribeDraftBean.getDraftId()));
      if (paramSubscribeDraftBean.getDrafTtype() != SubscribeDraftBean.TYPE_VIDEO) {
        break label319;
      }
      int i = (int)(paramSubscribeDraftBean.getDuration() / 1000L / 60L);
      int j = (int)(paramSubscribeDraftBean.getDuration() / 1000L % 60L);
      if ((i != 0) || (j != 0))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("%02d:%02d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setOnClickListener(new aack(this, paramSubscribeDraftBean));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new aacl(this, paramSubscribeDraftBean));
      return;
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setText(str1);
      break;
      label290:
      f = 1.333333F;
      break label60;
      label297:
      zqf.a(paramSubscribeDraftBean.getCoverUrl(), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView, zqf.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView), true);
      break label128;
      label319:
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.SubScribeDraftItemView
 * JD-Core Version:    0.7.0.1
 */