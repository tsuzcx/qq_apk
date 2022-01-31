import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetFontDataRsp;

public abstract class bkzv
  implements alpg
{
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean, blbt paramblbt) {}
  
  protected void a(boolean paramBoolean, GetFontDataRsp paramGetFontDataRsp) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void b(boolean paramBoolean, int paramInt) {}
  
  public final void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      a(paramBoolean, (blbt)paramObject);
      return;
    case 2: 
      a(paramBoolean, ((Boolean)paramObject).booleanValue());
      return;
    case 3: 
      a(paramBoolean, ((Integer)paramObject).intValue());
      return;
    case 4: 
      a(paramBoolean, (GetFontDataRsp)paramObject);
      return;
    }
    b(paramBoolean, ((Integer)paramObject).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkzv
 * JD-Core Version:    0.7.0.1
 */