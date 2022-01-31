import com.tencent.upload.uinterface.data.UpsImageUploadTask;

public class awqb
  extends awpz
{
  public long b;
  public byte[] c;
  public int g;
  public int h;
  public int i;
  public String i;
  public int j;
  public String j;
  public int k;
  protected String k;
  public int l = 1;
  
  public awqb(long paramLong, String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    super(paramLong, paramString1, paramArrayOfByte);
    this.jdField_g_of_type_Int = 13;
    this.jdField_k_of_type_Int = 3;
    this.jdField_k_of_type_JavaLangString = paramString2;
  }
  
  public awpz a()
  {
    UpsImageUploadTask localUpsImageUploadTask = new UpsImageUploadTask(this.jdField_g_of_type_JavaLangString);
    localUpsImageUploadTask.dataType = this.jdField_g_of_type_Int;
    localUpsImageUploadTask.fileId = this.jdField_i_of_type_JavaLangString;
    localUpsImageUploadTask.flowId = this.jdField_e_of_type_Int;
    localUpsImageUploadTask.iBatchID = this.b;
    localUpsImageUploadTask.iBatchUploadCount = this.jdField_h_of_type_Int;
    localUpsImageUploadTask.iBusiNessType = this.jdField_i_of_type_Int;
    localUpsImageUploadTask.iCurrentUploadOrder = this.jdField_j_of_type_Int;
    localUpsImageUploadTask.iSync = this.jdField_c_of_type_Int;
    localUpsImageUploadTask.iUin = this.jdField_a_of_type_Long;
    localUpsImageUploadTask.iUploadType = this.jdField_k_of_type_Int;
    localUpsImageUploadTask.keepRaw = this.l;
    localUpsImageUploadTask.md5 = this.jdField_h_of_type_JavaLangString;
    localUpsImageUploadTask.preupload = this.jdField_d_of_type_Int;
    localUpsImageUploadTask.reportRefer = this.jdField_d_of_type_JavaLangString;
    localUpsImageUploadTask.sBusinessId = this.jdField_k_of_type_JavaLangString;
    localUpsImageUploadTask.sCommand = this.jdField_j_of_type_JavaLangString;
    localUpsImageUploadTask.sRefer = this.jdField_e_of_type_JavaLangString;
    localUpsImageUploadTask.transferData = this.jdField_a_of_type_JavaUtilMap;
    localUpsImageUploadTask.uiRefer = this.f;
    localUpsImageUploadTask.uploadTaskCallback = this.jdField_a_of_type_ComTencentUploadUinterfaceIUploadTaskCallback;
    localUpsImageUploadTask.vBusiNessData = this.jdField_c_of_type_ArrayOfByte;
    localUpsImageUploadTask.vLoginData = this.jdField_a_of_type_ArrayOfByte;
    this.jdField_a_of_type_ComTencentUploadUinterfaceAbstractUploadTask = localUpsImageUploadTask;
    return this;
  }
  
  protected void a(int paramInt, Object... paramVarArgs) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awqb
 * JD-Core Version:    0.7.0.1
 */