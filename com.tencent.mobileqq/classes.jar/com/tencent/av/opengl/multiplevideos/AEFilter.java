package com.tencent.av.opengl.multiplevideos;

import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.AIAttrProvider;
import com.tencent.av.opengl.multiplevideos.renderbase.Filter;

public class AEFilter
  extends Filter
{
  private AIAttr jdField_a_of_type_ComTencentAekitPluginCoreAIAttr;
  private final String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private boolean d;
  
  public AEFilter()
  {
    super(1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AEFilter-");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    this.jdField_a_of_type_ComTencentAekitPluginCoreAIAttr = new AIAttr(new AIAttrProvider(null));
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
    this.c = false;
    this.d = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.multiplevideos.AEFilter
 * JD-Core Version:    0.7.0.1
 */