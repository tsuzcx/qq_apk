package androidx.recyclerview.widget;

import androidx.annotation.Nullable;
import java.util.List;

class AsyncListDiffer$1$1
  extends DiffUtil.Callback
{
  AsyncListDiffer$1$1(AsyncListDiffer.1 param1) {}
  
  public boolean areContentsTheSame(int paramInt1, int paramInt2)
  {
    Object localObject1 = this.this$1.val$oldList.get(paramInt1);
    Object localObject2 = this.this$1.val$newList.get(paramInt2);
    if ((localObject1 != null) && (localObject2 != null)) {
      return this.this$1.this$0.mConfig.getDiffCallback().areContentsTheSame(localObject1, localObject2);
    }
    if ((localObject1 == null) && (localObject2 == null)) {
      return true;
    }
    throw new AssertionError();
  }
  
  public boolean areItemsTheSame(int paramInt1, int paramInt2)
  {
    Object localObject1 = this.this$1.val$oldList.get(paramInt1);
    Object localObject2 = this.this$1.val$newList.get(paramInt2);
    if ((localObject1 != null) && (localObject2 != null)) {
      return this.this$1.this$0.mConfig.getDiffCallback().areItemsTheSame(localObject1, localObject2);
    }
    return (localObject1 == null) && (localObject2 == null);
  }
  
  @Nullable
  public Object getChangePayload(int paramInt1, int paramInt2)
  {
    Object localObject1 = this.this$1.val$oldList.get(paramInt1);
    Object localObject2 = this.this$1.val$newList.get(paramInt2);
    if ((localObject1 != null) && (localObject2 != null)) {
      return this.this$1.this$0.mConfig.getDiffCallback().getChangePayload(localObject1, localObject2);
    }
    throw new AssertionError();
  }
  
  public int getNewListSize()
  {
    return this.this$1.val$newList.size();
  }
  
  public int getOldListSize()
  {
    return this.this$1.val$oldList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.recyclerview.widget.AsyncListDiffer.1.1
 * JD-Core Version:    0.7.0.1
 */