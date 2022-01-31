package com.google.android.filament;

public class Filament
{
  public static void init()
  {
    Platform.get();
    System.loadLibrary("filament-jni");
  }
  
  public static void initBeforeSoLoaded()
  {
    Platform.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.google.android.filament.Filament
 * JD-Core Version:    0.7.0.1
 */