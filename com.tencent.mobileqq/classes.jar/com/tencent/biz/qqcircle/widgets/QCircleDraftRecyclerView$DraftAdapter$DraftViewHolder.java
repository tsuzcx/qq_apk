package com.tencent.biz.qqcircle.widgets;

import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.qcircle.api.data.Option;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;

class QCircleDraftRecyclerView$DraftAdapter$DraftViewHolder
  extends RecyclerView.ViewHolder
{
  private final URLImageView a;
  private final ImageView b;
  private final TextView c;
  private final CheckBox d;
  
  public QCircleDraftRecyclerView$DraftAdapter$DraftViewHolder(View paramView)
  {
    super(paramView);
    this.c = ((TextView)paramView.findViewById(2131448402));
    this.d = ((CheckBox)paramView.findViewById(2131430409));
    this.a = ((URLImageView)paramView.findViewById(2131436356));
    this.b = ((ImageView)paramView.findViewById(2131436357));
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Option localOption = new Option();
    localOption.setUrl(paramString).setTargetView(paramImageView).setPredecode(true).setRequestWidth(QCircleDraftRecyclerView.DraftAdapter.a).setRequestHeight(paramImageView.getHeight());
    QCircleFeedPicLoader.g().loadImage(localOption, new QCircleDraftRecyclerView.DraftAdapter.DraftViewHolder.1(this, paramImageView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleDraftRecyclerView.DraftAdapter.DraftViewHolder
 * JD-Core Version:    0.7.0.1
 */