import android.os.Bundle;
import android.support.annotation.NonNull;

public final class blvw
{
  private Bundle a = new Bundle();
  
  public blvw() {}
  
  public blvw(@NonNull Bundle paramBundle)
  {
    this.a = paramBundle;
  }
  
  public Bundle a()
  {
    return this.a;
  }
  
  public blvw a(int paramInt)
  {
    this.a.putInt("BUNDLE_KEY_CIRCLE_HAS_PICKED_NUM", paramInt);
    return this;
  }
  
  public blvw a(blvr paramblvr)
  {
    this.a.putInt("VIDEO_STORY_FROM_TYPE", paramblvr.a());
    return this;
  }
  
  public blvw a(boolean paramBoolean)
  {
    this.a.putBoolean("BUNDLE_KEY_CIRCLE_CAN_MIX_PICK_PHOTO_AND_VIDEO", paramBoolean);
    return this;
  }
  
  public blvw b(boolean paramBoolean)
  {
    this.a.putBoolean("BUNDLE_KEY_CIRCLE_CAN_SWITCH_SECTION_MODE", paramBoolean);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blvw
 * JD-Core Version:    0.7.0.1
 */