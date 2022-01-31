package com.tencent.biz.qqstory.takevideo.dancemachine;

public class DanceMachinePKManager
{
  private static volatile DanceMachinePKManager jdField_a_of_type_ComTencentBizQqstoryTakevideoDancemachineDanceMachinePKManager;
  private DanceMachinePKManager.PKButtonClickListener jdField_a_of_type_ComTencentBizQqstoryTakevideoDancemachineDanceMachinePKManager$PKButtonClickListener;
  
  public static DanceMachinePKManager a()
  {
    if (jdField_a_of_type_ComTencentBizQqstoryTakevideoDancemachineDanceMachinePKManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizQqstoryTakevideoDancemachineDanceMachinePKManager == null) {
        jdField_a_of_type_ComTencentBizQqstoryTakevideoDancemachineDanceMachinePKManager = new DanceMachinePKManager();
      }
      return jdField_a_of_type_ComTencentBizQqstoryTakevideoDancemachineDanceMachinePKManager;
    }
    finally {}
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDancemachineDanceMachinePKManager$PKButtonClickListener = null;
  }
  
  public void a(DanceMachinePKManager.PKButtonClickListener paramPKButtonClickListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDancemachineDanceMachinePKManager$PKButtonClickListener = paramPKButtonClickListener;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDancemachineDanceMachinePKManager$PKButtonClickListener != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDancemachineDanceMachinePKManager$PKButtonClickListener.a(paramString1, paramString2);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDancemachineDanceMachinePKManager$PKButtonClickListener != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDancemachineDanceMachinePKManager$PKButtonClickListener.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.dancemachine.DanceMachinePKManager
 * JD-Core Version:    0.7.0.1
 */