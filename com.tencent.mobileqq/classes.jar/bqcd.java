class bqcd
  implements bqsr<Boolean, bqsw>
{
  bqcd(bqcb parambqcb) {}
  
  public Void a(Boolean paramBoolean, bqsw parambqsw)
  {
    if ((!paramBoolean.booleanValue()) || (parambqsw == null) || (parambqsw.jdField_a_of_type_AndroidGraphicsBitmap == null))
    {
      yuk.e("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail error! thumbnail = (null)");
      return null;
    }
    yuk.b("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail index = %d", Integer.valueOf(parambqsw.jdField_a_of_type_Int));
    if (parambqsw.jdField_a_of_type_Int >= this.a.a.length)
    {
      yuk.e("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail index = %d OutOfArrayBounds", new Object[] { Integer.valueOf(parambqsw.jdField_a_of_type_Int) });
      return null;
    }
    yuk.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "thumbnailProgress index: %d thumbnail done!", Integer.valueOf(parambqsw.jdField_a_of_type_Int));
    this.a.a[parambqsw.jdField_a_of_type_Int] = bqce.a(this.a.a[parambqsw.jdField_a_of_type_Int], parambqsw.jdField_a_of_type_AndroidGraphicsBitmap);
    this.a.a[parambqsw.jdField_a_of_type_Int].jdField_a_of_type_JavaLangString = parambqsw.jdField_a_of_type_JavaLangString;
    this.a.j();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqcd
 * JD-Core Version:    0.7.0.1
 */