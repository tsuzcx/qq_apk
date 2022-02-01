package com.tencent.avgame.gamelobby.rv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class BaseViewHolder$Factory
{
  public <VH extends BaseViewHolder<?>> VH a(int paramInt, @NonNull ViewGroup paramViewGroup, @NonNull Class<VH> paramClass)
  {
    try
    {
      try
      {
        Constructor localConstructor = paramClass.getDeclaredConstructor(new Class[] { View.class });
        localConstructor.setAccessible(true);
        paramViewGroup = (BaseViewHolder)localConstructor.newInstance(new Object[] { LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, paramViewGroup, false) });
        return paramViewGroup;
      }
      catch (InvocationTargetException paramViewGroup)
      {
        paramViewGroup.printStackTrace();
      }
      catch (InstantiationException paramViewGroup)
      {
        paramViewGroup.printStackTrace();
      }
      catch (IllegalAccessException paramViewGroup)
      {
        paramViewGroup.printStackTrace();
      }
      return null;
    }
    catch (NoSuchMethodException paramViewGroup)
    {
      paramViewGroup.printStackTrace();
      paramViewGroup = new StringBuilder();
      paramViewGroup.append(paramClass.getName());
      paramViewGroup.append(" has no match constructor!");
      throw new RuntimeException(paramViewGroup.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.rv.BaseViewHolder.Factory
 * JD-Core Version:    0.7.0.1
 */