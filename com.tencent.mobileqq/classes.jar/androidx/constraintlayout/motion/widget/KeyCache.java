package androidx.constraintlayout.motion.widget;

import java.util.Arrays;
import java.util.HashMap;

public class KeyCache
{
  HashMap<Object, HashMap<String, float[]>> map = new HashMap();
  
  float getFloatValue(Object paramObject, String paramString, int paramInt)
  {
    if (!this.map.containsKey(paramObject)) {
      return (0.0F / 0.0F);
    }
    paramObject = (HashMap)this.map.get(paramObject);
    if (!paramObject.containsKey(paramString)) {
      return (0.0F / 0.0F);
    }
    paramObject = (float[])paramObject.get(paramString);
    if (paramObject.length > paramInt) {
      return paramObject[paramInt];
    }
    return (0.0F / 0.0F);
  }
  
  void setFloatValue(Object paramObject, String paramString, int paramInt, float paramFloat)
  {
    if (!this.map.containsKey(paramObject))
    {
      localObject1 = new HashMap();
      localObject2 = new float[paramInt + 1];
      localObject2[paramInt] = paramFloat;
      ((HashMap)localObject1).put(paramString, localObject2);
      this.map.put(paramObject, localObject1);
      return;
    }
    Object localObject2 = (HashMap)this.map.get(paramObject);
    if (!((HashMap)localObject2).containsKey(paramString))
    {
      localObject1 = new float[paramInt + 1];
      localObject1[paramInt] = paramFloat;
      ((HashMap)localObject2).put(paramString, localObject1);
      this.map.put(paramObject, localObject2);
      return;
    }
    Object localObject1 = (float[])((HashMap)localObject2).get(paramString);
    paramObject = localObject1;
    if (localObject1.length <= paramInt) {
      paramObject = Arrays.copyOf((float[])localObject1, paramInt + 1);
    }
    paramObject[paramInt] = paramFloat;
    ((HashMap)localObject2).put(paramString, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.motion.widget.KeyCache
 * JD-Core Version:    0.7.0.1
 */