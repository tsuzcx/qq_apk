package com.tencent.aelight.camera.ae.data;

import java.io.Serializable;
import java.util.List;

public class AEGifCategoryWrapper
  implements Serializable
{
  public String categoryId = "";
  public String categoryName = "";
  public String fontId = "";
  public List<AEMaterialWrapper> materialWrapperList;
  public boolean selected;
  public boolean showCategory;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.data.AEGifCategoryWrapper
 * JD-Core Version:    0.7.0.1
 */