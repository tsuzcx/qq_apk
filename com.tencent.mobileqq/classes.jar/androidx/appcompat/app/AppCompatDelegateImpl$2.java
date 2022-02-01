package androidx.appcompat.app;

class AppCompatDelegateImpl$2
  implements Runnable
{
  AppCompatDelegateImpl$2(AppCompatDelegateImpl paramAppCompatDelegateImpl) {}
  
  public void run()
  {
    if ((this.this$0.mInvalidatePanelMenuFeatures & 0x1) != 0) {
      this.this$0.doInvalidatePanelMenu(0);
    }
    if ((this.this$0.mInvalidatePanelMenuFeatures & 0x1000) != 0) {
      this.this$0.doInvalidatePanelMenu(108);
    }
    AppCompatDelegateImpl localAppCompatDelegateImpl = this.this$0;
    localAppCompatDelegateImpl.mInvalidatePanelMenuPosted = false;
    localAppCompatDelegateImpl.mInvalidatePanelMenuFeatures = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.app.AppCompatDelegateImpl.2
 * JD-Core Version:    0.7.0.1
 */