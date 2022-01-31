import dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.FilterFactory;
import dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUDrawPartFilter;
import dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup;

public class aoni
  implements Runnable
{
  public aoni(GpuImagePartsFilterGroup paramGpuImagePartsFilterGroup, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    GPUDrawPartFilter localGPUDrawPartFilter1 = null;
    GPUDrawPartFilter localGPUDrawPartFilter2 = GpuImagePartsFilterGroup.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup);
    GpuImagePartsFilterGroup.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup, null);
    if ((GpuImagePartsFilterGroup.b(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup) == null) || (GpuImagePartsFilterGroup.b(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup).b() != this.jdField_a_of_type_Int))
    {
      localGPUDrawPartFilter1 = GpuImagePartsFilterGroup.b(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup);
      GpuImagePartsFilterGroup.b(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup, (GPUDrawPartFilter)FilterFactory.a(this.jdField_a_of_type_Int));
      GpuImagePartsFilterGroup.b(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup).a();
      GpuImagePartsFilterGroup.b(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup).a(this.b, this.c);
    }
    GpuImagePartsFilterGroup.b(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup).a(false, 0.0F);
    GpuImagePartsFilterGroup.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup, 0.0F);
    if (localGPUDrawPartFilter2 != null) {
      localGPUDrawPartFilter2.c();
    }
    if (localGPUDrawPartFilter1 != null) {
      localGPUDrawPartFilter1.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoni
 * JD-Core Version:    0.7.0.1
 */