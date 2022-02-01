package com.tencent.biz.pubaccount.readinjoy.comment.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListAdapter;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData.CommentLinkData;
import com.tencent.widget.HeightAdaptableListView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import phe;
import phg;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/comment/ui/CommentLinkView;", "Lcom/tencent/widget/HeightAdaptableListView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/comment/ui/CommentLinkView$LinkAdatper;", "linkDataList", "", "Lcom/tencent/biz/pubaccount/readinjoy/comment/data/BaseCommentData$CommentLinkData;", "onLinkEmptyListener", "Lcom/tencent/biz/pubaccount/readinjoy/comment/ui/CommentLinkView$OnLinkDeleteListener;", "getOnLinkEmptyListener", "()Lcom/tencent/biz/pubaccount/readinjoy/comment/ui/CommentLinkView$OnLinkDeleteListener;", "setOnLinkEmptyListener", "(Lcom/tencent/biz/pubaccount/readinjoy/comment/ui/CommentLinkView$OnLinkDeleteListener;)V", "setData", "", "data", "LinkAdatper", "OnLinkDeleteListener", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class CommentLinkView
  extends HeightAdaptableListView
{
  private List<BaseCommentData.CommentLinkData> jdField_a_of_type_JavaUtilList = (List)new ArrayList(0);
  private phe jdField_a_of_type_Phe;
  @Nullable
  private phg jdField_a_of_type_Phg;
  
  public CommentLinkView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public CommentLinkView(@NotNull Context paramContext, @NotNull AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CommentLinkView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setHeightAdaptMode(2, 0);
  }
  
  @Nullable
  public final phg a()
  {
    return this.jdField_a_of_type_Phg;
  }
  
  public final void setData(@Nullable List<BaseCommentData.CommentLinkData> paramList)
  {
    if (paramList != null) {}
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilList = paramList;
      if (this.jdField_a_of_type_Phe != null) {
        break;
      }
      this.jdField_a_of_type_Phe = new phe(this);
      setAdapter((ListAdapter)this.jdField_a_of_type_Phe);
      return;
      paramList = (List)new ArrayList(0);
    }
    paramList = this.jdField_a_of_type_Phe;
    if (paramList == null) {
      Intrinsics.throwNpe();
    }
    paramList.notifyDataSetChanged();
  }
  
  public final void setOnLinkEmptyListener(@Nullable phg paramphg)
  {
    this.jdField_a_of_type_Phg = paramphg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ui.CommentLinkView
 * JD-Core Version:    0.7.0.1
 */