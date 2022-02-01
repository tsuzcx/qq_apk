import android.os.Bundle;
import android.support.annotation.NonNull;

public final class bnlg
{
  private Bundle a = new Bundle();
  
  public bnlg() {}
  
  public bnlg(@NonNull Bundle paramBundle)
  {
    this.a = paramBundle;
  }
  
  public Bundle a()
  {
    return this.a;
  }
  
  public bnlg a(int paramInt)
  {
    this.a.putInt("BUNDLE_KEY_CIRCLE_HAS_PICKED_NUM", paramInt);
    return this;
  }
  
  public bnlg a(bnlb parambnlb)
  {
    this.a.putInt("VIDEO_STORY_FROM_TYPE", parambnlb.a());
    return this;
  }
  
  public bnlg a(boolean paramBoolean)
  {
    this.a.putBoolean("BUNDLE_KEY_CIRCLE_CAN_MIX_PICK_PHOTO_AND_VIDEO", paramBoolean);
    return this;
  }
  
  public bnlg b(boolean paramBoolean)
  {
    this.a.putBoolean("BUNDLE_KEY_CIRCLE_CAN_SWITCH_SECTION_MODE", paramBoolean);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnlg
 * JD-Core Version:    0.7.0.1
 */