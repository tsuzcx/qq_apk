package com.tencent.biz.pubaccount.weishi_new.drama.gallery;

import UserGrowth.stDrama;
import UserGrowth.stDramaInfo;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.drama.checkable.OnCheckedListener;
import com.tencent.biz.pubaccount.weishi_new.drama.checkable.WSAbsCheckableHolder;
import com.tencent.biz.pubaccount.weishi_new.drama.data.WSDramaItemData;
import com.tencent.biz.pubaccount.weishi_new.drama.report.WSDramaBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.drama.utils.WSDramaUtils;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.view.RoundCornerImageView;

public class WSDramaGalleryHolder
  extends WSAbsCheckableHolder<WSDramaItemData>
{
  private static final int b = WSFeedUtils.a(7.5F);
  private RoundCornerImageView c;
  private ImageView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private String h;
  
  public WSDramaGalleryHolder(ViewGroup paramViewGroup, String paramString, OnCheckedListener<WSDramaItemData> paramOnCheckedListener)
  {
    super(paramViewGroup, 2131626042, paramOnCheckedListener);
    this.h = paramString;
    c();
    d();
  }
  
  private void a(stDramaInfo paramstDramaInfo)
  {
    this.e.setText(WSDramaUtils.a(getContext(), paramstDramaInfo));
  }
  
  private void c()
  {
    this.c = ((RoundCornerImageView)this.itemView.findViewById(2131432168));
    this.c.setCorner(b, 0);
    this.d = ((ImageView)this.itemView.findViewById(2131432169));
    this.e = ((TextView)this.itemView.findViewById(2131432171));
    this.f = ((TextView)this.itemView.findViewById(2131432172));
    this.g = ((TextView)this.itemView.findViewById(2131432170));
  }
  
  private void d()
  {
    this.itemView.setOnClickListener(new WSDramaGalleryHolder.1(this));
  }
  
  public void a(WSDramaItemData paramWSDramaItemData)
  {
    super.a(paramWSDramaItemData);
    a(paramWSDramaItemData.a());
    paramWSDramaItemData = paramWSDramaItemData.f().dramaInfo;
    a(paramWSDramaItemData);
    this.f.setText(paramWSDramaItemData.name);
    this.g.setText(paramWSDramaItemData.recmdDesc);
    WSPicLoader.a().a(this.c, paramWSDramaItemData.coverImg, WSFeedUtils.f(2131168374), "", 0);
  }
  
  public void a(WSDramaGalleryHolder paramWSDramaGalleryHolder)
  {
    WSDramaBeaconReport.a((WSDramaItemData)paramWSDramaGalleryHolder.b(), getAdapterPosition(), this.h);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.d.setImageResource(2130842794);
      this.e.setTextColor(-16777216);
      return;
    }
    this.d.setImageResource(2130842793);
    this.e.setTextColor(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.gallery.WSDramaGalleryHolder
 * JD-Core Version:    0.7.0.1
 */