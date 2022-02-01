package com.tencent.biz.subscribe.widget.relativevideo;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanShop;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.biz.subscribe.SubImageLoader;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.beans.SubscribeDraftBean;
import com.tencent.biz.subscribe.bizdapters.SubscribeDraftAdapter;
import com.tencent.biz.subscribe.fragments.SubscribeBaseBottomPersonalFragment.BottomData;
import com.tencent.biz.subscribe.part.block.BlockMerger.ShareData;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.widget.immersive.ImmersiveUtils;

public class SubScribeDraftItemView
  extends BaseWidgetView<SubscribeDraftBean>
{
  private static String jdField_a_of_type_JavaLangString = "SubScribeDraftItemView";
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RoundCornerImageView jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView;
  private SubscribeDraftAdapter jdField_a_of_type_ComTencentBizSubscribeBizdaptersSubscribeDraftAdapter;
  private AsyncRichTextView jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private int c = ImmersiveUtils.getScreenWidth() / 2;
  
  public SubScribeDraftItemView(@NonNull Context paramContext, SubscribeDraftAdapter paramSubscribeDraftAdapter)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersSubscribeDraftAdapter = paramSubscribeDraftAdapter;
  }
  
  private boolean a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersSubscribeDraftAdapter;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      localObject = ((SubscribeDraftAdapter)localObject).a("share_key_subscribe_opus");
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if ((((BlockMerger.ShareData)localObject).a instanceof SubscribeBaseBottomPersonalFragment.BottomData))
        {
          localObject = (SubscribeBaseBottomPersonalFragment.BottomData)((BlockMerger.ShareData)localObject).a;
          bool1 = bool2;
          if (((SubscribeBaseBottomPersonalFragment.BottomData)localObject).a != null)
          {
            bool1 = bool2;
            if (((SubscribeBaseBottomPersonalFragment.BottomData)localObject).a.user.youZhan.size() > 0)
            {
              bool1 = bool2;
              if (((CertifiedAccountMeta.StYouZanShop)((SubscribeBaseBottomPersonalFragment.BottomData)localObject).a.user.youZhan.get(0)).type.get() > 1) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private String b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersSubscribeDraftAdapter;
    if (localObject != null)
    {
      localObject = ((SubscribeDraftAdapter)localObject).a("share_key_subscribe_opus");
      if ((localObject != null) && ((((BlockMerger.ShareData)localObject).a instanceof SubscribeBaseBottomPersonalFragment.BottomData))) {
        return ((SubscribeBaseBottomPersonalFragment.BottomData)((BlockMerger.ShareData)localObject).a).jdField_b_of_type_JavaLangString;
      }
    }
    return "";
  }
  
  protected int a()
  {
    return 2131558739;
  }
  
  protected void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView = ((RoundCornerImageView)paramView.findViewById(2131365872));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView = ((AsyncRichTextView)paramView.findViewById(2131365878));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365873));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365876));
    this.jdField_b_of_type_JavaLangString = ((PublicFragmentActivity)paramContext).app.getCurrentUin();
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365879));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365877));
  }
  
  protected void a(SubscribeDraftBean paramSubscribeDraftBean)
  {
    if (paramSubscribeDraftBean == null) {
      return;
    }
    Object localObject2 = paramSubscribeDraftBean.getTitle();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = paramSubscribeDraftBean.getDescirbeSource();
    }
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setVisibility(8);
    }
    else
    {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setText((CharSequence)localObject1);
    }
    float f;
    if (paramSubscribeDraftBean.getWidth() >= paramSubscribeDraftBean.getHeight()) {
      f = 0.75F;
    } else {
      f = 1.333333F;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.getLayoutParams().height = ((int)(this.c * f));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.getLayoutParams().width = this.c;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.requestLayout();
    if ((!TextUtils.isEmpty(paramSubscribeDraftBean.getCoverUrl())) && (FileUtil.b(paramSubscribeDraftBean.getCoverUrl())))
    {
      localObject1 = paramSubscribeDraftBean.getCoverUrl();
      localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView;
      SubImageLoader.a((String)localObject1, (URLImageView)localObject2, SubImageLoader.b((URLImageView)localObject2), true);
    }
    else
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setImageResource(2130841698);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(SubscribeUtils.a(paramSubscribeDraftBean.getDraftId()));
    if (paramSubscribeDraftBean.getDrafTtype() == SubscribeDraftBean.TYPE_VIDEO)
    {
      int i = (int)(paramSubscribeDraftBean.getDuration() / 1000L / 60L);
      int j = (int)(paramSubscribeDraftBean.getDuration() / 1000L % 60L);
      if ((i != 0) || (j != 0))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("%02d:%02d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    else
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setOnClickListener(new SubScribeDraftItemView.1(this, paramSubscribeDraftBean));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new SubScribeDraftItemView.2(this, paramSubscribeDraftBean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.SubScribeDraftItemView
 * JD-Core Version:    0.7.0.1
 */