package com.tencent.biz.subscribe.comment;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import alud;
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
import bdam;
import bdhj;
import bdnn;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.net.URLEncoder;
import mqq.app.AppRuntime;
import xsm;
import ygx;
import yha;
import yhl;
import yhn;

public class ReplyView
  extends RelativeLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  private static final String jdField_a_of_type_JavaLangString = ReplyView.class.getName();
  private int jdField_a_of_type_Int;
  private CertifiedAccountMeta.StComment jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment;
  private CertifiedAccountMeta.StReply jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply;
  private BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  RoundCornerImageView jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView;
  AsyncRichTextView jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView;
  private yhn jdField_a_of_type_Yhn;
  private boolean jdField_a_of_type_Boolean;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private final String jdField_b_of_type_JavaLangString = alud.a(2131713804);
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
      String str = URLEncoder.encode(paramString2, "UTF-8");
      paramString2 = str;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "build nickname partially failed" + localException);
      }
    }
    return "<uin:" + paramString1 + ",nickname:" + paramString2 + ">";
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131558751, this, true);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView = ((RoundCornerImageView)localView.findViewById(2131368706));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setCorner(ImmersiveUtils.a(18.0F));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131375673));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView = ((AsyncRichTextView)localView.findViewById(2131375671));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setNeedParseColor(true);
    this.c = ((TextView)localView.findViewById(2131375672));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131363686));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131375666));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131375665));
    this.d = ((TextView)localView.findViewById(2131375667));
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
    switch (paramView.getId())
    {
    default: 
      if ((((paramView instanceof ReplyView)) || (paramView.getId() == 2131363686)) && (this.jdField_a_of_type_Yhn != null))
      {
        localStComment = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment;
        localStReply = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply;
        this.jdField_a_of_type_Yhn.a(paramView, 7, this.jdField_a_of_type_Int, new Object[] { localStComment, localStReply });
      }
      break;
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.jdField_a_of_type_Yhn == null) || (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply == null));
        this.jdField_a_of_type_Yhn.a(paramView, 1, this.jdField_a_of_type_Int, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply.postUser);
        return;
      } while ((this.jdField_a_of_type_Yhn == null) || (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply == null));
      this.jdField_a_of_type_Yhn.a(paramView, 2, this.jdField_a_of_type_Int, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply.postUser);
      return;
    } while (this.jdField_a_of_type_Yhn == null);
    CertifiedAccountMeta.StComment localStComment = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment;
    CertifiedAccountMeta.StReply localStReply = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply;
    this.jdField_a_of_type_Yhn.a(paramView, 7, this.jdField_a_of_type_Int, new Object[] { localStComment, localStReply });
  }
  
  public boolean onLongClick(View paramView)
  {
    boolean bool = true;
    switch (paramView.getId())
    {
    default: 
      bool = false;
    }
    do
    {
      return bool;
    } while (this.jdField_a_of_type_Yhn == null);
    CertifiedAccountMeta.StComment localStComment = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment;
    CertifiedAccountMeta.StReply localStReply = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply;
    this.jdField_a_of_type_Yhn.b(paramView, 8, this.jdField_a_of_type_Int, new Object[] { localStComment, localStReply });
    return true;
  }
  
  public void setData(CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply, String paramString)
  {
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment = paramStComment;
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply = paramStReply;
    if ((paramStComment == null) || (paramStReply == null)) {
      return;
    }
    if (paramStReply.postUser != null)
    {
      if ((BaseApplicationImpl.getApplication().getRuntime().getAccount().equals(paramStReply.postUser.id.get())) && (bdnn.a(paramStReply.postUser.icon.get())))
      {
        if (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable == null) {
          this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = new BitmapDrawable(bdhj.c(yhl.a(yhl.a(null, 1, paramStReply.postUser.id.get(), 0)).a, 50, 50));
        }
        xsm.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView, "", xsm.a(getContext(), 35.0F), xsm.a(getContext(), 35.0F), xsm.a(getContext(), 18.0F), this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable, null);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramStReply.postUser.nick.get());
        if (!paramStReply.postUser.id.get().equals(paramString)) {
          break label539;
        }
        if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
        {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130850237);
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, ImmersiveUtils.a(21.0F), ImmersiveUtils.a(12.0F));
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(ImmersiveUtils.a(2.0F));
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null);
      }
    }
    else
    {
      label259:
      paramString = new StringBuilder();
      if ((paramStComment != null) && (paramStReply.targetUser != null) && (!paramStComment.postUser.id.get().equals(paramStReply.targetUser.id.get())))
      {
        paramString.append("{text:").append(this.jdField_b_of_type_JavaLangString).append(",color:").append(Integer.toHexString(getResources().getColor(2131167070))).append(",useDefaultFont:1,useSuperFont:0}");
        paramString.append(a(paramStReply.targetUser.id.get(), paramStReply.targetUser.nick.get()));
        paramString.append("{text:").append("：").append(",color:").append(Integer.toHexString(getResources().getColor(2131167071))).append(",useDefaultFont:1,useSuperFont:0}");
      }
      paramString.append(paramStReply.content.get());
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setText(paramString);
      this.c.setText(yha.a(paramStReply.createTime.get() * 1000L));
      this.jdField_a_of_type_Boolean = false;
      paramStComment = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      if (ygx.a()) {
        break label553;
      }
    }
    label539:
    label553:
    for (int i = 0;; i = 8)
    {
      paramStComment.setVisibility(i);
      return;
      xsm.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView, paramStReply.postUser.icon.get(), xsm.a(getContext(), 22.0F), xsm.a(getContext(), 22.0F), xsm.a(getContext(), 11.0F), bdhj.b(), null);
      break;
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      break label259;
    }
  }
  
  public void setOnCommentElementClickListener(yhn paramyhn)
  {
    this.jdField_a_of_type_Yhn = paramyhn;
  }
  
  public void setPosition(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.ReplyView
 * JD-Core Version:    0.7.0.1
 */