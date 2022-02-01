package androidx.core.view.inputmethod;

import android.os.Bundle;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;

final class InputConnectionCompat$2
  extends InputConnectionWrapper
{
  InputConnectionCompat$2(InputConnection paramInputConnection, boolean paramBoolean, InputConnectionCompat.OnCommitContentListener paramOnCommitContentListener)
  {
    super(paramInputConnection, paramBoolean);
  }
  
  public boolean performPrivateCommand(String paramString, Bundle paramBundle)
  {
    if (InputConnectionCompat.handlePerformPrivateCommand(paramString, paramBundle, this.val$listener)) {
      return true;
    }
    return super.performPrivateCommand(paramString, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.view.inputmethod.InputConnectionCompat.2
 * JD-Core Version:    0.7.0.1
 */