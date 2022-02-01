import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/player/CMSPlayer$Companion;", "", "()V", "BRICK_ENGINE_FRAME_MINIMUM", "", "TAG", "", "TRACE_MODE_FRAME", "", "TRACE_MODE_RECORD", "adapterToBrickFrameInterval", "adapterToBrickSize", "density", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class amvh
{
  private final float a(float paramFloat)
  {
    paramFloat /= 1000.0F;
    if (paramFloat < 0.03333334F) {
      return 0.03333334F;
    }
    return paramFloat;
  }
  
  private final int a(int paramInt, float paramFloat)
  {
    if (paramInt < 0) {
      throw ((Throwable)new IllegalArgumentException("init CMSPlayer error. width or height:" + paramInt));
    }
    return (int)((float)Math.ceil(paramInt / paramFloat) * paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amvh
 * JD-Core Version:    0.7.0.1
 */