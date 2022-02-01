package com.tencent.mobileqq.activity.qwallet.widget.ksong;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.lyric.data.Sentence;
import cooperation.qwallet.plugin.QwAdapter.IViewHolder;

public class KSongView$LrcHolder
  implements QwAdapter.IViewHolder<Sentence>
{
  public KSongTextView word;
  
  public KSongView$LrcHolder(KSongView paramKSongView) {}
  
  public QwAdapter.IViewHolder clone()
  {
    return (QwAdapter.IViewHolder)super.clone();
  }
  
  public View initView(int paramInt, View paramView)
  {
    this.word = ((KSongTextView)paramView.findViewById(2131375158));
    return paramView;
  }
  
  public void setItemView(int paramInt, View paramView, Sentence paramSentence)
  {
    this.word.reset();
    KSongTextView localKSongTextView = this.word;
    if (TextUtils.isEmpty(paramSentence.a)) {}
    for (paramView = "";; paramView = paramSentence.a)
    {
      localKSongTextView.setText(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.widget.ksong.KSongView.LrcHolder
 * JD-Core Version:    0.7.0.1
 */