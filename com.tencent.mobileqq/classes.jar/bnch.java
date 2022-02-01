class bnch
  implements bnnz<Boolean, bnoe>
{
  bnch(bncf parambncf) {}
  
  public Void a(Boolean paramBoolean, bnoe parambnoe)
  {
    if ((!paramBoolean.booleanValue()) || (parambnoe == null) || (parambnoe.jdField_a_of_type_AndroidGraphicsBitmap == null))
    {
      xvv.e("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail error! thumbnail = (null)");
      return null;
    }
    xvv.b("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail index = %d", Integer.valueOf(parambnoe.jdField_a_of_type_Int));
    if (parambnoe.jdField_a_of_type_Int >= this.a.a.length)
    {
      xvv.e("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail index = %d OutOfArrayBounds", new Object[] { Integer.valueOf(parambnoe.jdField_a_of_type_Int) });
      return null;
    }
    xvv.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "thumbnailProgress index: %d thumbnail done!", Integer.valueOf(parambnoe.jdField_a_of_type_Int));
    this.a.a[parambnoe.jdField_a_of_type_Int] = bnci.a(this.a.a[parambnoe.jdField_a_of_type_Int], parambnoe.jdField_a_of_type_AndroidGraphicsBitmap);
    this.a.a[parambnoe.jdField_a_of_type_Int].jdField_a_of_type_JavaLangString = parambnoe.jdField_a_of_type_JavaLangString;
    this.a.k();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnch
 * JD-Core Version:    0.7.0.1
 */