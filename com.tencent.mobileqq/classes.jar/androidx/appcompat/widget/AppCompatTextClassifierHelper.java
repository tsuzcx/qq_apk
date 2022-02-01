package androidx.appcompat.widget;

import android.content.Context;
import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;

final class AppCompatTextClassifierHelper
{
  @Nullable
  private TextClassifier mTextClassifier;
  @NonNull
  private TextView mTextView;
  
  AppCompatTextClassifierHelper(TextView paramTextView)
  {
    this.mTextView = ((TextView)Preconditions.checkNotNull(paramTextView));
  }
  
  @NonNull
  @RequiresApi(api=26)
  public TextClassifier getTextClassifier()
  {
    TextClassifier localTextClassifier = this.mTextClassifier;
    Object localObject = localTextClassifier;
    if (localTextClassifier == null)
    {
      localObject = (TextClassificationManager)this.mTextView.getContext().getSystemService(TextClassificationManager.class);
      if (localObject != null) {
        return ((TextClassificationManager)localObject).getTextClassifier();
      }
      localObject = TextClassifier.NO_OP;
    }
    return localObject;
  }
  
  @RequiresApi(api=26)
  public void setTextClassifier(@Nullable TextClassifier paramTextClassifier)
  {
    this.mTextClassifier = paramTextClassifier;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatTextClassifierHelper
 * JD-Core Version:    0.7.0.1
 */