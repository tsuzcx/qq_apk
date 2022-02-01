package com.tencent.biz.qqstory.takevideo.doodle.ui.face;

import java.io.File;
import java.io.FileFilter;

class NormalFacePackage$1
  implements FileFilter
{
  NormalFacePackage$1(NormalFacePackage paramNormalFacePackage) {}
  
  public boolean accept(File paramFile)
  {
    paramFile = paramFile.getName();
    return (paramFile.endsWith(".jpg")) || (paramFile.endsWith(".png")) || (paramFile.endsWith(".bmp"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.face.NormalFacePackage.1
 * JD-Core Version:    0.7.0.1
 */