package com.tencent.biz.qqstory.storyHome.tag;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.tag.TagItem.TagInfoBase;

class TagAdapter$TagViewHolder
{
  public TextView a;
  
  public TagAdapter$TagViewHolder(View paramView)
  {
    this.a = ((TextView)paramView.findViewById(2131446778));
  }
  
  public void a(TagItem.TagInfoBase paramTagInfoBase, TagAdapter.OnItemClickListener paramOnItemClickListener)
  {
    if (TextUtils.isEmpty(paramTagInfoBase.b))
    {
      this.a.setVisibility(8);
      return;
    }
    this.a.setVisibility(0);
    this.a.setText(TagAdapter.a(paramTagInfoBase));
    TagAdapter.a(this.a);
    this.a.setOnClickListener(new TagAdapter.TagViewHolder.1(this, paramOnItemClickListener, paramTagInfoBase));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.tag.TagAdapter.TagViewHolder
 * JD-Core Version:    0.7.0.1
 */