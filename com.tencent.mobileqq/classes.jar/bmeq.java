class bmeq
  implements bmve<Boolean, bmvj>
{
  bmeq(bmeo parambmeo) {}
  
  public Void a(Boolean paramBoolean, bmvj parambmvj)
  {
    if ((!paramBoolean.booleanValue()) || (parambmvj == null) || (parambmvj.jdField_a_of_type_AndroidGraphicsBitmap == null))
    {
      wsv.e("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail error! thumbnail = (null)");
      return null;
    }
    wsv.b("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail index = %d", Integer.valueOf(parambmvj.jdField_a_of_type_Int));
    if (parambmvj.jdField_a_of_type_Int >= this.a.a.length)
    {
      wsv.e("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail index = %d OutOfArrayBounds", new Object[] { Integer.valueOf(parambmvj.jdField_a_of_type_Int) });
      return null;
    }
    wsv.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "thumbnailProgress index: %d thumbnail done!", Integer.valueOf(parambmvj.jdField_a_of_type_Int));
    this.a.a[parambmvj.jdField_a_of_type_Int] = bmer.a(this.a.a[parambmvj.jdField_a_of_type_Int], parambmvj.jdField_a_of_type_AndroidGraphicsBitmap);
    this.a.a[parambmvj.jdField_a_of_type_Int].jdField_a_of_type_JavaLangString = parambmvj.jdField_a_of_type_JavaLangString;
    this.a.j();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmeq
 * JD-Core Version:    0.7.0.1
 */