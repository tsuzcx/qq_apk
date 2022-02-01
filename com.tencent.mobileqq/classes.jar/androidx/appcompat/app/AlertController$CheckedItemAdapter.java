package androidx.appcompat.app;

import android.content.Context;
import android.widget.ArrayAdapter;

class AlertController$CheckedItemAdapter
  extends ArrayAdapter<CharSequence>
{
  public AlertController$CheckedItemAdapter(Context paramContext, int paramInt1, int paramInt2, CharSequence[] paramArrayOfCharSequence)
  {
    super(paramContext, paramInt1, paramInt2, paramArrayOfCharSequence);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.app.AlertController.CheckedItemAdapter
 * JD-Core Version:    0.7.0.1
 */