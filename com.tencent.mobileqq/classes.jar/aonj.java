import dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.FilterFactory;
import dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUDrawPartFilter;
import dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup;

public class aonj
  implements Runnable
{
  public aonj(GpuImagePartsFilterGroup paramGpuImagePartsFilterGroup, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat) {}
  
  public void run()
  {
    GPUDrawPartFilter localGPUDrawPartFilter2 = null;
    GPUDrawPartFilter localGPUDrawPartFilter1;
    if ((GpuImagePartsFilterGroup.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup) == null) || (GpuImagePartsFilterGroup.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup).b() != this.jdField_a_of_type_Int))
    {
      localGPUDrawPartFilter1 = GpuImagePartsFilterGroup.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup);
      GpuImagePartsFilterGroup.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup, (GPUDrawPartFilter)FilterFactory.a(this.jdField_a_of_type_Int));
      GpuImagePartsFilterGroup.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup).a();
      GpuImagePartsFilterGroup.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup).a(this.b, this.c);
    }
    for (;;)
    {
      if ((GpuImagePartsFilterGroup.b(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup) == null) || (GpuImagePartsFilterGroup.b(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup).b() != this.d))
      {
        localGPUDrawPartFilter2 = GpuImagePartsFilterGroup.b(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup);
        GpuImagePartsFilterGroup.b(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup, (GPUDrawPartFilter)FilterFactory.a(this.d));
        GpuImagePartsFilterGroup.b(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup).a();
        GpuImagePartsFilterGroup.b(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup).a(this.b, this.c);
      }
      if ((this.e == 90) || (this.e == 270))
      {
        GpuImagePartsFilterGroup.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup).a(false);
        GpuImagePartsFilterGroup.b(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup).a(false);
      }
      for (;;)
      {
        GpuImagePartsFilterGroup.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup, this.jdField_a_of_type_Float);
        GpuImagePartsFilterGroup.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup).a(true, this.jdField_a_of_type_Float + 0.1F);
        GpuImagePartsFilterGroup.b(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup).a(false, this.jdField_a_of_type_Float - 0.1F);
        if (localGPUDrawPartFilter1 != null) {
          localGPUDrawPartFilter1.c();
        }
        if (localGPUDrawPartFilter2 != null) {
          localGPUDrawPartFilter2.c();
        }
        return;
        GpuImagePartsFilterGroup.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup).a(true);
        GpuImagePartsFilterGroup.b(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup).a(true);
      }
      localGPUDrawPartFilter1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aonj
 * JD-Core Version:    0.7.0.1
 */