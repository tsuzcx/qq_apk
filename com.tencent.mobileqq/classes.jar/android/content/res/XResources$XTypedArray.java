package android.content.res;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import de.robv.android.xposed.XposedBridge;
import xposed.dummy.XTypedArraySuperClass;

public class XResources$XTypedArray
  extends XTypedArraySuperClass
{
  private XResources$XTypedArray()
  {
    super(null, null, null, 0);
    throw new UnsupportedOperationException();
  }
  
  public boolean getBoolean(int paramInt, boolean paramBoolean)
  {
    Object localObject = XResources.access$400((XResources)getResources(), getResourceId(paramInt, 0));
    if ((localObject instanceof Boolean)) {
      return ((Boolean)localObject).booleanValue();
    }
    if ((localObject instanceof XResForwarder)) {
      return ((XResForwarder)localObject).getResources().getBoolean(((XResForwarder)localObject).getId());
    }
    return super.getBoolean(paramInt, paramBoolean);
  }
  
  public int getColor(int paramInt1, int paramInt2)
  {
    Object localObject = XResources.access$400((XResources)getResources(), getResourceId(paramInt1, 0));
    if ((localObject instanceof Integer)) {
      return ((Integer)localObject).intValue();
    }
    if ((localObject instanceof XResForwarder)) {
      return ((XResForwarder)localObject).getResources().getColor(((XResForwarder)localObject).getId());
    }
    return super.getColor(paramInt1, paramInt2);
  }
  
  public ColorStateList getColorStateList(int paramInt)
  {
    Object localObject1 = XResources.access$400((XResources)getResources(), getResourceId(paramInt, 0));
    if ((localObject1 instanceof ColorStateList)) {
      return (ColorStateList)localObject1;
    }
    if ((localObject1 instanceof Integer))
    {
      paramInt = ((Integer)localObject1).intValue();
      synchronized (XResources.access$500())
      {
        ColorStateList localColorStateList = (ColorStateList)XResources.access$500().get(paramInt);
        localObject1 = localColorStateList;
        if (localColorStateList == null)
        {
          localObject1 = ColorStateList.valueOf(paramInt);
          XResources.access$500().put(paramInt, localObject1);
        }
        return localObject1;
      }
    }
    if ((localObject2 instanceof XResForwarder)) {
      return ((XResForwarder)localObject2).getResources().getColorStateList(((XResForwarder)localObject2).getId());
    }
    return super.getColorStateList(paramInt);
  }
  
  public float getDimension(int paramInt, float paramFloat)
  {
    Object localObject = XResources.access$400((XResources)getResources(), getResourceId(paramInt, 0));
    if ((localObject instanceof XResForwarder)) {
      return ((XResForwarder)localObject).getResources().getDimension(((XResForwarder)localObject).getId());
    }
    return super.getDimension(paramInt, paramFloat);
  }
  
  public int getDimensionPixelOffset(int paramInt1, int paramInt2)
  {
    Object localObject = XResources.access$400((XResources)getResources(), getResourceId(paramInt1, 0));
    if ((localObject instanceof XResForwarder)) {
      return ((XResForwarder)localObject).getResources().getDimensionPixelOffset(((XResForwarder)localObject).getId());
    }
    return super.getDimensionPixelOffset(paramInt1, paramInt2);
  }
  
  public int getDimensionPixelSize(int paramInt1, int paramInt2)
  {
    Object localObject = XResources.access$400((XResources)getResources(), getResourceId(paramInt1, 0));
    if ((localObject instanceof XResForwarder)) {
      return ((XResForwarder)localObject).getResources().getDimensionPixelSize(((XResForwarder)localObject).getId());
    }
    return super.getDimensionPixelSize(paramInt1, paramInt2);
  }
  
  public Drawable getDrawable(int paramInt)
  {
    int i = getResourceId(paramInt, 0);
    Object localObject1 = (XResources)getResources();
    Object localObject2 = XResources.access$400((XResources)localObject1, i);
    if ((localObject2 instanceof XResources.DrawableLoader)) {
      try
      {
        localObject1 = ((XResources.DrawableLoader)localObject2).newDrawable((XResources)localObject1, i);
        if (localObject1 != null) {
          return localObject1;
        }
      }
      catch (Throwable localThrowable)
      {
        XposedBridge.log(localThrowable);
      }
    }
    do
    {
      return super.getDrawable(paramInt);
      if ((localObject2 instanceof Integer)) {
        return new ColorDrawable(((Integer)localObject2).intValue());
      }
    } while (!(localObject2 instanceof XResForwarder));
    return ((XResForwarder)localObject2).getResources().getDrawable(((XResForwarder)localObject2).getId());
  }
  
  public float getFloat(int paramInt, float paramFloat)
  {
    Object localObject = XResources.access$400((XResources)getResources(), getResourceId(paramInt, 0));
    if ((localObject instanceof XResForwarder)) {
      return ((XResForwarder)localObject).getResources().getDimension(((XResForwarder)localObject).getId());
    }
    return super.getFloat(paramInt, paramFloat);
  }
  
  public float getFraction(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    Object localObject = XResources.access$400((XResources)getResources(), getResourceId(paramInt1, 0));
    if ((localObject instanceof XResForwarder)) {
      return ((XResForwarder)localObject).getResources().getFraction(((XResForwarder)localObject).getId(), paramInt2, paramInt3);
    }
    return super.getFraction(paramInt1, paramInt2, paramInt3, paramFloat);
  }
  
  public int getInt(int paramInt1, int paramInt2)
  {
    Object localObject = XResources.access$400((XResources)getResources(), getResourceId(paramInt1, 0));
    if ((localObject instanceof Integer)) {
      return ((Integer)localObject).intValue();
    }
    if ((localObject instanceof XResForwarder)) {
      return ((XResForwarder)localObject).getResources().getInteger(((XResForwarder)localObject).getId());
    }
    return super.getInt(paramInt1, paramInt2);
  }
  
  public int getInteger(int paramInt1, int paramInt2)
  {
    Object localObject = XResources.access$400((XResources)getResources(), getResourceId(paramInt1, 0));
    if ((localObject instanceof Integer)) {
      return ((Integer)localObject).intValue();
    }
    if ((localObject instanceof XResForwarder)) {
      return ((XResForwarder)localObject).getResources().getInteger(((XResForwarder)localObject).getId());
    }
    return super.getInteger(paramInt1, paramInt2);
  }
  
  public int getLayoutDimension(int paramInt1, int paramInt2)
  {
    Object localObject = XResources.access$400((XResources)getResources(), getResourceId(paramInt1, 0));
    if ((localObject instanceof XResForwarder)) {
      return ((XResForwarder)localObject).getResources().getDimensionPixelSize(((XResForwarder)localObject).getId());
    }
    return super.getLayoutDimension(paramInt1, paramInt2);
  }
  
  public int getLayoutDimension(int paramInt, String paramString)
  {
    Object localObject = XResources.access$400((XResources)getResources(), getResourceId(paramInt, 0));
    if ((localObject instanceof XResForwarder)) {
      return ((XResForwarder)localObject).getResources().getDimensionPixelSize(((XResForwarder)localObject).getId());
    }
    return super.getLayoutDimension(paramInt, paramString);
  }
  
  public String getString(int paramInt)
  {
    Object localObject = XResources.access$400((XResources)getResources(), getResourceId(paramInt, 0));
    if ((localObject instanceof CharSequence)) {
      return localObject.toString();
    }
    if ((localObject instanceof XResForwarder)) {
      return ((XResForwarder)localObject).getResources().getString(((XResForwarder)localObject).getId());
    }
    return super.getString(paramInt);
  }
  
  public CharSequence getText(int paramInt)
  {
    Object localObject = XResources.access$400((XResources)getResources(), getResourceId(paramInt, 0));
    if ((localObject instanceof CharSequence)) {
      return (CharSequence)localObject;
    }
    if ((localObject instanceof XResForwarder)) {
      return ((XResForwarder)localObject).getResources().getText(((XResForwarder)localObject).getId());
    }
    return super.getText(paramInt);
  }
  
  public CharSequence[] getTextArray(int paramInt)
  {
    Object localObject = XResources.access$400((XResources)getResources(), getResourceId(paramInt, 0));
    if ((localObject instanceof CharSequence[])) {
      return (CharSequence[])localObject;
    }
    if ((localObject instanceof XResForwarder)) {
      return ((XResForwarder)localObject).getResources().getTextArray(((XResForwarder)localObject).getId());
    }
    return super.getTextArray(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     android.content.res.XResources.XTypedArray
 * JD-Core Version:    0.7.0.1
 */