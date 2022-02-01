package com.tencent.biz.subscribe.comment;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.util.BitmapManager.BitmapDecodeResult;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.net.URLEncoder;
import mqq.app.AppRuntime;

public class ReplyView
  extends RelativeLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  private static final String jdField_a_of_type_JavaLangString = "com.tencent.biz.subscribe.comment.ReplyView";
  private int jdField_a_of_type_Int;
  private CertifiedAccountMeta.StComment jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment;
  private CertifiedAccountMeta.StReply jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply;
  private BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  RoundCornerImageView jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView;
  private OnCommentElementClickListener jdField_a_of_type_ComTencentBizSubscribeCommentOnCommentElementClickListener;
  AsyncRichTextView jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView;
  private boolean jdField_a_of_type_Boolean = false;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private final String jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131713335);
  TextView c;
  TextView d;
  
  public ReplyView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReplyView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ReplyView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
    b();
  }
  
  private String a(String paramString1, String paramString2)
  {
    try
    {
      String str1 = URLEncoder.encode(paramString2, "UTF-8");
      paramString2 = str1;
    }
    catch (Exception localException)
    {
      String str2 = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("build nickname partially failed");
      localStringBuilder2.append(localException);
      QLog.e(str2, 1, localStringBuilder2.toString());
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("<uin:");
    localStringBuilder1.append(paramString1);
    localStringBuilder1.append(",nickname:");
    localStringBuilder1.append(paramString2);
    localStringBuilder1.append(">");
    return localStringBuilder1.toString();
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131558786, this, true);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView = ((RoundCornerImageView)localView.findViewById(2131369286));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setCorner(ImmersiveUtils.dpToPx(18.0F));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131376433));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView = ((AsyncRichTextView)localView.findViewById(2131376431));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setNeedParseColor(true);
    this.c = ((TextView)localView.findViewById(2131376432));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131364034));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131376426));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131376425));
    this.d = ((TextView)localView.findViewById(2131376427));
    setPadding(0, 0, 0, Utils.dp2px(5.0D));
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setOnLongClickListener(this);
    setOnLongClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    OnCommentElementClickListener localOnCommentElementClickListener;
    Object localObject;
    CertifiedAccountMeta.StReply localStReply;
    switch (paramView.getId())
    {
    default: 
      if (!(paramView instanceof ReplyView)) {
        if (paramView.getId() != 2131364034) {
          break label236;
        }
      }
      break;
    case 2131376433: 
      localOnCommentElementClickListener = this.jdField_a_of_type_ComTencentBizSubscribeCommentOnCommentElementClickListener;
      if (localOnCommentElementClickListener != null)
      {
        localObject = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply;
        if (localObject != null) {
          localOnCommentElementClickListener.a(paramView, 2, this.jdField_a_of_type_Int, ((CertifiedAccountMeta.StReply)localObject).postUser);
        }
      }
      break;
    case 2131376431: 
      localOnCommentElementClickListener = this.jdField_a_of_type_ComTencentBizSubscribeCommentOnCommentElementClickListener;
      if (localOnCommentElementClickListener != null)
      {
        localObject = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment;
        localStReply = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply;
        localOnCommentElementClickListener.a(paramView, 7, this.jdField_a_of_type_Int, new Object[] { localObject, localStReply });
      }
      break;
    case 2131369286: 
      localOnCommentElementClickListener = this.jdField_a_of_type_ComTencentBizSubscribeCommentOnCommentElementClickListener;
      if (localOnCommentElementClickListener != null)
      {
        localObject = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply;
        if (localObject != null)
        {
          localOnCommentElementClickListener.a(paramView, 1, this.jdField_a_of_type_Int, ((CertifiedAccountMeta.StReply)localObject).postUser);
          break label236;
          localOnCommentElementClickListener = this.jdField_a_of_type_ComTencentBizSubscribeCommentOnCommentElementClickListener;
          if (localOnCommentElementClickListener != null)
          {
            localObject = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment;
            localStReply = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply;
            localOnCommentElementClickListener.a(paramView, 7, this.jdField_a_of_type_Int, new Object[] { localObject, localStReply });
          }
        }
      }
      break;
    }
    label236:
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onLongClick(View paramView)
  {
    if (paramView.getId() != 2131376431) {
      return false;
    }
    OnCommentElementClickListener localOnCommentElementClickListener = this.jdField_a_of_type_ComTencentBizSubscribeCommentOnCommentElementClickListener;
    if (localOnCommentElementClickListener != null)
    {
      CertifiedAccountMeta.StComment localStComment = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment;
      CertifiedAccountMeta.StReply localStReply = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply;
      localOnCommentElementClickListener.b(paramView, 8, this.jdField_a_of_type_Int, new Object[] { localStComment, localStReply });
    }
    return true;
  }
  
  public void setData(CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply, String paramString)
  {
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment = paramStComment;
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply = paramStReply;
    if (paramStComment != null)
    {
      if (paramStReply == null) {
        return;
      }
      CertifiedAccountMeta.StUser localStUser = paramStReply.postUser;
      int i = 0;
      if (localStUser != null)
      {
        if ((BaseApplicationImpl.getApplication().getRuntime().getAccount().equals(paramStReply.postUser.id.get())) && (StringUtil.a(paramStReply.postUser.icon.get())))
        {
          if (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable == null) {
            this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = new BitmapDrawable(ImageUtil.c(LocalHeadFetchUtils.a(LocalHeadFetchUtils.a(null, 1, paramStReply.postUser.id.get(), 0)).a, 50, 50));
          }
          UIUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView, "", UIUtils.a(getContext(), 35.0F), UIUtils.a(getContext(), 35.0F), UIUtils.a(getContext(), 18.0F), this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable, null);
        }
        else
        {
          UIUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView, paramStReply.postUser.icon.get(), UIUtils.a(getContext(), 22.0F), UIUtils.a(getContext(), 22.0F), UIUtils.a(getContext(), 11.0F), ImageUtil.e(), null);
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramStReply.postUser.nick.get());
        if (paramStReply.postUser.id.get().equals(paramString))
        {
          if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
          {
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130851305);
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, ImmersiveUtils.dpToPx(21.0F), ImmersiveUtils.dpToPx(12.0F));
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(ImmersiveUtils.dpToPx(2.0F));
          this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null);
        }
        else
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        }
      }
      paramString = new StringBuilder();
      if ((paramStComment != null) && (paramStReply.targetUser != null) && (!paramStComment.postUser.id.get().equals(paramStReply.targetUser.id.get())))
      {
        paramString.append("{text:");
        paramString.append(this.jdField_b_of_type_JavaLangString);
        paramString.append(",color:");
        paramString.append(Integer.toHexString(getResources().getColor(2131167241)));
        paramString.append(",useDefaultFont:1,useSuperFont:0}");
        paramString.append(a(paramStReply.targetUser.id.get(), paramStReply.targetUser.nick.get()));
        paramString.append("{text:");
        paramString.append("：");
        paramString.append(",color:");
        paramString.append(Integer.toHexString(getResources().getColor(2131167242)));
        paramString.append(",useDefaultFont:1,useSuperFont:0}");
      }
      paramString.append(paramStReply.content.get());
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setText(paramString);
      this.c.setText(DateUtils.a(paramStReply.createTime.get() * 1000L));
      this.jdField_a_of_type_Boolean = false;
      paramStComment = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      if (CommentUIConfig.a()) {
        i = 8;
      }
      paramStComment.setVisibility(i);
    }
  }
  
  public void setOnCommentElementClickListener(OnCommentElementClickListener paramOnCommentElementClickListener)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeCommentOnCommentElementClickListener = paramOnCommentElementClickListener;
  }
  
  public void setPosition(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.ReplyView
 * JD-Core Version:    0.7.0.1
 */