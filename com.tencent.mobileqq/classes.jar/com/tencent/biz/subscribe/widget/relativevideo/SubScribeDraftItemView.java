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
  private static String c = "SubScribeDraftItemView";
  private int d = ImmersiveUtils.getScreenWidth() / 2;
  private RoundCornerImageView e;
  private AsyncRichTextView f;
  private TextView g;
  private ImageView h;
  private ImageView i;
  private TextView j;
  private String k;
  private SubscribeDraftAdapter l;
  
  public SubScribeDraftItemView(@NonNull Context paramContext, SubscribeDraftAdapter paramSubscribeDraftAdapter)
  {
    super(paramContext);
    this.l = paramSubscribeDraftAdapter;
  }
  
  private boolean b()
  {
    Object localObject = this.l;
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
          if (((SubscribeBaseBottomPersonalFragment.BottomData)localObject).h != null)
          {
            bool1 = bool2;
            if (((SubscribeBaseBottomPersonalFragment.BottomData)localObject).h.user.youZhan.size() > 0)
            {
              bool1 = bool2;
              if (((CertifiedAccountMeta.StYouZanShop)((SubscribeBaseBottomPersonalFragment.BottomData)localObject).h.user.youZhan.get(0)).type.get() > 1) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private String getPostUin()
  {
    Object localObject = this.l;
    if (localObject != null)
    {
      localObject = ((SubscribeDraftAdapter)localObject).a("share_key_subscribe_opus");
      if ((localObject != null) && ((((BlockMerger.ShareData)localObject).a instanceof SubscribeBaseBottomPersonalFragment.BottomData))) {
        return ((SubscribeBaseBottomPersonalFragment.BottomData)((BlockMerger.ShareData)localObject).a).i;
      }
    }
    return "";
  }
  
  protected void a(Context paramContext, View paramView)
  {
    this.e = ((RoundCornerImageView)paramView.findViewById(2131432131));
    this.f = ((AsyncRichTextView)paramView.findViewById(2131432137));
    this.h = ((ImageView)paramView.findViewById(2131432132));
    this.i = ((ImageView)paramView.findViewById(2131432135));
    this.k = ((PublicFragmentActivity)paramContext).app.getCurrentUin();
    this.j = ((TextView)paramView.findViewById(2131432138));
    this.g = ((TextView)paramView.findViewById(2131432136));
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
      this.f.setVisibility(8);
    }
    else
    {
      this.f.setVisibility(0);
      this.f.setText((CharSequence)localObject1);
    }
    float f1;
    if (paramSubscribeDraftBean.getWidth() >= paramSubscribeDraftBean.getHeight()) {
      f1 = 0.75F;
    } else {
      f1 = 1.333333F;
    }
    this.e.getLayoutParams().height = ((int)(this.d * f1));
    this.e.getLayoutParams().width = this.d;
    this.e.requestLayout();
    if ((!TextUtils.isEmpty(paramSubscribeDraftBean.getCoverUrl())) && (FileUtil.d(paramSubscribeDraftBean.getCoverUrl())))
    {
      localObject1 = paramSubscribeDraftBean.getCoverUrl();
      localObject2 = this.e;
      SubImageLoader.a((String)localObject1, (URLImageView)localObject2, SubImageLoader.b((URLImageView)localObject2), true);
    }
    else
    {
      this.e.setImageResource(2130842613);
    }
    this.g.setText(SubscribeUtils.e(paramSubscribeDraftBean.getDraftId()));
    if (paramSubscribeDraftBean.getDrafTtype() == SubscribeDraftBean.TYPE_VIDEO)
    {
      int m = (int)(paramSubscribeDraftBean.getDuration() / 1000L / 60L);
      int n = (int)(paramSubscribeDraftBean.getDuration() / 1000L % 60L);
      if ((m != 0) || (n != 0))
      {
        this.j.setText(String.format("%02d:%02d", new Object[] { Integer.valueOf(m), Integer.valueOf(n) }));
        this.j.setVisibility(0);
        this.i.setVisibility(0);
      }
    }
    else
    {
      this.j.setVisibility(8);
      this.i.setVisibility(8);
    }
    this.e.setOnClickListener(new SubScribeDraftItemView.1(this, paramSubscribeDraftBean));
    this.h.setOnClickListener(new SubScribeDraftItemView.2(this, paramSubscribeDraftBean));
  }
  
  protected int getLayoutId()
  {
    return 2131624359;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.SubScribeDraftItemView
 * JD-Core Version:    0.7.0.1
 */