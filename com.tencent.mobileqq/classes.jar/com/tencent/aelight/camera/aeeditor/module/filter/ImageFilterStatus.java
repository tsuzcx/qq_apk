package com.tencent.aelight.camera.aeeditor.module.filter;

import com.tencent.aelight.camera.aeeditor.module.aifilter.AIFilterResult;
import com.tencent.aelight.camera.aeeditor.module.aifilter.ComicsFilterResult;

public class ImageFilterStatus
{
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int = -1;
  private AIFilterResult jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAifilterAIFilterResult;
  private ComicsFilterResult jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAifilterComicsFilterResult;
  private AEEditorFilterBean.FilterID jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterBean$FilterID = AEEditorFilterBean.FilterID.NON;
  private String jdField_a_of_type_JavaLangString = null;
  private int b = -1;
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public int a()
  {
    return this.b;
  }
  
  public AIFilterResult a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAifilterAIFilterResult;
  }
  
  public ComicsFilterResult a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAifilterComicsFilterResult;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_a_of_type_Int = this.b;
    this.b = -1;
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterBean$FilterID = AEEditorFilterBean.FilterID.NON;
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(AIFilterResult paramAIFilterResult)
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAifilterAIFilterResult = paramAIFilterResult;
    this.jdField_a_of_type_Int = this.b;
    this.b = AEEditorFilterControlPanel.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterBean$FilterID = AEEditorFilterBean.FilterID.AIFilter;
  }
  
  public void a(ComicsFilterResult paramComicsFilterResult, int paramInt)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAifilterComicsFilterResult = paramComicsFilterResult;
    this.jdField_a_of_type_Int = this.b;
    this.b = paramInt;
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterBean$FilterID = AEEditorFilterBean.FilterID.NETWORK;
  }
  
  public void a(String paramString, float paramFloat, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_Int = this.b;
    this.b = paramInt;
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterBean$FilterID = AEEditorFilterBean.FilterID.CLIENT;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterBean$FilterID == AEEditorFilterBean.FilterID.NON;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterBean$FilterID == AEEditorFilterBean.FilterID.AIFilter;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterBean$FilterID == AEEditorFilterBean.FilterID.NETWORK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.filter.ImageFilterStatus
 * JD-Core Version:    0.7.0.1
 */