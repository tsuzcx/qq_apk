package com.google.android.filament;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import com.google.android.filament.proguard.UsedByNative;
import java.util.List;

@UsedByNative("Material.cpp")
public class Material$Parameter
{
  @UsedByNative("Material.cpp")
  private static final int SAMPLER_OFFSET = Material.Parameter.Type.MAT4.ordinal() + 1;
  @IntRange(from=1L)
  public final int count;
  @NonNull
  public final String name;
  @NonNull
  public final Material.Parameter.Precision precision;
  @NonNull
  public final Material.Parameter.Type type;
  
  private Material$Parameter(@NonNull String paramString, @NonNull Material.Parameter.Type paramType, @NonNull Material.Parameter.Precision paramPrecision, @IntRange(from=1L) int paramInt)
  {
    this.name = paramString;
    this.type = paramType;
    this.precision = paramPrecision;
    this.count = paramInt;
  }
  
  @UsedByNative("Material.cpp")
  private static void add(@NonNull List<Parameter> paramList, @NonNull String paramString, @IntRange(from=0L) int paramInt1, @IntRange(from=0L) int paramInt2, @IntRange(from=1L) int paramInt3)
  {
    paramList.add(new Parameter(paramString, Material.Parameter.Type.values()[paramInt1], Material.Parameter.Precision.values()[paramInt2], paramInt3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.filament.Material.Parameter
 * JD-Core Version:    0.7.0.1
 */