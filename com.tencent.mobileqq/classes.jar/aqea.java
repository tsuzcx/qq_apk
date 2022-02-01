class aqea
{
  static final float[] a;
  
  static
  {
    int k = 0;
    a = new float[8192];
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= 8192) {
        break;
      }
      a[i] = ((float)Math.sin((i + 0.5F) / 8192.0F * 6.283186F));
      i += 1;
    }
    while (j < 360)
    {
      a[((int)(j * 22.755556F) & 0x1FFF)] = ((float)Math.sin(j * 0.01745329F));
      j += 90;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqea
 * JD-Core Version:    0.7.0.1
 */